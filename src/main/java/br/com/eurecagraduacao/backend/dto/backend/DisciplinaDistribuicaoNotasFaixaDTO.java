package br.com.eurecagraduacao.backend.dto.backend;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DisciplinaDistribuicaoNotasFaixaDTO {

    @JsonProperty("faixa")
    private String faixa;

    @JsonProperty("quantidade_de_alunos")
    private Integer quantidadeDeAlunos;

    @JsonProperty("porcentagem_de_alunos")
    private Double porcentagemDeAlunos;

    public DisciplinaDistribuicaoNotasFaixaDTO() {
    }

    public DisciplinaDistribuicaoNotasFaixaDTO(String faixa, Integer quantidadeDeAlunos, Double porcentagemDeAlunos) {
        this.faixa = faixa;
        this.quantidadeDeAlunos = quantidadeDeAlunos;
        this.porcentagemDeAlunos = porcentagemDeAlunos;
    }

    public String getFaixa() {
        return faixa;
    }

    public void setFaixa(String faixa) {
        this.faixa = faixa;
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
