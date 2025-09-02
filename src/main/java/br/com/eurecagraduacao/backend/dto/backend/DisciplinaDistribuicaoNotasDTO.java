package br.com.eurecagraduacao.backend.dto.backend;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DisciplinaDistribuicaoNotasDTO {
    @JsonProperty("nota")
    private Double nota;

    @JsonProperty("quantidade_de_alunos")
    private Integer quantidadeDeAlunos;

    @JsonProperty("porcentagem_de_alunos")
    private Double porcentagemDeAlunos;

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
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
