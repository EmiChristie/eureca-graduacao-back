package br.com.eurecagraduacao.backend.dto.backend;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DisciplinaDistribuicaoPeriodosDTO {

    @JsonProperty("periodo")
    private Integer periodo;

    @JsonProperty("quantidade_de_alunos")
    private Integer quantidadeDeAlunos;

    @JsonProperty("porcentagem_de_alunos")
    private Double porcentagemDeAlunos;

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
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
