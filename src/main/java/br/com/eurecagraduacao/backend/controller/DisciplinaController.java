package br.com.eurecagraduacao.backend.controller;

import br.com.eurecagraduacao.backend.dto.backend.DisciplinaDistribuicaoNotasDTO;
import br.com.eurecagraduacao.backend.dto.backend.DisciplinaDistribuicaoPeriodosDTO;
import br.com.eurecagraduacao.backend.dto.backend.DisciplinaDistribuicaoStatusDTO;
import br.com.eurecagraduacao.backend.dto.backend.MetricasDisciplinaDTO;
import br.com.eurecagraduacao.backend.dto.eureca.StudentDTO;
import br.com.eurecagraduacao.backend.service.DisciplinaService;
import br.com.eurecagraduacao.backend.service.EurecaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/metricas-disciplina")
public class DisciplinaController {

    private final DisciplinaService disciplinaService;

    public DisciplinaController(DisciplinaService disciplinaService) {
        this.disciplinaService = disciplinaService;
    }

    @GetMapping("/metricas-disciplina")
    public MetricasDisciplinaDTO getMetricasDisciplina(
            @RequestParam("curso") String codigoDoCurso,
            @RequestParam("disciplina") String disciplina
    ) {
        return disciplinaService.buscarMetricasDisciplina(codigoDoCurso,disciplina);
    }
}
