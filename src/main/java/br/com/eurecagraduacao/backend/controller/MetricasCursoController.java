package br.com.eurecagraduacao.backend.controller;

import br.com.eurecagraduacao.backend.dto.backend.DisciplinaReprovacaoDTO;
import br.com.eurecagraduacao.backend.dto.backend.TaxaSucessoDTO;
import br.com.eurecagraduacao.backend.service.MetricasCursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/metricas-curso")
public class MetricasCursoController {

    private final MetricasCursoService metricasCursoService;

    @Autowired
    public MetricasCursoController(MetricasCursoService metricasCursoService) {
        this.metricasCursoService = metricasCursoService;
    }

    @GetMapping("/disciplinas-obrigatorias-que-mais-reprovam")
    public List<DisciplinaReprovacaoDTO> buscarDisciplinasQueMaisReprovam(
            @RequestParam Integer curso,
            @RequestParam Integer curriculo
    ) {
        return metricasCursoService.buscarDisciplinasQueMaisReprovam(curso, curriculo);
    }

    @GetMapping("/taxa-de-sucesso")
    public TaxaSucessoDTO getTaxaDeSucesso(
            @RequestParam Integer codigoDoCurso
    ) {
        return metricasCursoService.getTaxaDeSucesso(codigoDoCurso);
    }
}
