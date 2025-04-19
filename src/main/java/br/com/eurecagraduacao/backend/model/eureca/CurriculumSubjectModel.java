package br.com.eurecagraduacao.backend.model.eureca;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class CurriculumSubjectModel {

    @JsonProperty("codigo_da_disciplina")
    private Integer codigo;

    @JsonProperty("nome_da_disciplina")
    private String nome;

    @JsonProperty("carga_horaria_teorica_semanal")
    private Integer teoricaSemanal;

    @JsonProperty("carga_horaria_pratica_semanal")
    private Integer praticaSemanal;

    @JsonProperty("quantidade_de_creditos")
    private Integer creditos;

    @JsonProperty("horas_totais")
    private Integer horasTotais;

    @JsonProperty("media_de_aprovacao")
    private Integer mediaAprovacao;

    @JsonProperty("carga_horaria_teorica_minima")
    private Integer teoricaMinima;

    @JsonProperty("carga_horaria_pratica_minima")
    private Integer praticaMinima;

    @JsonProperty("carga_horaria_teorica_maxima")
    private Integer teoricaMaxima;

    @JsonProperty("carga_horaria_pratica_maxima")
    private Integer praticaMaxima;

    @JsonProperty("numero_de_semanas")
    private Integer numeroSemanas;

    @JsonProperty("codigo_do_setor")
    private Integer codigoSetor;

    @JsonProperty("status")
    private String status;

    @JsonProperty("contabiliza_creditos")
    private String contabilizaCreditos;

    @JsonProperty("tipo_de_componente_curricular")
    private String tipoComponente;

    @JsonProperty("carga_horaria_extensao")
    private Integer cargaHorariaExtensao;

    @JsonProperty("pre_requisitos")
    private List<String> preRequisitos;

    @JsonProperty("co_requisitos")
    private List<String> coRequisitos;

    @JsonProperty("disciplinas_equivalentes")
    private List<CurriculumEquivalentSubjectModel> disciplinasEquivalentes;

    // Getters and Setters

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getTeoricaSemanal() {
        return teoricaSemanal;
    }

    public void setTeoricaSemanal(Integer teoricaSemanal) {
        this.teoricaSemanal = teoricaSemanal;
    }

    public Integer getPraticaSemanal() {
        return praticaSemanal;
    }

    public void setPraticaSemanal(Integer praticaSemanal) {
        this.praticaSemanal = praticaSemanal;
    }

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

    public Integer getHorasTotais() {
        return horasTotais;
    }

    public void setHorasTotais(Integer horasTotais) {
        this.horasTotais = horasTotais;
    }

    public Integer getMediaAprovacao() {
        return mediaAprovacao;
    }

    public void setMediaAprovacao(Integer mediaAprovacao) {
        this.mediaAprovacao = mediaAprovacao;
    }

    public Integer getTeoricaMinima() {
        return teoricaMinima;
    }

    public void setTeoricaMinima(Integer teoricaMinima) {
        this.teoricaMinima = teoricaMinima;
    }

    public Integer getPraticaMinima() {
        return praticaMinima;
    }

    public void setPraticaMinima(Integer praticaMinima) {
        this.praticaMinima = praticaMinima;
    }

    public Integer getTeoricaMaxima() {
        return teoricaMaxima;
    }

    public void setTeoricaMaxima(Integer teoricaMaxima) {
        this.teoricaMaxima = teoricaMaxima;
    }

    public Integer getPraticaMaxima() {
        return praticaMaxima;
    }

    public void setPraticaMaxima(Integer praticaMaxima) {
        this.praticaMaxima = praticaMaxima;
    }

    public Integer getNumeroSemanas() {
        return numeroSemanas;
    }

    public void setNumeroSemanas(Integer numeroSemanas) {
        this.numeroSemanas = numeroSemanas;
    }

    public Integer getCodigoSetor() {
        return codigoSetor;
    }

    public void setCodigoSetor(Integer codigoSetor) {
        this.codigoSetor = codigoSetor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContabilizaCreditos() {
        return contabilizaCreditos;
    }

    public void setContabilizaCreditos(String contabilizaCreditos) {
        this.contabilizaCreditos = contabilizaCreditos;
    }

    public String getTipoComponente() {
        return tipoComponente;
    }

    public void setTipoComponente(String tipoComponente) {
        this.tipoComponente = tipoComponente;
    }

    public Integer getCargaHorariaExtensao() {
        return cargaHorariaExtensao;
    }

    public void setCargaHorariaExtensao(Integer cargaHorariaExtensao) {
        this.cargaHorariaExtensao = cargaHorariaExtensao;
    }

    public List<String> getPreRequisitos() {
        return preRequisitos;
    }

    public void setPreRequisitos(List<String> preRequisitos) {
        this.preRequisitos = preRequisitos;
    }

    public List<String> getCoRequisitos() {
        return coRequisitos;
    }

    public void setCoRequisitos(List<String> coRequisitos) {
        this.coRequisitos = coRequisitos;
    }

    public List<CurriculumEquivalentSubjectModel> getDisciplinasEquivalentes() {
        return disciplinasEquivalentes;
    }

    public void setDisciplinasEquivalentes(List<CurriculumEquivalentSubjectModel> disciplinasEquivalentes) {
        this.disciplinasEquivalentes = disciplinasEquivalentes;
    }
}
