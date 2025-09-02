package br.com.eurecagraduacao.backend.dto.backend;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DisciplinaDistribuicaoStatusDTO {

    @JsonProperty("status")
    private String status;

    @JsonProperty("quantidade_de_alunos")
    private Integer quantidadeDeAlunos;

    @JsonProperty("porcentagem_de_alunos")
    private Double porcentagemDeAlunos;

    public DisciplinaDistribuicaoStatusDTO() {}

    public DisciplinaDistribuicaoStatusDTO(String status, Integer quantidadeDeAlunos, Double porcentagemDeAlunos) {
        this.status = status;
        this.quantidadeDeAlunos = quantidadeDeAlunos;
        this.porcentagemDeAlunos = porcentagemDeAlunos;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
