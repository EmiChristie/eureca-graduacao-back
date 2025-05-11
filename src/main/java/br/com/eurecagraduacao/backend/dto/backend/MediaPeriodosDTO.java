package br.com.eurecagraduacao.backend.dto.backend;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class MediaPeriodosDTO {

    @JsonProperty("media_periodos_para_se_formar")
    private double media_periodos_para_se_formar;

    @JsonProperty("periodo_em_destaque")
    private String periodoEmDestaque;

    @JsonProperty("quantidade_media_periodos_para_se_formar")
    private List<Integer> quantidade_media_periodos_para_se_formar;

    @JsonProperty("graduados_por_qtd_periodos")
    private List<QuantidadeRealPeriodosDTO> distribuicaoPorPeriodoFormatura;

    public double getMedia_periodos_para_se_formar() {
        return media_periodos_para_se_formar;
    }

    public void setMedia_periodos_para_se_formar(double media_periodos_para_se_formar) {
        this.media_periodos_para_se_formar = media_periodos_para_se_formar;
    }

    public String getPeriodoEmDestaque() {
        return periodoEmDestaque;
    }

    public void setPeriodoEmDestaque(String periodoEmDestaque) {
        this.periodoEmDestaque = periodoEmDestaque;
    }


    public List<Integer> getQuantidade_media_periodos_para_se_formar() {
        return quantidade_media_periodos_para_se_formar;
    }

    public void setQuantidade_media_periodos_para_se_formar(List<Integer> quantidade_media_periodos_para_se_formar) {
        this.quantidade_media_periodos_para_se_formar = quantidade_media_periodos_para_se_formar;
    }

    public List<QuantidadeRealPeriodosDTO> getDistribuicaoPorPeriodoFormatura() {
        return distribuicaoPorPeriodoFormatura;
    }

    public void setDistribuicaoPorPeriodoFormatura(List<QuantidadeRealPeriodosDTO> distribuicaoPorPeriodoFormatura) {
        this.distribuicaoPorPeriodoFormatura = distribuicaoPorPeriodoFormatura;
    }
}

