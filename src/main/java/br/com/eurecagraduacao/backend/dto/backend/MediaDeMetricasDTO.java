package br.com.eurecagraduacao.backend.dto.backend;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MediaDeMetricasDTO {

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
}