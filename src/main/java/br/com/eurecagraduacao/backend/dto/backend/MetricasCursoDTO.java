package br.com.eurecagraduacao.backend.dto.backend;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MetricasCursoDTO {

    @JsonProperty("codigo_do_curso")
    private Integer codigoDoCurso;

    @JsonProperty("graduados_evadidos_e_ativos_por_periodo")
    private List<CursoPeriodoMetricasDTO> graduados_evadidos_e_ativos_por_periodo;

    @JsonProperty("taxa_de_sucesso_media")
    private Double taxaDeSucessoMedia;

    @JsonProperty("desvio_padrao_percentual")
    private Double desvioPadraoPercentual;

    @JsonProperty("taxa_sucesso_media_mulheres")
    private Double taxaSucessoMediaMulheres;

    @JsonProperty("desvio_padrao_percentual_mulheres")
    private Double desvioPadraoPercentualMulheres;

    @JsonProperty("desvio_padrao_percentual_medio_de_genero")
    private Double desvioPadraoPercentualGenero;

    @JsonProperty("porcentagem_media_mulheres_entre_graduados")
    private Double porcentagemMulheresEntreGraduados;

    @JsonProperty("porcentagem_media_homens_entre_graduados")
    private Double porcentagemHomensEntreGraduados;

    @JsonProperty("erro_global")
    private Double erro;
    //porcentagem bruta de ativos entre todos os estudantes analisados = incertezas na análise

    @JsonProperty("periodos_mais_comuns_de_evadir")
    private List<PeriodoEvasaoDTO> periodosEvasao;

    @JsonProperty("media_periodos_para_se_formar")
    private MediaPeriodosDTO mediaPeriodos;

    @JsonProperty("taxas_medias_graduados")
    private List<TaxasCalculadasGraduadosDTO> taxasGraduados;

    @JsonProperty("taxas_medias_globais")
    private TaxasCalculadasGraduadosGlobaisDTO taxasGlobais;

    @JsonProperty("perfil_aluno_medio")
    private PerfilAlunoMedioDTO alunoMedio;

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

    public Double getTaxaDeSucessoMedia() {
        return taxaDeSucessoMedia;
    }

    public void setTaxaDeSucessoMedia(Double taxaDeSucessoMedia) {
        this.taxaDeSucessoMedia = taxaDeSucessoMedia;
    }

    public Double getDesvioPadraoPercentual() {
        return desvioPadraoPercentual;
    }

    public void setDesvioPadraoPercentual(Double desvioPadraoPercentual) {
        this.desvioPadraoPercentual = desvioPadraoPercentual;
    }
    public Double getTaxaSucessoMediaMulheres() {
        return taxaSucessoMediaMulheres;
    }

    public void setTaxaSucessoMediaMulheres(Double taxaSucessoMediaMulheres) {
        this.taxaSucessoMediaMulheres = taxaSucessoMediaMulheres;
    }

    public Double getDesvioPadraoPercentualGenero() {
        return desvioPadraoPercentualGenero;
    }

    public void setDesvioPadraoPercentualGenero(Double desvioPadraoPercentualGenero) {
        this.desvioPadraoPercentualGenero = desvioPadraoPercentualGenero;
    }

    public void setDesvioPadraoPercentualMulheres(Double desvioPadraoPercentualMulheres) {
        this.desvioPadraoPercentualMulheres = desvioPadraoPercentualMulheres;
    }

    public Double getPorcentagemMulheresEntreGraduados() {
        return porcentagemMulheresEntreGraduados;
    }

    public void setPorcentagemMulheresEntreGraduados(Double porcentagemMulheresEntreGraduados) {
        this.porcentagemMulheresEntreGraduados = porcentagemMulheresEntreGraduados;
    }

    public Double getPorcentagemHomensEntreGraduados() {
        return porcentagemHomensEntreGraduados;
    }

    public void setPorcentagemHomensEntreGraduados(Double porcentagemHomensEntreGraduados) {
        this.porcentagemHomensEntreGraduados = porcentagemHomensEntreGraduados;
    }

    public Double getTaxaDeSucesso() {
        return taxaDeSucessoMedia;
    }

    public void setPeriodosEvasao(List<PeriodoEvasaoDTO> periodosEvasao){
        this.periodosEvasao = periodosEvasao;
    }

    public Double getErro() {
        return erro;
    }

    public void setErro(Double erro){
        this.erro = erro;
    }

    public MediaPeriodosDTO getMediaPeriodos() {
        return mediaPeriodos;
    }

    public void setMediaPeriodos(MediaPeriodosDTO mediaPeriodos){
        this.mediaPeriodos = mediaPeriodos;
    }

    public List<TaxasCalculadasGraduadosDTO> getTaxasGraduados() {
        return taxasGraduados;
    }

    public void setTaxasGraduados(List<TaxasCalculadasGraduadosDTO> taxasGraduados){
        this.taxasGraduados = taxasGraduados;
    }

    public TaxasCalculadasGraduadosGlobaisDTO getTaxasGlobais() {
        return taxasGlobais;
    }

    public void setTaxasGlobais(TaxasCalculadasGraduadosGlobaisDTO taxasGlobais){
        this.taxasGlobais = taxasGlobais;
    }

    public PerfilAlunoMedioDTO getAlunoMedio() {
        return alunoMedio;
    }

    public void setAlunoMedio(PerfilAlunoMedioDTO alunoMedio){
        this.alunoMedio = alunoMedio;
    }

}