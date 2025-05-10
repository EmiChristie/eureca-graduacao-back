package br.com.eurecagraduacao.backend.dto.backend;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MetricasCursoDTO {

    @JsonProperty("codigo_do_curso")
    private Integer codigoDoCurso;

    @JsonProperty("graduados_evadidos_e_ativos_por_periodo")
    private List<CursoPeriodoMetricasDTO> graduados_evadidos_e_ativos_por_periodo;

    @JsonProperty("taxa_de_sucesso_media")
    private double taxaDeSucessoMedia;

    @JsonProperty("desvio_padrao_percentual")
    private double desvioPadraoPercentual;

    @JsonProperty("taxa_sucesso_media_mulheres")
    private double taxaSucessoMediaMulheres;

    @JsonProperty("desvio_padrao_percentual_mulheres")
    private double desvioPadraoPercentualMulheres;

    @JsonProperty("desvio_padrao_percentual_medio_de_genero")
    private double desvioPadraoPercentualGenero;

    @JsonProperty("porcentagem_media_mulheres_entre_graduados")
    private double porcentagemMulheresEntreGraduados;

    @JsonProperty("porcentagem_media_homens_entre_graduados")
    private double porcentagemHomensEntreGraduados;

    @JsonProperty("periodos_mais_comuns_de_evadir")
    private List<PeriodoEvasaoDTO> periodosEvasao;

    public Integer getCodigoDoCurso() {
        return codigoDoCurso;
    }

    public void setCodigoDoCurso(Integer codigoDoCurso) {
        this.codigoDoCurso = codigoDoCurso;
    }

    public List<CursoPeriodoMetricasDTO> getGraduados_evadidos_e_ativos_por_periodo() {
        return graduados_evadidos_e_ativos_por_periodo;
    }

    public void setGraduados_evadidos_e_ativos_por_periodo(List<CursoPeriodoMetricasDTO> lista) {
        this.graduados_evadidos_e_ativos_por_periodo = lista;
    }

    public double getTaxaDeSucessoMedia() {
        return taxaDeSucessoMedia;
    }

    public void setTaxaDeSucessoMedia(double taxaDeSucessoMedia) {
        this.taxaDeSucessoMedia = taxaDeSucessoMedia;
    }

    public double getDesvioPadraoPercentual() {
        return desvioPadraoPercentual;
    }

    public void setDesvioPadraoPercentual(double desvioPadraoPercentual) {
        this.desvioPadraoPercentual = desvioPadraoPercentual;
    }
    public double getTaxaSucessoMediaMulheres() {
        return taxaSucessoMediaMulheres;
    }

    public void setTaxaSucessoMediaMulheres(double taxaSucessoMediaMulheres) {
        this.taxaSucessoMediaMulheres = taxaSucessoMediaMulheres;
    }

    public double getDesvioPadraoPercentualGenero() {
        return desvioPadraoPercentualGenero;
    }

    public void setDesvioPadraoPercentualGenero(double desvioPadraoPercentualGenero) {
        this.desvioPadraoPercentualGenero = desvioPadraoPercentualGenero;
    }

    public void setDesvioPadraoPercentualMulheres(double desvioPadraoPercentualMulheres) {
        this.desvioPadraoPercentualMulheres = desvioPadraoPercentualMulheres;
    }

    public double getPorcentagemMulheresEntreGraduados() {
        return porcentagemMulheresEntreGraduados;
    }

    public void setPorcentagemMulheresEntreGraduados(double porcentagemMulheresEntreGraduados) {
        this.porcentagemMulheresEntreGraduados = porcentagemMulheresEntreGraduados;
    }

    public double getPorcentagemHomensEntreGraduados() {
        return porcentagemHomensEntreGraduados;
    }

    public void setPorcentagemHomensEntreGraduados(double porcentagemHomensEntreGraduados) {
        this.porcentagemHomensEntreGraduados = porcentagemHomensEntreGraduados;
    }

    public Double getTaxaDeSucesso() {
        return taxaDeSucessoMedia;
    }

    public void setPeriodosEvasao(List<PeriodoEvasaoDTO> periodosEvasao){
        this.periodosEvasao = periodosEvasao;
    }

}