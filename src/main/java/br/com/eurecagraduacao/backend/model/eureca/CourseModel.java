package br.com.eurecagraduacao.backend.model.eureca;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CourseModel {

    @JsonProperty("codigo_do_curso")
    private int codigoDoCurso;

    @JsonProperty("descricao")
    private String descricao;

    @JsonProperty("status")
    private String status;

    @JsonProperty("grau_do_curso")
    private String grauDoCurso;

    @JsonProperty("codigo_do_setor")
    private int codigoDoSetor;

    @JsonProperty("nome_do_setor")
    private String nomeDoSetor;

    @JsonProperty("campus")
    private int campus;

    @JsonProperty("nome_do_campus")
    private String nomeDoCampus;

    @JsonProperty("turno")
    private String turno;

    @JsonProperty("periodo_de_inicio")
    private String periodoDeInicio;

    @JsonProperty("data_de_funcionamento")
    private String dataDeFuncionamento;

    @JsonProperty("codigo_inep")
    private int codigoInep;

    @JsonProperty("modalidade_academica")
    private String modalidadeAcademica;

    @JsonProperty("curriculo_atual")
    private int curriculoAtual;

    @JsonProperty("area_de_retencao")
    private int areaDeRetencao;

    @JsonProperty("ciclo_enade")
    private int cicloEnade;
}
