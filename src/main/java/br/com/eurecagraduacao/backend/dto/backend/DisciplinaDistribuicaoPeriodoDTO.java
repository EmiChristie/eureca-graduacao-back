package br.com.eurecagraduacao.backend.dto.backend;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DisciplinaDistribuicaoPeriodoDTO {

    @JsonProperty("periodo")
    private String periodo;

    @JsonProperty("quantidade_de_alunos")
    private Integer quantidadeDeAlunos;

    @JsonProperty("porcentagem_de_alunos")
    private Double porcentagemDeAlunos;

    public DisciplinaDistribuicaoPeriodoDTO() {}

    public DisciplinaDistribuicaoPeriodoDTO(String periodo, Integer quantidadeDeAlunos, Double porcentagemDeAlunos) {
        this.periodo = periodo;
        this.quantidadeDeAlunos = quantidadeDeAlunos;
        this.porcentagemDeAlunos = porcentagemDeAlunos;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Integer getQuantidadeDeAlunos() {
        return quantidadeDeAlunos;
    }

    public void setQuantidadeDeAlunos(Integer quantidadeDeAlunos) {
        this.quantidadeDeAlunos = quantidadeDeAlunos;
    }

    public Double getPorcentagemDeAlunos() {
        return porcentagemDeAlunos;
    }

    public void setPorcentagemDeAlunos(Double porcentagemDeAlunos) {
        this.porcentagemDeAlunos = porcentagemDeAlunos;
    }
}
