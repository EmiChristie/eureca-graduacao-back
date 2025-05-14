package br.com.eurecagraduacao.backend.dto.backend;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TaxasCalculadasGraduadosGlobaisDTO {

    @JsonProperty("velocidade_media_global")
    private double velocidade_media_global;

    @JsonProperty("taxa_de_sucesso_media_global")
    private double taxa_de_sucesso_media_global;

    @JsonProperty("cra_medio_global")
    private double cra_medio_global;

    public double getVelocidade_media_global() {
        return velocidade_media_global;
    }

    public void setVelocidade_media_global(double velocidade_media_global) {
        this.velocidade_media_global = velocidade_media_global;
    }

    public double getTaxa_de_sucesso_media_global() {
        return taxa_de_sucesso_media_global;
    }

    public void setTaxa_de_sucesso_media_global(double taxa_de_sucesso_media_global) {
        this.taxa_de_sucesso_media_global = taxa_de_sucesso_media_global;
    }

    public double getCra_medio_global() {
        return cra_medio_global;
    }

    public void setCra_medio_global(double cra_medio_global) {
        this.cra_medio_global = cra_medio_global;
    }
}
