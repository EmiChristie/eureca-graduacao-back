package br.com.eurecagraduacao.backend.service;

import br.com.eurecagraduacao.backend.dto.backend.DisciplinaReprovacaoDTO;
import br.com.eurecagraduacao.backend.dto.backend.TaxaSucessoDTO;
import br.com.eurecagraduacao.backend.dto.eureca.StudentDTO;
import br.com.eurecagraduacao.backend.model.eureca.EnrollmentModel;
import br.com.eurecagraduacao.backend.model.eureca.StudentModel;
import br.com.eurecagraduacao.backend.model.eureca.SubjectModel;
import br.com.eurecagraduacao.backend.util.Constants;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

import static br.com.eurecagraduacao.backend.util.Constants.periodoAte;
import static br.com.eurecagraduacao.backend.util.Constants.periodoDe;

@Service
public class MetricasCursoService {

    private final String baseUrl = Constants.dasUrl;
    private final RestTemplate restTemplate;

    public MetricasCursoService() {
        this.restTemplate = new RestTemplate();
    }

    public List<DisciplinaReprovacaoDTO> buscarDisciplinasQueMaisReprovam(Integer codigoDoCurso, Integer codigoDoCurriculo) {

        //atualmente calcula só das obrigatórias pra não demorar tanto
        String urlDisciplinas = baseUrl +
                "/disciplinas-por-curriculo" +
                "?curso=" + codigoDoCurso +
                "&curriculo=" + codigoDoCurriculo+
                "&tipo-da-disciplina=OBRIGATORIO";

        ResponseEntity<List<SubjectModel>> disciplinasResponse = restTemplate.exchange(
                urlDisciplinas,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {}
        );

        List<SubjectModel> disciplinas = disciplinasResponse.getBody();

        if (disciplinas == null || disciplinas.isEmpty()) {
            return List.of();
        }

        List<DisciplinaReprovacaoDTO> resultado = new ArrayList<>();

        for (SubjectModel disciplina : disciplinas) {
            try {
                String urlMatriculas = baseUrl +
                        "/matriculas" +
                        "?periodo-de=" + Constants.periodoDe +
                        "&periodo-ate=" + Constants.periodoAte +
                        "&curso=" + codigoDoCurso +
                        "&disciplina=" + disciplina.getCodigoDaDisciplina();

                ResponseEntity<List<EnrollmentModel>> matriculasResponse = restTemplate.exchange(
                        urlMatriculas,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<>() {}
                );

                List<EnrollmentModel> matriculas = matriculasResponse.getBody();

                if (matriculas != null && !matriculas.isEmpty()) {
                    long reprovacoes = matriculas.stream()
                            .filter(m -> m.getStatus() != null && m.getStatus().toLowerCase().contains("reprovado"))
                            .count();

                    if (reprovacoes > 0) {
                        resultado.add(new DisciplinaReprovacaoDTO(
                                disciplina.getCodigoDaDisciplina(),
                                disciplina.getNome(),
                                (int) reprovacoes
                        ));
                    }
                }

            } catch (HttpClientErrorException e) {
                if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                    continue;
                } else {
                    throw e;
                }
            }
        }

        return resultado.stream()
                .sorted(Comparator.comparingInt(DisciplinaReprovacaoDTO::getNumeroDeReprovacoes).reversed())
                .collect(Collectors.toList());
    }

    public TaxaSucessoDTO getTaxaDeSucesso(Integer codigoDoCurso) {
        List<StudentDTO> estudantes = buscarEstudantesGraduadosOuEvadidosPorCurso(codigoDoCurso);

        int graduados = 0;
        int evadidos = 0;
        Map<String, Integer> motivoEvasaoContador = new HashMap<>();

        for (StudentDTO estudante : estudantes) {
            String motivo = estudante.getMotivoDeEvasao();

            if ("GRADUADO".equalsIgnoreCase(motivo)) {
                graduados++;
            } else {
                evadidos++;
                if (motivo != null && !motivo.isBlank()) {
                    motivoEvasaoContador.merge(motivo, 1, Integer::sum);
                }
            }
        }

        int total = graduados + evadidos;
        double taxaDeSucesso = total > 0
                ? BigDecimal.valueOf((double) graduados / total)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue()
                : 0.0;

        String motivoMaisComum = motivoEvasaoContador.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);

        return new TaxaSucessoDTO(taxaDeSucesso, graduados, evadidos, motivoMaisComum);
    }

    private List<StudentDTO> buscarEstudantesGraduadosOuEvadidosPorCurso(Integer codigoDoCurso) {
        String url = baseUrl +
                "/estudantes" +
                "?periodo-de-evasao-de=" + periodoDe +
                "&periodo-de-evasao-ate=" + periodoAte +
                "&pagina=1&tamanho=10" + // para fins de teste
                "&curso=" + codigoDoCurso;

        try {
            ResponseEntity<List<StudentModel>> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<>() {}
            );

            List<StudentModel> estudantes = response.getBody();
            if (estudantes == null) {
                return List.of();
            }

            return estudantes.stream().map(StudentDTO::fromModel).toList();

        } catch (HttpClientErrorException e) {
            if (e.getStatusCode().value() == 404) {
                return List.of();
            } else {
                throw e;
            }
        }
    }
}
