package br.com.eurecagraduacao.backend.model.eureca;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class CurriculumSubjectModel {

    @JsonProperty("codigo_da_disciplina")
    private int codigo;

    @JsonProperty("nome_da_disciplina")
    private String nome;

    @JsonProperty("carga_horaria_teorica_semanal")
    private int teoricaSemanal;

    @JsonProperty("carga_horaria_pratica_semanal")
    private int praticaSemanal;

    @JsonProperty("quantidade_de_creditos")
    private int creditos;

    @JsonProperty("horas_totais")
    private int horasTotais;

    @JsonProperty("media_de_aprovacao")
    private int mediaAprovacao;

    @JsonProperty("carga_horaria_teorica_minima")
    private int teoricaMinima;

    @JsonProperty("carga_horaria_pratica_minima")
    private int praticaMinima;

    @JsonProperty("carga_horaria_teorica_maxima")
    private int teoricaMaxima;

    @JsonProperty("carga_horaria_pratica_maxima")
    private int praticaMaxima;

    @JsonProperty("numero_de_semanas")
    private int numeroSemanas;

    @JsonProperty("codigo_do_setor")
    private int codigoSetor;

    @JsonProperty("status")
    private String status;

    @JsonProperty("contabiliza_creditos")
    private String contabilizaCreditos;

    @JsonProperty("tipo_de_componente_curricular")
    private String tipoComponente;

    @JsonProperty("carga_horaria_extensao")
    private int cargaHorariaExtensao;

    @JsonProperty("pre_requisitos")
    private List<String> preRequisitos;

    @JsonProperty("co_requisitos")
    private List<String> coRequisitos;

    @JsonProperty("disciplinas_equivalentes")
    private List<CurriculumEquivalentSubjectModel> disciplinasEquivalentes;

    // Getters e setters omitidos por brevidade
}
