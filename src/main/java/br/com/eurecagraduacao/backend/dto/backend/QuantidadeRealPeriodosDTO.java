package br.com.eurecagraduacao.backend.dto.backend;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QuantidadeRealPeriodosDTO {

    @JsonProperty("quantidade_de_periodos")
    private String quantidadeDePeriodos;

    @JsonProperty("quantidade_de_graduados")
    private Integer quantidadeDeGraduados;

    @JsonProperty("porcentagem_de_graduados")
    private double porcentagemDeGraduados;

    public String getQuantidadeDePeriodos() {
        return quantidadeDePeriodos;
    }

    public void setQuantidadeDePeriodos(String quantidadeDePeriodos) {
        this.quantidadeDePeriodos = quantidadeDePeriodos;
    }

    public double getPorcentagemDeGraduados() {
        return porcentagemDeGraduados;
    }

    public void setPorcentagemDeGraduados(double porcentagemDeGraduados) {
        this.porcentagemDeGraduados = porcentagemDeGraduados;
    }

    public Integer getQuantidadeDeGraduados() {
        return quantidadeDeGraduados;
    }

    public void setQuantidadeDeGraduados(Integer quantidadeDeGraduados) {
        this.quantidadeDeGraduados = quantidadeDeGraduados;
    }
}
