package br.com.eurecagraduacao.backend.dto.backend;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PerfilAlunoMedioDTO {

    @JsonProperty("quantidade_de_periodos_media")
    private List<Integer> quantidade_de_periodos_media;

    @JsonProperty("cra_medio")
    private Double cra_medio;

    @JsonProperty("taxa_de_sucesso_media")
    private Double taxa_de_sucesso_media;

    @JsonProperty("velocidade_media")
    private Double velocidade_media;

    @JsonProperty("creditos_matriculados_media")
    private Double creditos_matriculados_media;

    @JsonProperty("creditos_reprovados_media")
    private Double creditos_reprovados_media;

    public List<Integer> getQuantidade_de_periodos_media() {
        return quantidade_de_periodos_media;
    }

    public void setQuantidade_de_periodos_media(List<Integer> quantidade_de_periodos_media) {
        this.quantidade_de_periodos_media = quantidade_de_periodos_media;
    }

    public Double getCra_medio() {
        return cra_medio;
    }

    public void setCra_medio(Double cra_medio) {
        this.cra_medio = cra_medio;
    }

    public Double getTaxa_de_sucesso_media() {
        return taxa_de_sucesso_media;
    }

    public void setTaxa_de_sucesso_media(Double taxa_de_sucesso_media) {
        this.taxa_de_sucesso_media = taxa_de_sucesso_media;
    }

    public Double getVelocidade_media() {
        return velocidade_media;
    }

    public void setVelocidade_media(Double velocidade_media) {
        this.velocidade_media = velocidade_media;
    }

    public Double getCreditos_matriculados_media() {
        return creditos_matriculados_media;
    }

    public void setCreditos_matriculados_media(Double creditos_matriculados_media) {
        this.creditos_matriculados_media = creditos_matriculados_media;
    }

    public Double getCreditos_reprovados_media() {
        return creditos_reprovados_media;
    }

    public void setCreditos_reprovados_media(Double creditos_reprovados_media) {
        this.creditos_reprovados_media = creditos_reprovados_media;
    }
}
