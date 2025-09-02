package br.com.eurecagraduacao.backend.model.eureca;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurriculumModel {

    @JsonProperty("codigo_do_curso")
    private Integer codigoDoCurso;

    @JsonProperty("codigo_do_curriculo")
    private Integer codigoDoCurriculo;

    @JsonProperty("regime")
    private Integer regime;

    @JsonProperty("duracao_minima")
    private Integer duracaoMinima;

    @JsonProperty("duracao_maxima")
    private Integer duracaoMaxima;

    @JsonProperty("duracao_media")
    private Integer duracaoMedia;

    @JsonProperty("carga_horaria_creditos_minima")
    private Integer cargaHorariaCreditosMinima;

    @JsonProperty("carga_horaria_creditos_maxima")
    private Integer cargaHorariaCreditosMaxima;

    @JsonProperty("carga_horaria_disciplinas_obrigatorias_minima")
    private Integer cargaHorariaObrigatoriasMinima;

    @JsonProperty("carga_horaria_disciplinas_optativas_minima")
    private Integer cargaHorariaOptativasMinima;

    @JsonProperty("carga_horaria_atividades_complementares_minima")
    private Integer cargaHorariaAtividadesComplementaresMinima;

    @JsonProperty("carga_horaria_minima_total")
    private Integer cargaHorariaMinimaTotal;

    @JsonProperty("minimo_creditos_disciplinas_obrigatorias")
    private Integer minimoCreditosObrigatorias;

    @JsonProperty("minimo_creditos_disciplinas_optativas")
    private Integer minimoCreditosOptativas;

    @JsonProperty("minimo_creditos_atividades_complementares")
    private Integer minimoCreditosAtividadesComplementares;

    @JsonProperty("minimo_creditos_total")
    private Integer minimoCreditosTotal;

    @JsonProperty("numero_disciplinas_obrigatorias_minimo")
    private Integer numeroDisciplinasObrigatoriasMinimo;

    @JsonProperty("numero_disciplinas_optativas_minimo")
    private Integer numeroDisciplinasOptativasMinimo;

    @JsonProperty("numero_atividades_complementares_minimo")
    private Integer numeroAtividadesComplementaresMinimo;

    @JsonProperty("numero_disciplinas_minimo")
    private Integer numeroDisciplinasMinimo;

    @JsonProperty("numero_interrupcoes_matricula_maximo")
    private Integer interrupcoesMatriculaMaximo;

    @JsonProperty("numero_interrupcoes_periodo_maximo")
    private Integer interrupcoesPeriodoMaximo;

    @JsonProperty("numero_matriculas_institucionais_maximo")
    private Integer matriculasInstitucionaisMaximo;

    @JsonProperty("numero_matriculas_extensao_maximo")
    private Integer matriculasExtensaoMaximo;

    @JsonProperty("carga_horaria_extensao")
    private Integer cargaHorariaExtensao;

    @JsonProperty("disciplina_atividades_complementares_flexiveis")
    private Integer disciplinaAtividadesComplementaresFlexiveis;

    @JsonProperty("disciplina_atividades_complementares_extensao")
    private Integer disciplinaAtividadesComplementaresExtensao;

    @JsonProperty("periodo_inicio")
    private Integer periodoInicio;

    public Integer getCodigoDoCurriculo() {
        return this.codigoDoCurriculo;
    }
}
