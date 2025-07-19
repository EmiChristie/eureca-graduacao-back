package br.com.eurecagraduacao.backend.controller;

import br.com.eurecagraduacao.backend.dto.backend.*;
import br.com.eurecagraduacao.backend.dto.eureca.StudentDTO;
import br.com.eurecagraduacao.backend.service.MetricasCursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/metricas-curso")
public class MetricasCursoController {

    private final MetricasCursoService metricasCursoService;

    @Autowired
    public MetricasCursoController(MetricasCursoService metricasCursoService) {
        this.metricasCursoService = metricasCursoService;
    }

    @GetMapping("/disciplinas-que-mais-reprovam")
    public List<DisciplinaReprovacaoDTO> buscarDisciplinasQueMaisReprovam(
            @RequestParam Integer curso,
            @RequestParam String curriculo
    ) {
        return metricasCursoService.buscarDisciplinasQueMaisReprovam(curso, curriculo);
    }

    @GetMapping("/taxa-de-sucesso-simples")
    public TaxaSucessoDTO getTaxaDeSucessoSimples(
            @RequestParam Integer codigoDoCurso
    ) {
        return metricasCursoService.getTaxaDeSucessoSimples(codigoDoCurso);
    }


    @GetMapping("/metricas-curso")
    public MetricasCursoDTO getMetricasCurso(
            @RequestParam Integer curso,
            @RequestParam String curriculo
    ) {
        return metricasCursoService.getMetricasCurso(curso,curriculo);
    }

}
