package br.com.eurecagraduacao.backend.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teste")
public record TesteController() {

    @GetMapping("/conexao")
    public String ping() {
        return "Sistema funcionando";
    }
}
