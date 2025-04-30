package br.com.eurecagraduacao.backend.dto.backend;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GraduadosEEvadidosPorPeriodoDTO {

    @JsonProperty("quantidade_graduados_periodo")
    private int quantidadeGraduadosPeriodo;

    @JsonProperty("quantidade_evadidos_periodo")
    private int quantidadeEvadidosPeriodo;

    @JsonProperty("taxa_de_sucesso_periodo")
    private double taxaDeSucessoPeriodo;

    @JsonProperty("periodo")
    private String periodo;

    public int getQuantidadeGraduadosPeriodo() {
        return quantidadeGraduadosPeriodo;
    }

    public void setQuantidadeGraduadosPeriodo(int quantidadeGraduadosPeriodo) {
        this.quantidadeGraduadosPeriodo = quantidadeGraduadosPeriodo;
    }

    public int getQuantidadeEvadidosPeriodo() {
        return quantidadeEvadidosPeriodo;
    }

    public void setQuantidadeEvadidosPeriodo(int quantidadeEvadidosPeriodo) {
        this.quantidadeEvadidosPeriodo = quantidadeEvadidosPeriodo;
    }

    public double getTaxaDeSucessoPeriodo() {
        return taxaDeSucessoPeriodo;
    }

    public void setTaxaDeSucessoPeriodo(double taxaDeSucessoPeriodo) {
        this.taxaDeSucessoPeriodo = taxaDeSucessoPeriodo;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
}
