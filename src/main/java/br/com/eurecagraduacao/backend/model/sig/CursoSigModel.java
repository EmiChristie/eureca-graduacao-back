package br.com.eurecagraduacao.backend.model.sig;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CursoSigModel {

    @JsonProperty("codigo_do_curso")
    private Integer codigoDoCurso;

    @JsonProperty("descricao")
    private String descricao;

    @JsonProperty("status")
    private String status;

    @JsonProperty("grau_do_curso")
    private String grauDoCurso;

    @JsonProperty("codigo_do_setor")
    private Integer codigoDoSetor;

    @JsonProperty("nome_do_setor")
    private String nomeDoSetor;

    @JsonProperty("campus")
    private Integer campus;

    @JsonProperty("nome_do_campus")
    private String nomeDoCampus;

    @JsonProperty("turno")
    private String turno;

    @JsonProperty("periodo_de_inicio")
    private String periodoDeInicio;

    @JsonProperty("data_de_funcionamento")
    private String dataDeFuncionamento;

    @JsonProperty("codigo_inep")
    private Integer codigoInep;

    @JsonProperty("modalidade_academica")
    private String modalidadeAcademica;

    @JsonProperty("curriculo_atual")
    private String curriculoAtual;

    @JsonProperty("area_de_retencao")
    private Integer areaDeRetencao;

    @JsonProperty("ciclo_enade")
    private Integer cicloEnade;

    public Integer getCodigoDoCurso() {
        return codigoDoCurso;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getStatus() {
        return status;
    }

    public String getGrauDoCurso() {
        return grauDoCurso;
    }

    public Integer getCodigoDoSetor() {
        return codigoDoSetor;
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

    public String getTurno() {
        return turno;
    }

    public String getPeriodoDeInicio() {
        return periodoDeInicio;
    }

    public String getDataDeFuncionamento() {
        return dataDeFuncionamento;
    }

    public Integer getCodigoInep() {
        return codigoInep;
    }

    public String getModalidadeAcademica() {
        return modalidadeAcademica;
    }

    public String getCurriculoAtual() {
        return curriculoAtual;
    }

    public Integer getAreaDeRetencao() {
        return areaDeRetencao;
    }

    public Integer getCicloEnade() {
        return cicloEnade;
    }
}
