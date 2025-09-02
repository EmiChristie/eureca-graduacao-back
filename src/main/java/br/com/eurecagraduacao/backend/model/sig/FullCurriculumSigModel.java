package br.com.eurecagraduacao.backend.model.sig;

import br.com.eurecagraduacao.backend.model.eureca.CurriculumSubjectModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class FullCurriculumSigModel {

    @JsonProperty("codigo_do_curso")
    private Integer codigoDoCurso;

    @JsonProperty("codigo_do_curriculo")
    private String codigoDoCurriculo;

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
    private Integer disciplinaFlexivel;

    @JsonProperty("disciplina_atividades_complementares_extensao")
    private Integer disciplinaExtensao;

    @JsonProperty("periodo_inicio")
    private Integer periodoInicio;

    @JsonProperty("disciplinas_do_curriculo")
    private List<CurriculumSubjectModel> disciplinasDoCurriculo;

    public Integer getCodigoDoCurso() {
        return codigoDoCurso;
    }

    public String getCodigoDoCurriculo() {
        return codigoDoCurriculo;
    }

    public Integer getRegime() {
        return regime;
    }

    public Integer getDuracaoMinima() {
        return duracaoMinima;
    }

    public Integer getDuracaoMaxima() {
        return duracaoMaxima;
    }

    public Integer getDuracaoMedia() {
        return duracaoMedia;
    }

    public Integer getCargaHorariaCreditosMinima() {
        return cargaHorariaCreditosMinima;
    }

    public Integer getCargaHorariaCreditosMaxima() {
        return cargaHorariaCreditosMaxima;
    }

    public Integer getCargaHorariaObrigatoriasMinima() {
        return cargaHorariaObrigatoriasMinima;
    }

    public Integer getCargaHorariaOptativasMinima() {
        return cargaHorariaOptativasMinima;
    }

    public Integer getCargaHorariaAtividadesComplementaresMinima() {
        return cargaHorariaAtividadesComplementaresMinima;
    }

    public Integer getCargaHorariaMinimaTotal() {
        return cargaHorariaMinimaTotal;
    }

    public Integer getMinimoCreditosObrigatorias() {
        return minimoCreditosObrigatorias;
    }

    public Integer getMinimoCreditosOptativas() {
        return minimoCreditosOptativas;
    }

    public Integer getMinimoCreditosAtividadesComplementares() {
        return minimoCreditosAtividadesComplementares;
    }

    public Integer getMinimoCreditosTotal() {
        return minimoCreditosTotal;
    }

    public Integer getNumeroDisciplinasObrigatoriasMinimo() {
        return numeroDisciplinasObrigatoriasMinimo;
    }

    public Integer getNumeroDisciplinasOptativasMinimo() {
        return numeroDisciplinasOptativasMinimo;
    }

    public Integer getNumeroAtividadesComplementaresMinimo() {
        return numeroAtividadesComplementaresMinimo;
    }

    public Integer getNumeroDisciplinasMinimo() {
        return numeroDisciplinasMinimo;
    }

    public Integer getInterrupcoesMatriculaMaximo() {
        return interrupcoesMatriculaMaximo;
    }

    public Integer getInterrupcoesPeriodoMaximo() {
        return interrupcoesPeriodoMaximo;
    }

    public Integer getMatriculasInstitucionaisMaximo() {
        return matriculasInstitucionaisMaximo;
    }

    public Integer getMatriculasExtensaoMaximo() {
        return matriculasExtensaoMaximo;
    }

    public Integer getCargaHorariaExtensao() {
        return cargaHorariaExtensao;
    }

    public Integer getDisciplinaFlexivel() {
        return disciplinaFlexivel;
    }

    public Integer getDisciplinaExtensao() {
        return disciplinaExtensao;
    }

    public Integer getPeriodoInicio() {
        return periodoInicio;
    }

    public List<CurriculumSubjectModel> getDisciplinasDoCurriculo() {
        return disciplinasDoCurriculo;
    }

    @Override
    public String toString() {
        return "FullCurriculumModel{" +
                "codigoDoCurso=" + codigoDoCurso +
                ", codigoDoCurriculo=" + codigoDoCurriculo +
                ", regime=" + regime +
                ", duracaoMinima=" + duracaoMinima +
                ", duracaoMaxima=" + duracaoMaxima +
                ", duracaoMedia=" + duracaoMedia +
                ", cargaHorariaCreditosMinima=" + cargaHorariaCreditosMinima +
                ", cargaHorariaCreditosMaxima=" + cargaHorariaCreditosMaxima +
                ", cargaHorariaObrigatoriasMinima=" + cargaHorariaObrigatoriasMinima +
                ", cargaHorariaOptativasMinima=" + cargaHorariaOptativasMinima +
                ", cargaHorariaAtividadesComplementaresMinima=" + cargaHorariaAtividadesComplementaresMinima +
                ", cargaHorariaMinimaTotal=" + cargaHorariaMinimaTotal +
                ", minimoCreditosObrigatorias=" + minimoCreditosObrigatorias +
                ", minimoCreditosOptativas=" + minimoCreditosOptativas +
                ", minimoCreditosAtividadesComplementares=" + minimoCreditosAtividadesComplementares +
                ", minimoCreditosTotal=" + minimoCreditosTotal +
                ", numeroDisciplinasObrigatoriasMinimo=" + numeroDisciplinasObrigatoriasMinimo +
                ", numeroDisciplinasOptativasMinimo=" + numeroDisciplinasOptativasMinimo +
                ", numeroAtividadesComplementaresMinimo=" + numeroAtividadesComplementaresMinimo +
                ", numeroDisciplinasMinimo=" + numeroDisciplinasMinimo +
                ", interrupcoesMatriculaMaximo=" + interrupcoesMatriculaMaximo +
                ", interrupcoesPeriodoMaximo=" + interrupcoesPeriodoMaximo +
                ", matriculasInstitucionaisMaximo=" + matriculasInstitucionaisMaximo +
                ", matriculasExtensaoMaximo=" + matriculasExtensaoMaximo +
                ", cargaHorariaExtensao=" + cargaHorariaExtensao +
                ", disciplinaFlexivel=" + disciplinaFlexivel +
                ", disciplinaExtensao=" + disciplinaExtensao +
                ", periodoInicio=" + periodoInicio +
                ", disciplinasDoCurriculo=" + disciplinasDoCurriculo +
                '}';
    }
}
