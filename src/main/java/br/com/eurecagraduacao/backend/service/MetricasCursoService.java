package br.com.eurecagraduacao.backend.service;

import br.com.eurecagraduacao.backend.dto.backend.*;
import br.com.eurecagraduacao.backend.dto.eureca.CurriculoDTO;
import br.com.eurecagraduacao.backend.dto.eureca.StudentDTO;
import br.com.eurecagraduacao.backend.model.eureca.EnrollmentModel;
import br.com.eurecagraduacao.backend.model.eureca.FullCurriculumModel;
import br.com.eurecagraduacao.backend.model.eureca.StudentModel;
import br.com.eurecagraduacao.backend.model.eureca.SubjectModel;
import br.com.eurecagraduacao.backend.util.CalculoUtils;
import br.com.eurecagraduacao.backend.util.Constants;
import br.com.eurecagraduacao.backend.util.SemestreUtils;
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

import static br.com.eurecagraduacao.backend.util.CalculoUtils.*;
import static br.com.eurecagraduacao.backend.util.Constants.*;
import static br.com.eurecagraduacao.backend.util.SemestreUtils.calcularNumeroPeriodo;

@Service
public class MetricasCursoService {

    private final String baseUrl = Constants.dasUrl;
    private final RestTemplate restTemplate;

    public MetricasCursoService() {
        this.restTemplate = new RestTemplate();
    }

    public List<DisciplinaReprovacaoDTO> buscarDisciplinasQueMaisReprovam(Integer codigoDoCurso, Integer codigoDoCurriculo) {

        String urlDisciplinas = baseUrl +
                "/disciplinas-por-curriculo" +
                "?curso=" + codigoDoCurso +
                "&curriculo=" + codigoDoCurriculo +
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
                        "?periodo-de=" + Constants.periodoDeDisciplinasReprovacao +
                        "&periodo-ate=" + Constants.periodoAteDisciplinasReprovacao +
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
                    long totalMatriculas = matriculas.size();
                    long reprovacoes = matriculas.stream()
                            .filter(m -> m.getStatus() != null && m.getStatus().toLowerCase().contains("reprovado"))
                            .count();

                    if (reprovacoes > 0) {
                        BigDecimal porcentagem = BigDecimal.valueOf((reprovacoes * 100.0) / totalMatriculas)
                                .setScale(2, RoundingMode.HALF_UP);

                        resultado.add(new DisciplinaReprovacaoDTO(
                                disciplina.getCodigoDaDisciplina(),
                                disciplina.getNome(),
                                (int) reprovacoes,
                                porcentagem // novo campo
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
                .sorted(Comparator.comparing(DisciplinaReprovacaoDTO::getPorcentagemDeReprovacoes)
                        .reversed())
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
                //"&pagina=1&tamanho=10" +  para fins de teste
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


    public MetricasCursoCompletasDTO getMetricasDeSucessoCompletas(Integer codigoDoCurso) {
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

        return new MetricasCursoCompletasDTO(
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
                    dto.setQuantidadeDePeriodos(quantidadeDePeriodos+"");
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

    private List<StudentDTO> buscarIngressantesPorPeriodo(Integer codigoDoCurso, String periodo) {
        String url = baseUrl +
                "/estudantes" +
                "?periodo-de-ingresso-de=" + periodo +
                "&periodo-de-ingresso-ate=" + periodo +
                //"&pagina=1&tamanho=10" +  para fins de teste
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

    public Map<String, List<StudentDTO>> getEstudantes(Integer curso) {
        String periodoAtual = periodoDeMetricas;
        Map<String, List<StudentDTO>> estudantesPorPeriodo = new LinkedHashMap<>(); // mantém ordem de inserção

        while (true) {
            List<StudentDTO> estudantes = buscarIngressantesPorPeriodo(curso, periodoAtual);

            if (estudantes.isEmpty()) {
                periodoAtual = SemestreUtils.proximoSemestre(periodoAtual);
                continue;
            }

            long total = estudantes.size();
            long ativos = estudantes.stream()
                    .filter(e -> e.getSituacao() != null && e.getSituacao().equalsIgnoreCase("ativo"))
                    .count();

            double porcentagemAtivos = (ativos * 100.0) / total;

            if (porcentagemAtivos > limiteAtivos) {
                break;
            }

            estudantesPorPeriodo.put(periodoAtual, estudantes);
            periodoAtual = SemestreUtils.proximoSemestre(periodoAtual);
        }

        return estudantesPorPeriodo;
    }

    public MetricasCursoDTO getMetricasCurso(Integer curso, Integer curriculo) {
        Map<String, List<StudentDTO>> estudantesPorPeriodo = getEstudantes(curso);
        List<CursoPeriodoMetricasDTO> metricas = new ArrayList<>();
        List<Double> taxasDeSucesso = new ArrayList<>();
        List<Double> taxasMulheres = new ArrayList<>();
        List<Double> porcentagensMulheresPorPeriodo = new ArrayList<>();

        int totalGraduados = 0;
        int totalMulheresGraduadas = 0;
        int totalAlunos = 0;
        int totalAtivos = 0;

        for (Map.Entry<String, List<StudentDTO>> entrada : estudantesPorPeriodo.entrySet()) {
            String periodo = entrada.getKey();
            List<StudentDTO> estudantes = entrada.getValue();

            Map<String, Integer> contagens = calculaGraduadosEvadidosEAtivos(estudantes);

            int total = estudantes.size();
            int ativos = contagens.getOrDefault("ativos", 0);
            int graduados = contagens.getOrDefault("graduados", 0);
            int evadidos = contagens.getOrDefault("evadidos", 0);
            int mulheresGraduadas = contagens.getOrDefault("mulheresGraduadas", 0);

            totalAlunos += total;
            totalAtivos += ativos;

            double taxaSucesso = total > 0 ? (graduados * 100.0) / total : 0.0;
            double taxaSucessoMulheres = total > 0 ? (mulheresGraduadas * 100.0) / total : 0.0;
            double taxaMulheresEntreGraduados = graduados > 0 ? (mulheresGraduadas * 100.0) / graduados : 0.0;

            taxasDeSucesso.add(taxaSucesso);
            taxasMulheres.add(taxaSucessoMulheres);
            if (taxaMulheresEntreGraduados > 0) {
                porcentagensMulheresPorPeriodo.add(taxaMulheresEntreGraduados);
            }

            totalGraduados += graduados;
            totalMulheresGraduadas += mulheresGraduadas;

            metricas.add(new CursoPeriodoMetricasDTO(
                    periodo,
                    ativos,
                    graduados,
                    evadidos,
                    mulheresGraduadas,
                    total
            ));
        }

        double mediaGeral = CalculoUtils.calcularMedia(taxasDeSucesso);
        double desvioGeral = CalculoUtils.calcularDesvioPadrao(taxasDeSucesso, mediaGeral);
        double percentualDesvioGeral = mediaGeral > 0 ? CalculoUtils.round2(desvioGeral) : 0.0;
        double mediaMulheres = CalculoUtils.calcularMedia(taxasMulheres);
        double desvioMulheres = CalculoUtils.calcularDesvioPadrao(taxasMulheres, mediaMulheres);
        double mediaMulheresEntreGraduados = CalculoUtils.calcularMedia(porcentagensMulheresPorPeriodo);
        double desvioMulheresEntreGraduados = CalculoUtils.calcularDesvioPadrao(porcentagensMulheresPorPeriodo, mediaMulheresEntreGraduados);

        List<PeriodoEvasaoDTO> periodosEvasao = calcularDistribuicaoEvasaoPorPeriodo(estudantesPorPeriodo);

        double erro = totalAlunos > 0 ? CalculoUtils.round2((totalAtivos * 100.0) / totalAlunos) : 0.0;

        CurriculoDTO curriculoDTO = buscarCurriculo(curso,curriculo);
        MediaPeriodosDTO mediaPeriodos = calcularMediaPeriodosFormatura(estudantesPorPeriodo,curriculoDTO.getDuracaoMinima(),curriculoDTO.getDuracaoMaxima());

        MetricasCursoDTO dto = new MetricasCursoDTO();
        dto.setCodigoDoCurso(curso);
        dto.setGraduados_evadidos_e_ativos_por_periodo(metricas);
        dto.setTaxaDeSucessoMedia(CalculoUtils.round2(mediaGeral));
        dto.setDesvioPadraoPercentual(percentualDesvioGeral);
        dto.setTaxaSucessoMediaMulheres(CalculoUtils.round2(mediaMulheres));
        dto.setDesvioPadraoPercentualMulheres(CalculoUtils.round2(desvioMulheres));
        dto.setDesvioPadraoPercentualGenero(CalculoUtils.round2(desvioMulheresEntreGraduados));
        dto.setPorcentagemMulheresEntreGraduados(CalculoUtils.round2(mediaMulheresEntreGraduados));
        dto.setPorcentagemHomensEntreGraduados(CalculoUtils.round2(100.0 - mediaMulheresEntreGraduados));
        dto.setPeriodosEvasao(periodosEvasao);
        dto.setErro(erro);
        dto.setMediaPeriodos(mediaPeriodos);

        return dto;
    }


    private Map<String, Integer> calculaGraduadosEvadidosEAtivos(List<StudentDTO> estudantes) {
        int ativos = 0;
        int graduados = 0;
        int evadidos = 0;
        int mulheresGraduadas = 0;

        for (StudentDTO estudante : estudantes) {
            String situacao = estudante.getSituacao();
            if (situacao == null) continue;

            if (situacao.equalsIgnoreCase("ativo")) {
                ativos++;
            } else {
                if ("graduado".equalsIgnoreCase(estudante.getMotivoDeEvasao())) {
                    graduados++;
                    if ("FEMININO".equalsIgnoreCase(estudante.getSexo())) {
                        mulheresGraduadas++;
                    }
                } else {
                    evadidos++;
                }
            }
        }

        Map<String, Integer> resultado = new HashMap<>();
        resultado.put("ativos", ativos);
        resultado.put("graduados", graduados);
        resultado.put("evadidos", evadidos);
        resultado.put("mulheresGraduadas", mulheresGraduadas);
        return resultado;
    }

    public List<PeriodoEvasaoDTO> calcularDistribuicaoEvasaoPorPeriodo(Map<String, List<StudentDTO>> estudantesPorPeriodo) {
        Map<Integer, Integer> evasoesPorPeriodo = new HashMap<>();
        int totalEvadidos = 0;

        for (Map.Entry<String, List<StudentDTO>> entrada : estudantesPorPeriodo.entrySet()) {
            for (StudentDTO estudante : entrada.getValue()) {
                String situacao = estudante.getSituacao();
                if (situacao == null || situacao.equalsIgnoreCase("ativo")) continue;
                if ("graduado".equalsIgnoreCase(estudante.getMotivoDeEvasao())) continue;

                String ingresso = estudante.getPeriodoDeIngresso();
                String evasao = estudante.getPeriodoDeEvasao();

                if (ingresso == null || evasao == null) continue;

                int numeroPeriodo = calcularNumeroPeriodo(ingresso, evasao);
                evasoesPorPeriodo.merge(numeroPeriodo, 1, Integer::sum);
                totalEvadidos++;
            }
        }

        int finalTotalEvadidos = totalEvadidos;
        List<PeriodoEvasaoDTO> todasEvasoes = evasoesPorPeriodo.entrySet().stream()
                .map(entry -> {
                    int periodo = entry.getKey();
                    int quantidade = entry.getValue();
                    double porcentagem = finalTotalEvadidos > 0 ? (quantidade * 100.0) / finalTotalEvadidos : 0.0;
                    return new PeriodoEvasaoDTO(String.valueOf(periodo), quantidade, CalculoUtils.round2(porcentagem));
                })
                .sorted(Comparator.comparingDouble(PeriodoEvasaoDTO::getPorcentagemEvadidos).reversed())
                .toList();

        List<PeriodoEvasaoDTO> resultadoFinal = new ArrayList<>();
        int outrosQuantidade = 0;
        double outrosPorcentagem = 0.0;

        for (int i = 0; i < todasEvasoes.size(); i++) {
            if (i < qtdPeriodosEvasao) {
                resultadoFinal.add(todasEvasoes.get(i));
            } else {
                outrosQuantidade += todasEvasoes.get(i).getQuantidadeEvadidos();
                outrosPorcentagem += todasEvasoes.get(i).getPorcentagemEvadidos();
            }
        }

        if (outrosQuantidade > 0) {
            resultadoFinal.add(new PeriodoEvasaoDTO(
                    "Outros períodos",
                    outrosQuantidade,
                    CalculoUtils.round2(outrosPorcentagem)
            ));
        }

        return resultadoFinal;
    }

    public MediaPeriodosDTO calcularMediaPeriodosFormatura(
            Map<String, List<StudentDTO>> estudantesPorPeriodo,
            int duracaoMinima,
            int duracaoMaxima
    ) {
        int somaPeriodos = 0;
        int totalGraduados = 0;
        Map<String, Integer> contagemAgrupada = new HashMap<>();

        for (List<StudentDTO> estudantes : estudantesPorPeriodo.values()) {
            for (StudentDTO estudante : estudantes) {
                if ("graduado".equalsIgnoreCase(estudante.getMotivoDeEvasao())) {
                    Integer periodos = estudante.getPeriodosCompletados();
                    if (periodos != null) {
                        somaPeriodos += periodos;
                        totalGraduados++;

                        String chave;
                        if (periodos <= duracaoMinima) {
                            chave = duracaoMinima + " ou menos";
                        } else if (periodos >= duracaoMaxima) {
                            chave = duracaoMaxima + " ou mais";
                        } else {
                            chave = String.valueOf(periodos);
                        }

                        contagemAgrupada.put(chave, contagemAgrupada.getOrDefault(chave, 0) + 1);
                    }
                }
            }
        }

        MediaPeriodosDTO resultado = new MediaPeriodosDTO();

        if (totalGraduados == 0) {
            resultado.setMedia_periodos_para_se_formar(0.0);
            resultado.setQuantidade_media_periodos_para_se_formar(Collections.emptyList());
            resultado.setDistribuicaoPorPeriodoFormatura(Collections.emptyList());
            resultado.setPeriodoEmDestaque(null);
            return resultado;
        }

        double media = (double) somaPeriodos / totalGraduados;
        int floor = (int) Math.floor(media);
        int ceil = (int) Math.ceil(media);

        resultado.setMedia_periodos_para_se_formar(round2(media));
        resultado.setQuantidade_media_periodos_para_se_formar(
                floor == ceil ? List.of(floor) : List.of(floor, ceil)
        );

        String periodoMaisComum = null;
        int maxFrequencia = -1;

        for (Map.Entry<String, Integer> entry : contagemAgrupada.entrySet()) {
            if (entry.getValue() > maxFrequencia) {
                maxFrequencia = entry.getValue();
                periodoMaisComum = entry.getKey();
            }
        }

        resultado.setPeriodoEmDestaque(periodoMaisComum);

        String grupoMenor = duracaoMinima + " ou menos";
        String grupoMaior = duracaoMaxima + " ou mais";
        List<QuantidadeRealPeriodosDTO> distribuicao = new ArrayList<>();

        if (contagemAgrupada.containsKey(grupoMenor)) {
            distribuicao.add(criarDTO(grupoMenor, contagemAgrupada.get(grupoMenor), totalGraduados));
        }

        int finalTotalGraduados = totalGraduados;
        contagemAgrupada.entrySet().stream()
                .filter(e -> !e.getKey().equals(grupoMenor) && !e.getKey().equals(grupoMaior))
                .sorted(Comparator.comparingInt(e -> Integer.parseInt(e.getKey())))
                .forEach(entry -> {
                    distribuicao.add(criarDTO(entry.getKey(), entry.getValue(), finalTotalGraduados));
                });

        if (contagemAgrupada.containsKey(grupoMaior)) {
            distribuicao.add(criarDTO(grupoMaior, contagemAgrupada.get(grupoMaior), totalGraduados));
        }

        resultado.setDistribuicaoPorPeriodoFormatura(distribuicao);
        return resultado;
    }

    private QuantidadeRealPeriodosDTO criarDTO(String chave, int qtd, int totalGraduados) {
        QuantidadeRealPeriodosDTO dto = new QuantidadeRealPeriodosDTO();
        dto.setQuantidadeDePeriodos(chave);
        dto.setQuantidadeDeGraduados(qtd);
        double percentual = (qtd * 100.0) / totalGraduados;
        dto.setPorcentagemDeGraduados(Math.round(percentual * 100.0) / 100.0);
        return dto;
    }


    public CurriculoDTO buscarCurriculo(Integer codigoDoCurso, Integer codigoDoCurriculo) {
        String url = baseUrl +
                "/curriculos/curriculo" +
                "?curso=" + codigoDoCurso +
                "&curriculo=" + codigoDoCurriculo;

        ResponseEntity<FullCurriculumModel> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {}
        );

        FullCurriculumModel curriculo = response.getBody();
        assert curriculo != null;
        return CurriculoDTO.fromModel(curriculo);
    }

}
