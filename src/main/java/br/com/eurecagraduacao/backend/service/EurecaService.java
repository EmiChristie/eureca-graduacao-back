package br.com.eurecagraduacao.backend.service;

import br.com.eurecagraduacao.backend.dto.eureca.CourseHomeDTO;
import br.com.eurecagraduacao.backend.dto.eureca.CurriculoDTO;
import br.com.eurecagraduacao.backend.dto.eureca.DisciplinasCurriculoDTO;
import br.com.eurecagraduacao.backend.dto.eureca.EquivalentSubjectCodeDTO;
import br.com.eurecagraduacao.backend.model.eureca.*;
import br.com.eurecagraduacao.backend.util.Constants;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Service
public class EurecaService {

    private String baseUrl = Constants.dasUrl;

    private final RestTemplate restTemplate;

    public EurecaService() {
        this.restTemplate = new RestTemplate();
    }

    public List<StudentModel> buscarEstudantesGraduadosOuEvadidosPorCurso(int codigoDoCurso) {

        String url = baseUrl +
                "/estudantes" +
                "?periodo-de-evasao-de=2020.1" +
                "&periodo-de-evasao-ate=2025.1" +
                "&pagina=1&tamanho=10" + //para fins de teste
                "&curso=" + codigoDoCurso;


        ResponseEntity<List<StudentModel>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );

        return response.getBody();
    }

    public List<StudentModel> buscarEstudantesAtivosPorCurso(int codigoDoCurso) {
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

        return response.getBody();
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
                .map(CourseHomeDTO::fromModel)
                .toList();
    }

    public CourseModel buscarCursoEspecifico(int codigoDoCurso) {
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

    public Integer buscarCodigoDoCurriculoAtivoMaisRecente(int codigoDoCurso) {
        String urlBuilder = baseUrl +
                "/curriculos/codigos-curriculo"+
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

        assert curriculos != null;
        List<Integer> codigos = curriculos.stream()
                .map(CurriculumCodeModel::getCodigoDoCurriculo)
                .sorted(Comparator.reverseOrder())
                .toList();

        return codigos.get(0);
    }

    public CurriculoDTO buscarCurriculo(int codigoDoCurso, int codigoDoCurriculo) {
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

    public List<DisciplinasCurriculoDTO> buscarDisciplinas(int codigoDoCurso, int codigoDoCurriculo) {
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

}
