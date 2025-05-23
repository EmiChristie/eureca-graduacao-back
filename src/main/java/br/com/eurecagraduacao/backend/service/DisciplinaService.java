package br.com.eurecagraduacao.backend.service;

import br.com.eurecagraduacao.backend.dto.backend.*;
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

import java.util.*;

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
        List<DisciplinaDistribuicaoNotasDTO> distribuicaoDeNotas = calcularDistribuicaoDeNotas(matriculas);
        List<DisciplinaDistribuicaoNotasFaixaDTO> distribuicaoDeNotasFaixa = calcularDistribuicaoDeNotasFaixa(matriculas);

        MetricasDisciplinaDTO dto = new MetricasDisciplinaDTO();
        dto.setMediaDeNotasDosAprovados(mediaDeNotasDosAprovados);
        dto.setDistribuicaoDeStatus(distribuicaoDeStatus);
        dto.setDistribuicaoDeNotas(distribuicaoDeNotas);
        dto.setDistribuicaoDeNotasFaixa(distribuicaoDeNotasFaixa);

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

    private List<DisciplinaDistribuicaoNotasDTO> calcularDistribuicaoDeNotas(List<EnrollmentDTO> matriculas) {
        Map<Double, Integer> frequenciaPorNota = new HashMap<>();

        List<EnrollmentDTO> comNota = matriculas.stream()
                .filter(e -> e.getMediaFinal() != null)
                .toList();

        int totalComNota = comNota.size();

        for (EnrollmentDTO e : comNota) {
            Double nota = CalculoUtils.round2(e.getMediaFinal());
            frequenciaPorNota.put(nota, frequenciaPorNota.getOrDefault(nota, 0) + 1);
        }

        List<DisciplinaDistribuicaoNotasDTO> distribuicao = new ArrayList<>();
        for (Map.Entry<Double, Integer> entry : frequenciaPorNota.entrySet()) {
            Double nota = entry.getKey();
            Integer quantidade = entry.getValue();
            Double porcentagem = CalculoUtils.round2((quantidade * 100.0) / totalComNota);

            DisciplinaDistribuicaoNotasDTO dto = new DisciplinaDistribuicaoNotasDTO();
            dto.setNota(nota);
            dto.setQuantidadeDeAlunos(quantidade);
            dto.setPorcentagemDeAlunos(porcentagem);

            distribuicao.add(dto);
        }

        distribuicao.sort(Comparator.comparing(DisciplinaDistribuicaoNotasDTO::getNota));

        return distribuicao;
    }

    private List<DisciplinaDistribuicaoNotasFaixaDTO> calcularDistribuicaoDeNotasFaixa(List<EnrollmentDTO> matriculas) {
        Map<String, Integer> faixaContagem = new HashMap<>();

        List<EnrollmentDTO> comNota = matriculas.stream()
                .filter(e -> e.getMediaFinal() != null)
                .toList();

        int totalComNota = comNota.size();

        for (EnrollmentDTO e : comNota) {
            double nota = CalculoUtils.round2(e.getMediaFinal());

            String faixa;
            if (nota == 10.0) {
                faixa = "10";
            } else {
                int base = (int) nota;
                faixa = base + " a " + base + ".9";
            }

            faixaContagem.put(faixa, faixaContagem.getOrDefault(faixa, 0) + 1);
        }

        List<DisciplinaDistribuicaoNotasFaixaDTO> distribuicao = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : faixaContagem.entrySet()) {
            String faixa = entry.getKey();
            Integer quantidade = entry.getValue();
            Double porcentagem = CalculoUtils.round2((quantidade * 100.0) / totalComNota);

            DisciplinaDistribuicaoNotasFaixaDTO dto = new DisciplinaDistribuicaoNotasFaixaDTO();
            dto.setFaixa(faixa);
            dto.setQuantidadeDeAlunos(quantidade);
            dto.setPorcentagemDeAlunos(porcentagem);

            distribuicao.add(dto);
        }

        distribuicao.sort(Comparator.comparing(dto -> {
            String faixa = dto.getFaixa();
            if ("10".equals(faixa)) return 100;
            return Integer.parseInt(faixa.split(" ")[0]);
        }));

        return distribuicao;
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
