package br.com.eurecagraduacao.backend.controller;

import br.com.eurecagraduacao.backend.dto.eureca.CourseHomeDTO;
import br.com.eurecagraduacao.backend.dto.eureca.CurriculoDTO;
import br.com.eurecagraduacao.backend.dto.eureca.DisciplinasCurriculoDTO;
import br.com.eurecagraduacao.backend.model.eureca.CourseModel;
import br.com.eurecagraduacao.backend.model.eureca.FullCurriculumModel;
import br.com.eurecagraduacao.backend.model.eureca.StudentModel;
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
    public List<StudentModel> getEstudantesGraduadosOuEvadidosPorCurso(@RequestParam("curso") int codigoDoCurso) {
        return eurecaService.buscarEstudantesGraduadosOuEvadidosPorCurso(codigoDoCurso);
    }

    @GetMapping("/estudantes-ativos-por-curso")
    public List<StudentModel> getEstudantesAtivosPorCurso(@RequestParam("curso") int codigoDoCurso) {
        return eurecaService.buscarEstudantesAtivosPorCurso(codigoDoCurso);
    }

    @GetMapping("/cursos")
    public List<CourseHomeDTO> getCursosAtivos() {
        return eurecaService.buscarCursosAtivos();
    }

    @GetMapping("/curso")
    public CourseModel getCursoEspecifico(@RequestParam("curso") int codigoDoCurso) {
        return eurecaService.buscarCursoEspecifico(codigoDoCurso);
    }

    @GetMapping("/curriculo-ativo-mais-recente")
    public Integer getCurriculoAtivoMaisRecente(@RequestParam("curso") int codigoDoCurso) {
        return eurecaService.buscarCodigoDoCurriculoAtivoMaisRecente(codigoDoCurso);
    }

    @GetMapping("/curriculo")
    public CurriculoDTO getCurriculo(
            @RequestParam("curso") int codigoDoCurso,
            @RequestParam("curriculo") int codigoDoCurriculo
    ) {
        return eurecaService.buscarCurriculo(codigoDoCurso,codigoDoCurriculo);
    }

    @GetMapping("/disciplinas-de-um-curriculo")
    public List<DisciplinasCurriculoDTO> getDisciplinas(
            @RequestParam("curso") int codigoDoCurso,
            @RequestParam("curriculo") int codigoDoCurriculo
    ) {
        return eurecaService.buscarDisciplinas(codigoDoCurso,codigoDoCurriculo);
    }

    /*
    * Métodos que faltam:
    * Pegar informações das matrículas em disciplinas (para calcular disciplinas que mais reprovam)
    * Pegar informações particulares do estudante que estiver logado
    * */

}
