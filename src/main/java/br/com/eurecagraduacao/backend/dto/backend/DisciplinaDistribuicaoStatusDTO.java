package br.com.eurecagraduacao.backend.dto.backend;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DisciplinaDistribuicaoStatusDTO {

    @JsonProperty("aprovados_por_nota")
    private Integer aprovadosPorNota;

    @JsonProperty("dispensados")
    private Integer dispensados;

    @JsonProperty("reprovados_por_nota")
    private Integer reprovadosPorNota;

    @JsonProperty("reprovados_por_falta")
    private Integer reprovadosPorFalta;

    @JsonProperty("trancados")
    private Integer trancados;

    @JsonProperty("cancelados")
    private Integer cancelados;

    @JsonProperty("total")
    private Integer total;

    public Integer getAprovadosPorNota() {
        return aprovadosPorNota;
    }

    public void setAprovadosPorNota(Integer aprovadosPorNota) {
        this.aprovadosPorNota = aprovadosPorNota;
    }

    public Integer getDispensados() {
        return dispensados;
    }

    public void setDispensados(Integer dispensados) {
        this.dispensados = dispensados;
    }

    public Integer getReprovadosPorNota() {
        return reprovadosPorNota;
    }

    public void setReprovadosPorNota(Integer reprovadosPorNota) {
        this.reprovadosPorNota = reprovadosPorNota;
    }

    public Integer getReprovadosPorFalta() {
        return reprovadosPorFalta;
    }

    public void setReprovadosPorFalta(Integer reprovadosPorFalta) {
        this.reprovadosPorFalta = reprovadosPorFalta;
    }

    public Integer getTrancados() {
        return trancados;
    }

    public void setTrancados(Integer trancados) {
        this.trancados = trancados;
    }

    public Integer getCancelados() {
        return cancelados;
    }

    public void setCancelados(Integer cancelados) {
        this.cancelados = cancelados;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
