package br.com.eurecagraduacao.backend.dto.backend;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DisciplinaDistribuicaoPeriodosDTO {

    @JsonProperty("quantidade_de_matriculas")
    private Integer quantidadeDeMatriculas;

    @JsonProperty("quantidade_de_estudantes_analisados")
    private Integer quantidadeDeEstudantesAnalisados;

    @JsonProperty("erro_percentual")
    private Double erroPercentual;

    @JsonProperty("distribuicao")
    private List<DisciplinaDistribuicaoPeriodoDTO> distribuicao;

    public Integer getQuantidadeDeMatriculas() {
        return quantidadeDeMatriculas;
    }

    public void setQuantidadeDeMatriculas(Integer quantidadeDeMatriculas) {
        this.quantidadeDeMatriculas = quantidadeDeMatriculas;
    }

    public Integer getQuantidadeDeEstudantesAnalisados() {
        return quantidadeDeEstudantesAnalisados;
    }

    public void setQuantidadeDeEstudantesAnalisados(Integer quantidadeDeEstudantesAnalisados) {
        this.quantidadeDeEstudantesAnalisados = quantidadeDeEstudantesAnalisados;
    }

    public Double getErroPercentual() {
        return erroPercentual;
    }

    public void setErroPercentual(Double erroPercentual) {
        this.erroPercentual = erroPercentual;
    }

    public List<DisciplinaDistribuicaoPeriodoDTO> getDistribuicao() {
        return distribuicao;
    }

    public void setDistribuicao(List<DisciplinaDistribuicaoPeriodoDTO> distribuicao) {
        this.distribuicao = distribuicao;
    }
}
