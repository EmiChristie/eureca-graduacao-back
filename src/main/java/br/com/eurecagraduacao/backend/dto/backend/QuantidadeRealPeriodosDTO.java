package br.com.eurecagraduacao.backend.dto.backend;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QuantidadeRealPeriodosDTO {

    @JsonProperty("quantidade_de_periodos")
    private double quantidadeDePeriodos;

    @JsonProperty("porcentagem_de_graduados")
    private double porcentagemDeGraduados;

    public double getQuantidadeDePeriodos() {
        return quantidadeDePeriodos;
    }

    public void setQuantidadeDePeriodos(double quantidadeDePeriodos) {
        this.quantidadeDePeriodos = quantidadeDePeriodos;
    }

    public double getPorcentagemDeGraduados() {
        return porcentagemDeGraduados;
    }

    public void setPorcentagemDeGraduados(double porcentagemDeGraduados) {
        this.porcentagemDeGraduados = porcentagemDeGraduados;
    }
}
