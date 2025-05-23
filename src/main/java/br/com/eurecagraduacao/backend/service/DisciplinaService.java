package br.com.eurecagraduacao.backend.service;

import br.com.eurecagraduacao.backend.dto.backend.DisciplinaDistribuicaoNotasDTO;
import br.com.eurecagraduacao.backend.dto.backend.DisciplinaDistribuicaoStatusDTO;
import br.com.eurecagraduacao.backend.dto.backend.DisciplinaDistribuicaoPeriodosDTO;
import br.com.eurecagraduacao.backend.dto.backend.MetricasDisciplinaDTO;
import br.com.eurecagraduacao.backend.dto.eureca.EnrollmentDTO;
import br.com.eurecagraduacao.backend.dto.eureca.StudentDTO;
import br.com.eurecagraduacao.backend.model.eureca.EnrollmentModel;
import br.com.eurecagraduacao.backend.util.CalculoUtils;
import br.com.eurecagraduacao.backend.util.Constants;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static br.com.eurecagraduacao.backend.util.Constants.*;

@Service
public class DisciplinaService {
    private final String baseUrl = Constants.dasUrl;

    private final RestTemplate restTemplate;

    public DisciplinaService() {
        this.restTemplate = new RestTemplate();
    }

    public MetricasDisciplinaDTO buscarMetricasDisciplina(String codigoDoCurso, String disciplina) {
        List<EnrollmentDTO> matriculas = buscarMatriculas(codigoDoCurso, disciplina);
        Double mediaDeNotasDosAprovados = calcularMediaDeNotas(matriculas);
        DisciplinaDistribuicaoStatusDTO distribuicaoDeStatus = calcularDistribuicaoDeStatus(matriculas);

        MetricasDisciplinaDTO dto = new MetricasDisciplinaDTO();
        dto.setMediaDeNotasDosAprovados(mediaDeNotasDosAprovados);
        dto.setDistribuicaoDeStatus(distribuicaoDeStatus);

        return dto;
    }


    private Double calcularMediaDeNotas(List<EnrollmentDTO> matriculas) {
        List<Double> notasDosAprovados = matriculas.stream()
                .filter(m -> "aprovado".equalsIgnoreCase(m.getStatus()) && m.getMediaFinal() != null)
                .map(EnrollmentDTO::getMediaFinal)
                .toList();

        double media = CalculoUtils.calcularMedia(notasDosAprovados);
        return CalculoUtils.round1(media);
    }

    private DisciplinaDistribuicaoStatusDTO calcularDistribuicaoDeStatus(List<EnrollmentDTO> matriculas) {
        int aprovadosPorNota = 0;
        int dispensados = 0;
        int reprovadosPorNota = 0;
        int reprovadosPorFalta = 0;
        int trancados = 0;
        int cancelados = 0;

        for (EnrollmentDTO matricula : matriculas) {
            String status = matricula.getStatus() != null ? matricula.getStatus().toLowerCase() : "";
            String tipo = matricula.getTipo() != null ? matricula.getTipo().toLowerCase() : "";

            switch (status) {
                case "aprovado":
                    if ("dispensa".equals(tipo)) {
                        dispensados++;
                    }else{
                    aprovadosPorNota++;
                    }
                    break;
                case "reprovado":
                    reprovadosPorNota++;
                    break;
                case "reprovado por falta":
                    reprovadosPorFalta++;
                    break;
                case "trancado":
                    trancados++;
                    break;
                case "cancelado":
                    cancelados++;
                    break;
                default: break;
            }
        }

        int total = aprovadosPorNota + dispensados + reprovadosPorNota +
                reprovadosPorFalta + trancados + cancelados;

        DisciplinaDistribuicaoStatusDTO dto = new DisciplinaDistribuicaoStatusDTO();
        dto.setAprovadosPorNota(aprovadosPorNota);
        dto.setDispensados(dispensados);
        dto.setReprovadosPorNota(reprovadosPorNota);
        dto.setReprovadosPorFalta(reprovadosPorFalta);
        dto.setTrancados(trancados);
        dto.setCancelados(cancelados);
        dto.setTotal(total);

        return dto;
    }

    private List<EnrollmentDTO> buscarMatriculas(String codigoDoCurso, String codigoDaDisciplina) {
        String url = baseUrl +
                "/matriculas" +
                "?periodo-de=" + periodoDeMetricasDisciplinas +
                "&periodo-ate=" + periodoAteMetricas +
                "&curso=" + codigoDoCurso +
                "&disciplina=" + codigoDaDisciplina;

        ResponseEntity<List<EnrollmentModel>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );

        List<EnrollmentModel> enrollmentModels = response.getBody();

        assert enrollmentModels != null;
        return enrollmentModels.stream()
                .map(EnrollmentDTO::fromModel)
                .toList();
    }



}
