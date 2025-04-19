package br.com.eurecagraduacao.backend.model.eureca;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MetricsHistoryModel {

    @JsonProperty("periodo")
    private String periodo;

    @JsonProperty("cra")
    private double cra;

    @JsonProperty("mc")
    private double mc;

    @JsonProperty("iech")
    private double iech;

    @JsonProperty("iepl")
    private double iepl;

    @JsonProperty("iea")
    private double iea;

    @JsonProperty("mcn")
    private double mcn;

    @JsonProperty("iean")
    private double iean;

    @JsonProperty("creditos_do_cra")
    private Integer creditosDoCra;

    @JsonProperty("notas_acumuladas")
    private double notasAcumuladas;

    @JsonProperty("periodos_completados")
    private Integer periodosCompletados;

    @JsonProperty("creditos_tentados")
    private Integer creditosTentados;

    @JsonProperty("creditos_completados")
    private Integer creditosCompletados;

    @JsonProperty("creditos_isentos")
    private Integer creditosIsentos;

    @JsonProperty("creditos_suspensos")
    private Integer creditosSuspensos;

    @JsonProperty("creditos_falhados")
    private Integer creditosFalhados;

    @JsonProperty("creditos_em_andamento")
    private Integer creditosEmAndamento;

    @JsonProperty("velocidade_media")
    private double velocidadeMedia;

    @JsonProperty("taxa_de_sucesso")
    private double taxaDeSucesso;

    public String getPeriodo() {
        return periodo;
    }

    public double getCra() {
        return cra;
    }

    public double getMc() {
        return mc;
    }

    public double getIech() {
        return iech;
    }

    public double getIepl() {
        return iepl;
    }

    public double getIea() {
        return iea;
    }

    public double getMcn() {
        return mcn;
    }

    public double getIean() {
        return iean;
    }

    public Integer getCreditosDoCra() {
        return creditosDoCra;
    }

    public double getNotasAcumuladas() {
        return notasAcumuladas;
    }

    public Integer getPeriodosCompletados() {
        return periodosCompletados;
    }

    public Integer getCreditosTentados() {
        return creditosTentados;
    }

    public Integer getCreditosCompletados() {
        return creditosCompletados;
    }

    public Integer getCreditosIsentos() {
        return creditosIsentos;
    }

    public Integer getCreditosFalhados() {
        return creditosFalhados;
    }

    public Integer getCreditosSuspensos() {
        return creditosSuspensos;
    }

    public Integer getCreditosEmAndamento() {
        return creditosEmAndamento;
    }

    public double getVelocidadeMedia() {
        return velocidadeMedia;
    }

    public double getTaxaDeSucesso() {
        return taxaDeSucesso;
    }
}
