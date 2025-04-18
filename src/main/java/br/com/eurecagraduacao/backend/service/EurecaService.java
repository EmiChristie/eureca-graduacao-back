package br.com.eurecagraduacao.backend.service;

import br.com.eurecagraduacao.backend.model.eureca.*;
import br.com.eurecagraduacao.backend.util.Constants;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Comparator;
import java.util.List;

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

    public List<CourseModel> buscarCursosAtivos() {
        String url = baseUrl +
                "/cursos" +
                "?status=ATIVOS";

        ResponseEntity<List<CourseModel>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );

        return response.getBody();
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

    public FullCurriculumModel buscarCurriculo(int codigoDoCurso, int codigoDoCurriculo) {
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

        return response.getBody();
    }
}
