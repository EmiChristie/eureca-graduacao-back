package br.com.eurecagraduacao.backend.dto.backend.desempenhoAluno;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PontoFdaDTO {

    @JsonProperty("valor")
    private Double valor;

    @JsonProperty("probabilidade_acumulada")
    private Double probabilidadeAcumulada;

    public PontoFdaDTO() {}

    public PontoFdaDTO(Double valor, Double probabilidadeAcumulada) {
        this.valor = valor;
        this.probabilidadeAcumulada = probabilidadeAcumulada;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getProbabilidadeAcumulada() {
        return probabilidadeAcumulada;
    }

    public void setProbabilidadeAcumulada(Double probabilidadeAcumulada) {
        this.probabilidadeAcumulada = probabilidadeAcumulada;
    }
}
