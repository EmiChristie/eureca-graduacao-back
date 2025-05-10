package br.com.eurecagraduacao.backend.dto.backend;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PeriodoEvasaoDTO {

    @JsonProperty("periodo")
    private String periodo;

    @JsonProperty("quantidade_de_evadidos")
    private int quantidadeEvadidos;

    @JsonProperty("porcentagem_de_evadidos")
    private double porcentagemEvadidos;

    public PeriodoEvasaoDTO(String periodo, int quantidadeEvadidos, double porcentagemEvadidos) {
        this.periodo = periodo;
        this.quantidadeEvadidos = quantidadeEvadidos;
        this.porcentagemEvadidos = porcentagemEvadidos;
    }

    public double getPorcentagemEvadidos(){return porcentagemEvadidos;}

    public int getQuantidadeEvadidos() {return quantidadeEvadidos;}
}
