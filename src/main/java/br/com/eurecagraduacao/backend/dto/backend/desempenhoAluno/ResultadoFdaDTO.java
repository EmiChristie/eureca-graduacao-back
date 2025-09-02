package br.com.eurecagraduacao.backend.dto.backend.desempenhoAluno;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultadoFdaDTO {

    @JsonProperty("cra")
    private MetricaFdaDTO cra;

    @JsonProperty("velocidade_media")
    private MetricaFdaDTO velocidadeMedia;

    @JsonProperty("taxa_de_sucesso")
    private MetricaFdaDTO taxaDeSucesso;

    public MetricaFdaDTO getCra() {
        return cra;
    }

    public void setCra(MetricaFdaDTO cra) {
        this.cra = cra;
    }

    public MetricaFdaDTO getVelocidadeMedia() {
        return velocidadeMedia;
    }

    public void setVelocidadeMedia(MetricaFdaDTO velocidadeMedia) {
        this.velocidadeMedia = velocidadeMedia;
    }

    public MetricaFdaDTO getTaxaDeSucesso() {
        return taxaDeSucesso;
    }

    public void setTaxaDeSucesso(MetricaFdaDTO taxaDeSucesso) {
        this.taxaDeSucesso = taxaDeSucesso;
    }
}
