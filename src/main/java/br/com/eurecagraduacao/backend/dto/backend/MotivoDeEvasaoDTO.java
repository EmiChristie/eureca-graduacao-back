package br.com.eurecagraduacao.backend.dto.backend;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MotivoDeEvasaoDTO {

    @JsonProperty("motivo")
    private String motivo;

    @JsonProperty("porcentagem_evadidos")
    private double porcentagemEvadidos;

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public void setPorcentagemEvadidos(double pct) {
        this.porcentagemEvadidos = pct;
    }
}