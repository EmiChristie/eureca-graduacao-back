package br.com.eurecagraduacao.backend.service;

import br.com.eurecagraduacao.backend.dto.backend.DisciplinaRelacionadaDTO;
import br.com.eurecagraduacao.backend.dto.backend.RequisitosDTO;
import br.com.eurecagraduacao.backend.dto.eureca.*;
import br.com.eurecagraduacao.backend.model.eureca.*;
import br.com.eurecagraduacao.backend.util.Constants;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

import static br.com.eurecagraduacao.backend.util.Constants.*;

@Service
public class EurecaService {

    private final String baseUrl = Constants.dasUrl;

    private final RestTemplate restTemplate;

    public EurecaService() {
        this.restTemplate = new RestTemplate();
    }

    public List<StudentDTO> buscarEstudantesGraduadosOuEvadidosPorCurso(Integer codigoDoCurso) {
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

    public List<StudentDTO> buscarEstudantesAtivosPorCurso(Integer codigoDoCurso) {
        String url = baseUrl +
                "/estudantes" +
                "?situacao-do-estudante=ATIVOS" +
                "&pagina=1&tamanho=10"+ //para fins de teste
                "&curso=" + codigoDoCurso;

        ResponseEntity<List<StudentModel>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );

        List<StudentModel> estudantes = response.getBody();

        if (estudantes == null) {
            return List.of();
        }

        return estudantes.stream().map(StudentDTO::fromModel).toList();
    }

    public List<CourseHomeDTO> buscarCursosAtivos() {
        String url = baseUrl +
                "/cursos" +
                "?status=ATIVOS";

        ResponseEntity<List<CourseModel>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<CourseModel>>() {}
        );

        List<CourseModel> cursos = response.getBody();

        assert cursos != null;
        return cursos.stream()
                .map(curso -> {
                    Integer codigoCurriculo = buscarCodigoDoCurriculoAtivoMaisRecente(curso.getCodigoDoCurso());
                    return CourseHomeDTO.fromModel(curso, codigoCurriculo);
                })
                .toList();
    }

    public CourseModel buscarCursoEspecifico(Integer codigoDoCurso) {
        String url = baseUrl +
                "/cursos" +
                "?curso=" + codigoDoCurso;

        ResponseEntity<List<CourseModel>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );

        List<CourseModel> cursos = response.getBody();
        return (cursos != null && !cursos.isEmpty()) ? cursos.get(0) : null;
    }

    public Integer buscarCodigoDoCurriculoAtivoMaisRecente(Integer codigoDoCurso) {
        try {
            String urlBuilder = baseUrl +
                    "/curriculos/codigos-curriculo" +
                    "?status=ATIVO" +
                    "&curso=" + codigoDoCurso;

            ResponseEntity<List<CurriculumCodeModel>> response = restTemplate.exchange(
                    urlBuilder,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<>() {
                    }
            );

            List<CurriculumCodeModel> curriculos = response.getBody();

            if (curriculos == null || curriculos.isEmpty()) {
                return null;
            }

            return curriculos.stream()
                    .map(CurriculumCodeModel::getCodigoDoCurriculo)
                    .max(Comparator.naturalOrder())
                    .orElse(null);
        } catch (Exception e) {
            return null;
        }
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

    public List<DisciplinasCurriculoDTO> buscarDisciplinas(Integer codigoDoCurso, Integer codigoDoCurriculo) {
        String curriculumRequestUrl = baseUrl+
                "/curriculos/curriculo"+
                "?curso="+codigoDoCurso+
                "&curriculo="+codigoDoCurriculo;
        String subjectsRequestUrl = baseUrl+
                "/disciplinas-por-curriculo"+
                "?curso="+codigoDoCurso+
                "&curriculo="+codigoDoCurriculo;

        ResponseEntity<FullCurriculumModel> curriculumResponse = restTemplate.exchange(
                curriculumRequestUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );

        ResponseEntity<List<SubjectModel>> subjectsResponse = restTemplate.exchange(
                subjectsRequestUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );

        FullCurriculumModel fullCurriculumModel = curriculumResponse.getBody();
        List<SubjectModel> subjects = subjectsResponse.getBody();

        assert fullCurriculumModel != null;
        List<CurriculumSubjectModel> curriculumSubjects = fullCurriculumModel.getDisciplinasDoCurriculo();

        assert subjects != null;
        return curriculumSubjects.stream().map(curriculumSubject -> {
            SubjectModel subject = subjects.stream()
                    .filter(s -> Objects.equals(s.getCodigoDaDisciplina(), curriculumSubject.getCodigo()))
                    .findFirst()
                    .orElse(null);

            if (subject == null) {
                return null;
            }

            String semestreIdealStr = subject.getSemestreIdeal();
            Integer semestreIdeal = null;
            if (semestreIdealStr != null && !semestreIdealStr.isBlank()) {
                semestreIdeal = Integer.parseInt(semestreIdealStr);
            }

            return new DisciplinasCurriculoDTO(
                    subject.getCodigoDaDisciplina(),
                    subject.getNome(),
                    subject.getTipo(),
                    subject.getStatus(),
                    semestreIdeal,
                    subject.getQuantidadeDeCreditos(),
                    curriculumSubject.getMediaAprovacao(),
                    curriculumSubject.getCodigoSetor(),
                    curriculumSubject.getHorasTotais(),
                    curriculumSubject.getPreRequisitos(),
                    curriculumSubject.getCoRequisitos(),
                    curriculumSubject.getDisciplinasEquivalentes().stream()
                            .map(equivalent -> new EquivalentSubjectCodeDTO(
                                    equivalent.getCodigo(),
                                    equivalent.getNome()
                            ))
                            .toList()
            );
        }).toList();

    }

    public List<Integer> buscarDisciplinasObrigatorias(Integer codigoDoCurso, Integer codigoDoCurriculo,String periodoIdeal) {
        String urlBuilder = baseUrl +
                "/disciplinas-por-curriculo"+
                "?tipo-da-disciplina=OBRIGATORIO" +
                "&curso=" + codigoDoCurso+
                "&curriculo=" + codigoDoCurriculo;

        ResponseEntity<List<SubjectModel>> response = restTemplate.exchange(
                urlBuilder,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );

        List<SubjectModel> disciplinas = response.getBody();

        assert disciplinas != null;

        List<Integer> codigosDisciplinas;

        if(periodoIdeal != null){
            codigosDisciplinas = disciplinas.stream()
                    .filter(d -> d.getSemestreIdeal().equals(periodoIdeal))
                    .map(SubjectModel::getCodigoDaDisciplina)
                    .toList();
        }else{
            codigosDisciplinas = disciplinas.stream()
                    .map(SubjectModel::getCodigoDaDisciplina)
                    .toList();
        }

        return codigosDisciplinas;
    }

    public List<Integer> buscarDisciplinasOptativas(Integer codigoDoCurso, Integer codigoDoCurriculo) {
        String urlBuilder = baseUrl +
                "/disciplinas-por-curriculo"+
                "?tipo-da-disciplina=OPCIONAL" +
                "&curso=" + codigoDoCurso+
                "&curriculo=" + codigoDoCurriculo;

        ResponseEntity<List<SubjectModel>> response = restTemplate.exchange(
                urlBuilder,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );

        List<SubjectModel> disciplinas = response.getBody();

        assert disciplinas != null;

        return disciplinas.stream()
                    .map(SubjectModel::getCodigoDaDisciplina)
                    .toList();
    }

    public List<EnrollmentDTO> buscarMatriculas(Integer codigoDoCurso, Integer codigoDaDisciplina) {
        String url = baseUrl +
                "/matriculas" +
                "?periodo-de=" + periodoDe +
                "&periodo-ate=" + periodoAte +
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


    public OwnProfileDTO buscarUserInfo(String matricula, String token) {
        String url = dasSigUrl + "/estudantes/estudante?estudante=" + matricula;

        HttpHeaders headers = new HttpHeaders();
        headers.set("token-de-autenticacao", token);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<StudentModel> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<>() {}
        );

        StudentModel model = response.getBody();

        if (model != null) {
            return OwnProfileDTO.fromModel(model);
        }

        return null;
    }

    public List<MetricsHistoryModel> buscarMetricas(String matricula, String token) {
        String url = baseUrl +
                "/estudantes/metricas/estudante?estudante=" + matricula;

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("token-de-autenticacao", token);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<StudentMetricsModel> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                StudentMetricsModel.class
        );

        StudentMetricsModel studentMetrics = response.getBody();

        return studentMetrics != null ? studentMetrics.getHistoricoDeMetricas() : List.of();
    }


    public List<EnrollmentHistoryModel> buscarHistorico(String matricula, String token) {
        String url = baseUrl +
                "/estudantes/historico/estudante?estudante=" + matricula;

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("token-de-autenticacao", token);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<StudentHistoryModel> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                StudentHistoryModel.class
        );

        StudentHistoryModel history = response.getBody();

        return history != null ? history.getHistoricoDeMatriculas() : List.of();
    }

    public RequisitosDTO buscarRequisitos(String disciplina, String curso, String curriculo) {
        RequisitosDTO requisitosDTO = new RequisitosDTO();

        // URLs com parâmetros como string
        String urlPre = String.format(
                baseUrl+"pre-requisito-disciplinas?disciplina=%s&curso=%s&curriculo=%s",
                disciplina, curso, curriculo
        );

        String urlCo = String.format(
                baseUrl+"co-requisitos?disciplina=%s&curso=%s&curriculo=%s",
                disciplina, curso, curriculo
        );

        String urlEq = String.format(
                baseUrl+"disciplinas-equivalentes?disciplina=%s",
                disciplina
        );

        List<String> codigosPre = fetchCodigos(urlPre, "condicao");
        List<String> codigosCo = fetchCodigos(urlCo, "condicao");
        List<String> codigosEq = fetchCodigos(urlEq, "codigo_disciplina_equivalente");

        for (String codigo : codigosPre) {
            requisitosDTO.getPre_requisitos().add(getDisciplinaRelacionada(codigo));
        }
        for (String codigo : codigosCo) {
            requisitosDTO.getCo_requisitos().add(getDisciplinaRelacionada(codigo));
        }
        for (String codigo : codigosEq) {
            requisitosDTO.getDisciplinas_equivalentes().add(getDisciplinaRelacionada(codigo));
        }

        return requisitosDTO;
    }

    private List<String> fetchCodigos(String url, String key) {
        try {
            ResponseEntity<List<Map<String, Object>>> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<>() {}
            );
            return Objects.requireNonNull(response.getBody()).stream()
                    .map(item -> String.valueOf(item.get(key)))
                    .collect(Collectors.toList());
        } catch (HttpClientErrorException.NotFound e) {
            return Collections.emptyList();
        }
    }

    private DisciplinaRelacionadaDTO getDisciplinaRelacionada(String codigo) {
        String url = String.format(baseUrl+"disciplinas?disciplina=%s", codigo);
        try {
            ResponseEntity<List<Map<String, Object>>> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<>() {}
            );

            if (response.getBody() != null && !response.getBody().isEmpty()) {
                Map<String, Object> data = response.getBody().get(0);
                String nome = (String) data.get("nome");
                return new DisciplinaRelacionadaDTO(nome, codigo);
            }
        } catch (HttpClientErrorException.NotFound e) {

        }
        return new DisciplinaRelacionadaDTO("Desconhecida", codigo);
    }


}
