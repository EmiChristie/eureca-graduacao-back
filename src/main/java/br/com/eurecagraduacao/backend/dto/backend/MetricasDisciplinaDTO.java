package br.com.eurecagraduacao.backend.dto.backend;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class MetricasDisciplinaDTO {

    @JsonProperty("media_de_notas_dos_aprovados")
    private Double mediaDeNotasDosAprovados;

    @JsonProperty("distribuicao_de_status")
    private DisciplinaDistribuicaoStatusDTO distribuicaoDeStatus;

    @JsonProperty("distribuicao_de_periodos")
    private DisciplinaDistribuicaoPeriodosDTO distribuicaoDePeriodos;

    @JsonProperty("distribuicao_de_notas")
    private List<DisciplinaDistribuicaoNotasDTO> distribuicaoDeNotas;

    @JsonProperty("distribuicao_de_notas_faixa")
    private List<DisciplinaDistribuicaoNotasFaixaDTO> distribuicaoDeNotasFaixa;

    @JsonProperty("distribuicao_de_notas_em_faixas_de_aprovacao")
    private List<DisciplinaDistribuicaoNotasFaixaDTO> distribuicaoDeNotasEmFaixasDeAprovacao;


    public Double getMediaDeNotasDosAprovados() {
        return mediaDeNotasDosAprovados;
    }

    public void setMediaDeNotasDosAprovados(Double mediaDeNotasDosAprovados) {
        this.mediaDeNotasDosAprovados = mediaDeNotasDosAprovados;
    }

    public DisciplinaDistribuicaoStatusDTO getDistribuicaoDeStatus() {
        return distribuicaoDeStatus;
    }

    public void setDistribuicaoDeStatus(DisciplinaDistribuicaoStatusDTO distribuicaoDeStatus) {
        this.distribuicaoDeStatus = distribuicaoDeStatus;
    }

    public DisciplinaDistribuicaoPeriodosDTO getDistribuicaoDePeriodos() {
        return distribuicaoDePeriodos;
    }

    public void setDistribuicaoDePeriodos(DisciplinaDistribuicaoPeriodosDTO distribuicaoDePeriodos) {
        this.distribuicaoDePeriodos = distribuicaoDePeriodos;
    }

    public List<DisciplinaDistribuicaoNotasDTO> getDistribuicaoDeNotas() {
        return distribuicaoDeNotas;
    }

    public void setDistribuicaoDeNotas(List<DisciplinaDistribuicaoNotasDTO> distribuicaoDeNotas) {
        this.distribuicaoDeNotas = distribuicaoDeNotas;
    }

    public List<DisciplinaDistribuicaoNotasFaixaDTO> getDistribuicaoDeNotasFaixa() {
        return distribuicaoDeNotasFaixa;
    }

    public void setDistribuicaoDeNotasFaixa(List<DisciplinaDistribuicaoNotasFaixaDTO> distribuicaoDeNotasFaixa) {
        this.distribuicaoDeNotasFaixa = distribuicaoDeNotasFaixa;
    }

    public List<DisciplinaDistribuicaoNotasFaixaDTO> getDistribuicaoDeNotasEmFaixasDeAprovacao() {
        return distribuicaoDeNotasEmFaixasDeAprovacao;
    }

    public void setDistribuicaoDeNotasEmFaixasDeAprovacao(List<DisciplinaDistribuicaoNotasFaixaDTO> distribuicaoDeNotasEmFaixasDeAprovacao) {
        this.distribuicaoDeNotasEmFaixasDeAprovacao = distribuicaoDeNotasEmFaixasDeAprovacao;
    }
}
