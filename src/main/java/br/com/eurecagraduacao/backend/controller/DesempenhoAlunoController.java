package br.com.eurecagraduacao.backend.controller;

import br.com.eurecagraduacao.backend.dto.backend.desempenhoAluno.ResultadoFdaDTO;
import br.com.eurecagraduacao.backend.dto.eureca.StudentDTO;
import br.com.eurecagraduacao.backend.service.DesempenhoAlunoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/desempenho-aluno")
public class DesempenhoAlunoController {

    private final DesempenhoAlunoService desempenhoAlunoService;

    public DesempenhoAlunoController(DesempenhoAlunoService desempenhoAlunoService) {
        this.desempenhoAlunoService = desempenhoAlunoService;
    }

    @GetMapping("/fdas")
    public ResponseEntity<ResultadoFdaDTO> calcularDesempenhoAluno(
            @RequestParam Integer codigoCurso,
            @RequestParam Integer codigoCurriculo,
            @RequestParam Double cra,
            @RequestParam Double velocidadeMedia,
            @RequestParam Double taxaDeSucesso,
            @RequestParam Double velocidadeMaxima
    ) {
        StudentDTO aluno = new StudentDTO();
        aluno.setCra(cra);
        aluno.setVelocidadeMedia(velocidadeMedia);
        aluno.setTaxaDeSucesso(taxaDeSucesso);
        aluno.setSituacao("ATIVO");

        ResultadoFdaDTO resultado = desempenhoAlunoService.calcularFdas(
                codigoCurso, codigoCurriculo, aluno,velocidadeMaxima
        );

        return ResponseEntity.ok(resultado);
    }
}

