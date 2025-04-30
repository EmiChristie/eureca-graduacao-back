package br.com.eurecagraduacao.backend.service;

import br.com.eurecagraduacao.backend.dto.backend.*;
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

    public TaxaSucessoDTO getTaxaDeSucessoSimples(Integer codigoDoCurso) {
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


    public MetricasCursoDTO getMetricasDeSucessoCompletas(Integer codigoDoCurso) {
        List<StudentDTO> estudantes = buscarEstudantesGraduadosOuEvadidosPorCurso(codigoDoCurso);
        List<StudentDTO> graduados = estudantes.stream().filter(e->e.getMotivoDeEvasao().equals("GRADUADO")).toList();
        List<StudentDTO> evadidos = estudantes.stream().filter(e->!(e.getMotivoDeEvasao().equals("GRADUADO"))).toList();

        int qtdTotal = estudantes.size();

        double taxaDeSucesso = qtdTotal > 0
                ? BigDecimal.valueOf((double) graduados.size() / qtdTotal)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue()
                : 0.0;

        int qtdMulheresGraduadas = graduados.stream().filter(e->e.getSexo().equals("FEMININO")).toArray().length;

        double pctMulheresGraduadas = !graduados.isEmpty()
                ? BigDecimal.valueOf((double) qtdMulheresGraduadas / graduados.size())
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue()
                : 0.0;

        List<MotivoDeEvasaoDTO> motivosDeEvasaoMaisComuns = getMotivosDeEvasaoMaisComuns(evadidos,3);

        List<QuantidadeRealPeriodosDTO> quantidadeRealPeriodos = calculaQuantidadeRealPeriodos(graduados);

        List<GraduadosEEvadidosPorPeriodoDTO> graduadosEEvadidosPorPeriodo = calculaGraduadosEEvadidosPorPeriodo(estudantes);

        int qtdMediaGraduadosPeriodo = !graduados.isEmpty()
                ? (int) BigDecimal.valueOf(graduados.size() / graduadosEEvadidosPorPeriodo.size())
                .setScale(0, RoundingMode.FLOOR)
                .doubleValue()
                : 0;

        int qtdMediaEvadidosPeriodo = !evadidos.isEmpty()
                ? (int) BigDecimal.valueOf(evadidos.size() / graduadosEEvadidosPorPeriodo.size())
                .setScale(0, RoundingMode.FLOOR)
                .doubleValue()
                : 0;

        int periodoMaisComumDeEvadir = calculaPeriodoMaisComumDeEvadir(evadidos)+1;
        
        int qtdMediaCreditosReprovados = calcularQtdMediaCreditosReprovados(estudantes);

        return new MetricasCursoDTO(
                codigoDoCurso,
                taxaDeSucesso,
                graduados.size(),
                evadidos.size(),
                qtdMulheresGraduadas,
                pctMulheresGraduadas,
                motivosDeEvasaoMaisComuns,
                quantidadeRealPeriodos,
                graduadosEEvadidosPorPeriodo,
                qtdMediaGraduadosPeriodo,
                qtdMediaEvadidosPeriodo,
                periodoMaisComumDeEvadir,
                qtdMediaCreditosReprovados);
    }

    private int calcularQtdMediaCreditosReprovados(List<StudentDTO> estudantes) {
        if (estudantes == null || estudantes.isEmpty()) {
            return 0;
        }

        Double media = estudantes.stream()
                .map(StudentDTO::getCreditosFalhados)
                .filter(Objects::nonNull)
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);

        return (int) Math.round(media);
    }


    private int calculaPeriodoMaisComumDeEvadir(List<StudentDTO> evadidos) {
        if (evadidos == null || evadidos.isEmpty()) {
            return 0;
        }

        return evadidos.stream()
                .filter(s -> s.getPeriodosCompletados() != null)
                .collect(Collectors.groupingBy(
                        StudentDTO::getPeriodosCompletados,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(0);
    }

    private List<GraduadosEEvadidosPorPeriodoDTO> calculaGraduadosEEvadidosPorPeriodo(List<StudentDTO> estudantes) {
        if (estudantes == null || estudantes.isEmpty()) {
            return List.of();
        }

        Map<String, int[]> mapaPorPeriodo = new HashMap<>();

        for (StudentDTO estudante : estudantes) {
            String periodo = estudante.getPeriodoDeEvasao();
            if (periodo == null || periodo.isBlank()) continue;

            String motivo = estudante.getMotivoDeEvasao();
            boolean graduado = "GRADUADO".equalsIgnoreCase(motivo);

            mapaPorPeriodo.putIfAbsent(periodo, new int[]{0, 0});
            if (graduado) {
                mapaPorPeriodo.get(periodo)[0]++; // graduados
            } else {
                mapaPorPeriodo.get(periodo)[1]++; // evadidos
            }
        }

        return mapaPorPeriodo.entrySet().stream()
                .map(entry -> {
                    String periodo = entry.getKey();
                    int[] contagem = entry.getValue();
                    int qtdGraduados = contagem[0];
                    int qtdEvadidos = contagem[1];
                    int total = qtdGraduados + qtdEvadidos;

                    double taxaDeSucesso = total > 0
                            ? BigDecimal.valueOf((double) qtdGraduados / total * 100)
                            .setScale(2, RoundingMode.HALF_UP).doubleValue()
                            : 0.0;

                    GraduadosEEvadidosPorPeriodoDTO dto = new GraduadosEEvadidosPorPeriodoDTO();
                    dto.setPeriodo(periodo);
                    dto.setQuantidadeGraduadosPeriodo(qtdGraduados);
                    dto.setQuantidadeEvadidosPeriodo(qtdEvadidos);
                    dto.setTaxaDeSucessoPeriodo(taxaDeSucesso);
                    return dto;
                })
                .sorted(Comparator.comparing(GraduadosEEvadidosPorPeriodoDTO::getPeriodo))
                .toList();
    }

    private List<QuantidadeRealPeriodosDTO> calculaQuantidadeRealPeriodos(List<StudentDTO> graduados) {
        int totalGraduados = graduados.size();

        if (totalGraduados == 0) {
            return List.of();
        }

        Map<Integer, Long> contagemPorPeriodo = graduados.stream()
                .filter(s -> s.getPeriodosCompletados() != null)
                .collect(Collectors.groupingBy(
                        StudentDTO::getPeriodosCompletados,
                        Collectors.counting()
                ));

        return contagemPorPeriodo.entrySet().stream()
                .map(entry -> {
                    int quantidadeDePeriodos = entry.getKey();
                    long quantidadeGraduados = entry.getValue();
                    double porcentagem = (double) quantidadeGraduados / totalGraduados * 100;

                    QuantidadeRealPeriodosDTO dto = new QuantidadeRealPeriodosDTO();
                    dto.setQuantidadeDePeriodos(quantidadeDePeriodos);
                    dto.setQuantidadeDeGraduados((int) quantidadeGraduados);
                    dto.setPorcentagemDeGraduados(
                            BigDecimal.valueOf(porcentagem).setScale(2, RoundingMode.HALF_UP).doubleValue()
                    );
                    return dto;
                })
                .sorted(Comparator.comparing(QuantidadeRealPeriodosDTO::getPorcentagemDeGraduados).reversed())
                .toList();
    }



    private List<MotivoDeEvasaoDTO> getMotivosDeEvasaoMaisComuns(List<StudentDTO> evadidos, int qtd) {
        int totalEvadidos = evadidos.size();

        if (totalEvadidos == 0) {
            return List.of();
        }

        Map<String, Long> contagemMotivos = evadidos.stream()
                .filter(e -> e.getMotivoDeEvasao() != null && !e.getMotivoDeEvasao().isBlank())
                .collect(Collectors.groupingBy(
                        StudentDTO::getMotivoDeEvasao,
                        Collectors.counting()
                ));

        return contagemMotivos.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(qtd)
                .map(entry -> {
                    MotivoDeEvasaoDTO dto = new MotivoDeEvasaoDTO();
                    dto.setMotivo(entry.getKey());
                    double porcentagem = (double) entry.getValue() / totalEvadidos * 100;
                    dto.setPorcentagemEvadidos(
                            BigDecimal.valueOf(porcentagem).setScale(2, RoundingMode.HALF_UP).doubleValue()
                    );
                    return dto;
                })
                .toList();
    }
}
