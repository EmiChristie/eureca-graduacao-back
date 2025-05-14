package br.com.eurecagraduacao.backend.dto.backend;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TaxasCalculadasGraduadosDTO {

    @JsonProperty("quantidade_de_periodos")
    private String quantidade_de_periodos;

    @JsonProperty("quantidade_de_graduados")
    private int quantidade_de_graduados;

    @JsonProperty("velocidade_media")
    private double velocidade_media;

    @JsonProperty("taxa_de_sucesso_media")
    private double taxa_de_sucesso_media;

    @JsonProperty("cra_medio")
    private double cra_medio;

    @JsonProperty("desvio_padrao_velocidade_media")
    private double desvio_padrao_velocidade_media;

    @JsonProperty("desvio_padrao_taxa_de_sucesso_media")
    private double desvio_padrao_taxa_de_sucesso_media;

    @JsonProperty("desvio_padrao_cra_medio")
    private double desvio_padrao_cra_medio;

    public String getQuantidade_de_periodos() {
        return quantidade_de_periodos;
    }

    public void setQuantidade_de_periodos(String quantidade_de_periodos) {
        this.quantidade_de_periodos = quantidade_de_periodos;
    }

    public int getQuantidade_de_graduados() {
        return quantidade_de_graduados;
    }

    public void setQuantidade_de_graduados(int quantidade_de_graduados) {
        this.quantidade_de_graduados = quantidade_de_graduados;
    }

    public double getVelocidade_media() {
        return velocidade_media;
    }

    public void setVelocidade_media(double velocidade_media) {
        this.velocidade_media = velocidade_media;
    }

    public double getTaxa_de_sucesso_media() {
        return taxa_de_sucesso_media;
    }

    public void setTaxa_de_sucesso_media(double taxa_de_sucesso_media) {
        this.taxa_de_sucesso_media = taxa_de_sucesso_media;
    }

    public double getCra_medio() {
        return cra_medio;
    }

    public void setCra_medio(double cra_medio) {
        this.cra_medio = cra_medio;
    }

    public double getDesvio_padrao_velocidade_media() {
        return desvio_padrao_velocidade_media;
    }

    public void setDesvio_padrao_velocidade_media(double desvio_padrao_velocidade_media) {
        this.desvio_padrao_velocidade_media = desvio_padrao_velocidade_media;
    }

    public double getDesvio_padrao_taxa_de_sucesso_media() {
        return desvio_padrao_taxa_de_sucesso_media;
    }

    public void setDesvio_padrao_taxa_de_sucesso_media(double desvio_padrao_taxa_de_sucesso_media) {
        this.desvio_padrao_taxa_de_sucesso_media = desvio_padrao_taxa_de_sucesso_media;
    }

    public double getDesvio_padrao_cra_medio() {
        return desvio_padrao_cra_medio;
    }

    public void setDesvio_padrao_cra_medio(double desvio_padrao_cra_medio) {
        this.desvio_padrao_cra_medio = desvio_padrao_cra_medio;
    }
}
