package br.com.eurecagraduacao.backend.model.eureca;

import br.com.eurecagraduacao.backend.model.eureca.CurriculumSubjectModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class FullCurriculumModel {

    @JsonProperty("codigo_do_curso")
    private int codigoDoCurso;

    @JsonProperty("codigo_do_curriculo")
    private int codigoDoCurriculo;

    @JsonProperty("regime")
    private int regime;

    @JsonProperty("duracao_minima")
    private int duracaoMinima;

    @JsonProperty("duracao_maxima")
    private int duracaoMaxima;

    @JsonProperty("duracao_media")
    private int duracaoMedia;

    @JsonProperty("carga_horaria_creditos_minima")
    private int cargaHorariaCreditosMinima;

    @JsonProperty("carga_horaria_creditos_maxima")
    private int cargaHorariaCreditosMaxima;

    @JsonProperty("carga_horaria_disciplinas_obrigatorias_minima")
    private int cargaHorariaObrigatoriasMinima;

    @JsonProperty("carga_horaria_disciplinas_optativas_minima")
    private int cargaHorariaOptativasMinima;

    @JsonProperty("carga_horaria_atividades_complementares_minima")
    private int cargaHorariaAtividadesComplementaresMinima;

    @JsonProperty("carga_horaria_minima_total")
    private int cargaHorariaMinimaTotal;

    @JsonProperty("minimo_creditos_disciplinas_obrigatorias")
    private int minimoCreditosObrigatorias;

    @JsonProperty("minimo_creditos_disciplinas_optativas")
    private int minimoCreditosOptativas;

    @JsonProperty("minimo_creditos_atividades_complementares")
    private int minimoCreditosAtividadesComplementares;

    @JsonProperty("minimo_creditos_total")
    private int minimoCreditosTotal;

    @JsonProperty("numero_disciplinas_obrigatorias_minimo")
    private int numeroDisciplinasObrigatoriasMinimo;

    @JsonProperty("numero_disciplinas_optativas_minimo")
    private int numeroDisciplinasOptativasMinimo;

    @JsonProperty("numero_atividades_complementares_minimo")
    private int numeroAtividadesComplementaresMinimo;

    @JsonProperty("numero_disciplinas_minimo")
    private int numeroDisciplinasMinimo;

    @JsonProperty("numero_interrupcoes_matricula_maximo")
    private int interrupcoesMatriculaMaximo;

    @JsonProperty("numero_interrupcoes_periodo_maximo")
    private int interrupcoesPeriodoMaximo;

    @JsonProperty("numero_matriculas_institucionais_maximo")
    private int matriculasInstitucionaisMaximo;

    @JsonProperty("numero_matriculas_extensao_maximo")
    private int matriculasExtensaoMaximo;

    @JsonProperty("carga_horaria_extensao")
    private int cargaHorariaExtensao;

    @JsonProperty("disciplina_atividades_complementares_flexiveis")
    private int disciplinaFlexivel;

    @JsonProperty("disciplina_atividades_complementares_extensao")
    private int disciplinaExtensao;

    @JsonProperty("periodo_inicio")
    private int periodoInicio;

    @JsonProperty("disciplinas_do_curriculo")
    private List<CurriculumSubjectModel> disciplinasDoCurriculo;

    // Getters e setters omitidos por brevidade
}
