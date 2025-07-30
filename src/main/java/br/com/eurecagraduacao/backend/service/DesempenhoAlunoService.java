package br.com.eurecagraduacao.backend.service;

import br.com.eurecagraduacao.backend.dto.backend.desempenhoAluno.MetricaFdaDTO;
import br.com.eurecagraduacao.backend.dto.backend.desempenhoAluno.PontoFdaDTO;
import br.com.eurecagraduacao.backend.dto.backend.desempenhoAluno.ResultadoFdaDTO;
import br.com.eurecagraduacao.backend.dto.eureca.StudentDTO;
import br.com.eurecagraduacao.backend.model.sig.StudentSigModel;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

import static br.com.eurecagraduacao.backend.util.Constants.dasSigUrl;

@Service
public class DesempenhoAlunoService {

    private final RestTemplate restTemplate;

    public DesempenhoAlunoService() {
        this.restTemplate = new RestTemplate();
    }

    public ResultadoFdaDTO calcularFdas(Integer codigoCurso, Integer codigoCurriculo, StudentDTO alunoAtual) {
        List<StudentDTO> estudantes = buscarEstudantesAtivos(codigoCurso, codigoCurriculo);

        List<StudentDTO> ativos = estudantes.stream()
                .filter(a -> "ATIVO".equalsIgnoreCase(a.getSituacao()))
                .toList();

        MetricaFdaDTO craFda = calcularMetricaFda(ativos, StudentDTO::getCra, alunoAtual.getCra());
        MetricaFdaDTO velocidadeFda = calcularMetricaFda(ativos, StudentDTO::getVelocidadeMedia, alunoAtual.getVelocidadeMedia());
        MetricaFdaDTO taxaFda = calcularMetricaFda(ativos, StudentDTO::getTaxaDeSucesso, alunoAtual.getTaxaDeSucesso());

        ResultadoFdaDTO resultado = new ResultadoFdaDTO();
        resultado.setCra(craFda);
        resultado.setVelocidadeMedia(velocidadeFda);
        resultado.setTaxaDeSucesso(taxaFda);

        return resultado;
    }

    private MetricaFdaDTO calcularMetricaFda(List<StudentDTO> alunos,
                                             Function<StudentDTO, Double> extrator,
                                             Double valorDoAluno) {

        List<Double> valores = alunos.stream()
                .map(extrator)
                .filter(Objects::nonNull)
                .sorted()
                .toList();

        int total = valores.size();
        if (total == 0) {
            MetricaFdaDTO metricaVazia = new MetricaFdaDTO();
            metricaVazia.setFda(List.of());
            metricaVazia.setValorDoAluno(valorDoAluno);
            metricaVazia.setPercentil(0.0);
            return metricaVazia;
        }

        List<PontoFdaDTO> fda = new ArrayList<>();
        double countAcumulado = 0;
        Double valorAnterior = null;

        for (int i = 0; i < total; i++) {
            Double valorAtual = valores.get(i);
            if (!valorAtual.equals(valorAnterior)) {
                countAcumulado = i + 1;
                double probAcumulada = countAcumulado / total;
                fda.add(new PontoFdaDTO(valorAtual, probAcumulada));
                valorAnterior = valorAtual;
            }
        }

        long menoresOuIguais = valores.stream().filter(v -> v <= valorDoAluno).count();
        double percentil = (double) menoresOuIguais / total;

        MetricaFdaDTO metrica = new MetricaFdaDTO();
        metrica.setFda(fda);
        metrica.setValorDoAluno(valorDoAluno);
        metrica.setPercentil(percentil);

        return metrica;
    }


    public List<StudentDTO> buscarEstudantesAtivos(Integer codigoDoCurso, Integer codigoDoCurriculo) {
        String url = dasSigUrl +
                "/estudantes?curso=" + codigoDoCurso +
                "&curriculo=" + codigoDoCurriculo;

        try {
            ResponseEntity<List<StudentSigModel>> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<>() {}
            );

            List<StudentSigModel> estudantes = response.getBody();
            if (estudantes == null) return List.of();

            return estudantes.stream()
                    .map(StudentDTO::fromSigModel)
                    .toList();

        } catch (HttpClientErrorException e) {
            if (e.getStatusCode().value() == 404) {
                return List.of();
            } else {
                throw e;
            }
        }
    }
}
