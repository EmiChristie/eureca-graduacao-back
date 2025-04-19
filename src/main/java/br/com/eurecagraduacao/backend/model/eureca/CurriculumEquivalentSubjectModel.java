package br.com.eurecagraduacao.backend.model.eureca;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurriculumEquivalentSubjectModel {

    @JsonProperty("codigo_da_disciplina")
    private Integer codigo;

    @JsonProperty("nome")
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

    @JsonProperty("nome_do_setor")
    private String nomeDoSetor;

    @JsonProperty("campus")
    private Integer campus;

    @JsonProperty("nome_do_campus")
    private String nomeDoCampus;

    @JsonProperty("status")
    private String status;

    @JsonProperty("contabiliza_creditos")
    private String contabilizaCreditos;

    @JsonProperty("tipo_de_componente_curricular")
    private String tipoComponente;

    @JsonProperty("carga_horaria_extensao")
    private Integer cargaHorariaExtensao;

    // Getters
    public Integer getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public Integer getTeoricaSemanal() {
        return teoricaSemanal;
    }

    public Integer getPraticaSemanal() {
        return praticaSemanal;
    }

    public Integer getCreditos() {
        return creditos;
    }

    public Integer getHorasTotais() {
        return horasTotais;
    }

    public Integer getMediaAprovacao() {
        return mediaAprovacao;
    }

    public Integer getTeoricaMinima() {
        return teoricaMinima;
    }

    public Integer getPraticaMinima() {
        return praticaMinima;
    }

    public Integer getTeoricaMaxima() {
        return teoricaMaxima;
    }

    public Integer getPraticaMaxima() {
        return praticaMaxima;
    }

    public Integer getNumeroSemanas() {
        return numeroSemanas;
    }

    public Integer getCodigoSetor() {
        return codigoSetor;
    }

    public String getNomeDoSetor() {
        return nomeDoSetor;
    }

    public Integer getCampus() {
        return campus;
    }

    public String getNomeDoCampus() {
        return nomeDoCampus;
    }

    public String getStatus() {
        return status;
    }

    public String getContabilizaCreditos() {
        return contabilizaCreditos;
    }

    public String getTipoComponente() {
        return tipoComponente;
    }

    public Integer getCargaHorariaExtensao() {
        return cargaHorariaExtensao;
    }
}
