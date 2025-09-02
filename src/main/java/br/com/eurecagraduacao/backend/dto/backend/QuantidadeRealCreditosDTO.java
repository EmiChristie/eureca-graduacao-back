package br.com.eurecagraduacao.backend.dto.backend;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QuantidadeRealCreditosDTO {

    @JsonProperty("quantidade_media_creditos")
    private double quantidadeMediaCreditos;

    @JsonProperty("quantidade_a_mais_que_o_minimo")
    private double quantidadeAMaisQueOMinimo;

    @JsonProperty("porcentagem_a_mais_que_o_minimo")
    private double porcentagemAMaisQueOMinimo;
}