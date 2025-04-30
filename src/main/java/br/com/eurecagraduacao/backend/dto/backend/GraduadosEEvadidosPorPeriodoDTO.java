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
}
