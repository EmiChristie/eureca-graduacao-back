package br.com.eurecagraduacao.backend.controller;

import br.com.eurecagraduacao.backend.dto.eureca.*;
import br.com.eurecagraduacao.backend.model.eureca.CourseModel;
import br.com.eurecagraduacao.backend.model.eureca.EnrollmentHistoryModel;
import br.com.eurecagraduacao.backend.model.eureca.MetricsHistoryModel;
import br.com.eurecagraduacao.backend.service.EurecaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eureca")
public class EurecaController {

    private final EurecaService eurecaService;

    public EurecaController(EurecaService eurecaService) {
        this.eurecaService = eurecaService;
    }

    @GetMapping("/estudantes-graduados-ou-evadidos-por-curso")
    public List<StudentDTO> getEstudantesGraduadosOuEvadidosPorCurso(
            @RequestParam("curso") Integer codigoDoCurso
    ) {
        return eurecaService.buscarEstudantesGraduadosOuEvadidosPorCurso(codigoDoCurso);
    }

    @GetMapping("/estudantes-ativos-por-curso")
    public List<StudentDTO> getEstudantesAtivosPorCurso(
            @RequestParam("curso") Integer codigoDoCurso
    ) {
        return eurecaService.buscarEstudantesAtivosPorCurso(codigoDoCurso);
    }

    @GetMapping("/cursos")
    public List<CourseHomeDTO> getCursosAtivos() {
        return eurecaService.buscarCursosAtivos();
    }

    @GetMapping("/curso")
    public CourseModel getCursoEspecifico(
            @RequestParam("curso") Integer codigoDoCurso
    ) {
        return eurecaService.buscarCursoEspecifico(codigoDoCurso);
    }

    @GetMapping("/curriculo-ativo-mais-recente")
    public Integer getCurriculoAtivoMaisRecente(
            @RequestParam("curso") Integer codigoDoCurso
    ) {
        return eurecaService.buscarCodigoDoCurriculoAtivoMaisRecente(codigoDoCurso);
    }

    @GetMapping("/curriculo")
    public CurriculoDTO getCurriculo(
            @RequestParam("curso") Integer codigoDoCurso,
            @RequestParam("curriculo") Integer codigoDoCurriculo
    ) {
        return eurecaService.buscarCurriculo(codigoDoCurso,codigoDoCurriculo);
    }

    @GetMapping("/disciplinas-de-um-curriculo")
    public List<DisciplinasCurriculoDTO> getDisciplinas(
            @RequestParam("curso") Integer codigoDoCurso,
            @RequestParam("curriculo") Integer codigoDoCurriculo
    ) {
        return eurecaService.buscarDisciplinas(codigoDoCurso,codigoDoCurriculo);
    }

    @GetMapping("/codigos-disciplinas-obrigatorias")
    public List<Integer> getDisciplinasObrigatorias(
            @RequestParam("curso") Integer codigoDoCurso,
            @RequestParam("curriculo") Integer codigoDoCurriculo,
            @RequestParam(name = "periodoIdeal", required = false) String periodoIdeal
    ) {
        return eurecaService.buscarDisciplinasObrigatorias(codigoDoCurso,codigoDoCurriculo,periodoIdeal);
    }

    @GetMapping("/codigos-disciplinas-optativas")
    public List<Integer> getDisciplinasOptativas(
            @RequestParam("curso") Integer codigoDoCurso,
            @RequestParam("curriculo") Integer codigoDoCurriculo
    ) {
        return eurecaService.buscarDisciplinasOptativas(codigoDoCurso,codigoDoCurriculo);
    }

    @GetMapping("/matriculas-em-disciplina")
    public List<EnrollmentDTO> getMatriculas(
            @RequestParam("curso") Integer codigoDoCurso,
            @RequestParam("disciplina") Integer codigoDaDisciplina
    ) {
        return eurecaService.buscarMatriculas(codigoDoCurso,codigoDaDisciplina);
    }

    @GetMapping("/user-info")
    public OwnProfileDTO getStudentInfo(
            @RequestParam("matricula") String matricula,
            @RequestHeader("token") String token
    ) {
        return eurecaService.buscarUserInfo(matricula,token);
    }

    @GetMapping("/user-metrics")
    public List<MetricsHistoryModel> getStudentMetrics(
            @RequestParam("matricula") String matricula,
            @RequestHeader("token") String token
    ) {
        return eurecaService.buscarMetricas(matricula,token);
    }


    @GetMapping("/user-history")
    public List<EnrollmentHistoryModel> getStudentHistory(
            @RequestParam("matricula") String matricula,
            @RequestHeader("token") String token
    ) {
        return eurecaService.buscarHistorico(matricula,token);
    }

}
