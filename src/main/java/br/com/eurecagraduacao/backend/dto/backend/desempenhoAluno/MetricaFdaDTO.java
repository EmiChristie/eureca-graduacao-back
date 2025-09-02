package br.com.eurecagraduacao.backend.dto.backend.desempenhoAluno;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MetricaFdaDTO {

    @JsonProperty("fda")
    private List<PontoFdaDTO> fda;

    @JsonProperty("valor_do_aluno")
    private Double valorDoAluno;

    @JsonProperty("percentil")
    private Double percentil;

    public List<PontoFdaDTO> getFda() {
        return fda;
    }

    public void setFda(List<PontoFdaDTO> fda) {
        this.fda = fda;
    }

    public Double getValorDoAluno() {
        return valorDoAluno;
    }

    public void setValorDoAluno(Double valorDoAluno) {
        this.valorDoAluno = valorDoAluno;
    }

    public Double getPercentil() {
        return percentil;
    }

    public void setPercentil(Double percentil) {
        this.percentil = percentil;
    }
}
