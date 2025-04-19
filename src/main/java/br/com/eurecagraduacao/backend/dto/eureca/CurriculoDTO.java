package br.com.eurecagraduacao.backend.dto.eureca;

import br.com.eurecagraduacao.backend.model.eureca.FullCurriculumModel;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CurriculoDTO {

    @JsonProperty("codigo_do_curso")
    private Integer codigoDoCurso;

    @JsonProperty("codigo_do_curriculo")
    private Integer codigoDoCurriculo;

    @JsonProperty("duracao_minima")
    private Integer duracaoMinima;

    @JsonProperty("duracao_maxima")
    private Integer duracaoMaxima;

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

    @JsonProperty("numero_disciplinas_minimo")
    private Integer numeroDisciplinasMinimo;

    public Integer getCodigoDoCurso() {
        return codigoDoCurso;
    }

    public void setCodigoDoCurso(Integer codigoDoCurso) {
        this.codigoDoCurso = codigoDoCurso;
    }

    public Integer getCodigoDoCurriculo() {
        return codigoDoCurriculo;
    }

    public void setCodigoDoCurriculo(Integer codigoDoCurriculo) {
        this.codigoDoCurriculo = codigoDoCurriculo;
    }

    public Integer getDuracaoMinima() {
        return duracaoMinima;
    }

    public void setDuracaoMinima(Integer duracaoMinima) {
        this.duracaoMinima = duracaoMinima;
    }

    public Integer getDuracaoMaxima() {
        return duracaoMaxima;
    }

    public void setDuracaoMaxima(Integer duracaoMaxima) {
        this.duracaoMaxima = duracaoMaxima;
    }

    public Integer getCargaHorariaObrigatoriasMinima() {
        return cargaHorariaObrigatoriasMinima;
    }

    public void setCargaHorariaObrigatoriasMinima(Integer cargaHorariaObrigatoriasMinima) {
        this.cargaHorariaObrigatoriasMinima = cargaHorariaObrigatoriasMinima;
    }

    public Integer getCargaHorariaOptativasMinima() {
        return cargaHorariaOptativasMinima;
    }

    public void setCargaHorariaOptativasMinima(Integer cargaHorariaOptativasMinima) {
        this.cargaHorariaOptativasMinima = cargaHorariaOptativasMinima;
    }

    public Integer getCargaHorariaAtividadesComplementaresMinima() {
        return cargaHorariaAtividadesComplementaresMinima;
    }

    public void setCargaHorariaAtividadesComplementaresMinima(Integer cargaHorariaAtividadesComplementaresMinima) {
        this.cargaHorariaAtividadesComplementaresMinima = cargaHorariaAtividadesComplementaresMinima;
    }

    public Integer getCargaHorariaMinimaTotal() {
        return cargaHorariaMinimaTotal;
    }

    public void setCargaHorariaMinimaTotal(Integer cargaHorariaMinimaTotal) {
        this.cargaHorariaMinimaTotal = cargaHorariaMinimaTotal;
    }

    public Integer getMinimoCreditosObrigatorias() {
        return minimoCreditosObrigatorias;
    }

    public void setMinimoCreditosObrigatorias(Integer minimoCreditosObrigatorias) {
        this.minimoCreditosObrigatorias = minimoCreditosObrigatorias;
    }

    public Integer getMinimoCreditosOptativas() {
        return minimoCreditosOptativas;
    }

    public void setMinimoCreditosOptativas(Integer minimoCreditosOptativas) {
        this.minimoCreditosOptativas = minimoCreditosOptativas;
    }

    public Integer getMinimoCreditosAtividadesComplementares() {
        return minimoCreditosAtividadesComplementares;
    }

    public void setMinimoCreditosAtividadesComplementares(Integer minimoCreditosAtividadesComplementares) {
        this.minimoCreditosAtividadesComplementares = minimoCreditosAtividadesComplementares;
    }

    public Integer getMinimoCreditosTotal() {
        return minimoCreditosTotal;
    }

    public void setMinimoCreditosTotal(Integer minimoCreditosTotal) {
        this.minimoCreditosTotal = minimoCreditosTotal;
    }

    public Integer getNumeroDisciplinasObrigatoriasMinimo() {
        return numeroDisciplinasObrigatoriasMinimo;
    }

    public void setNumeroDisciplinasObrigatoriasMinimo(Integer numeroDisciplinasObrigatoriasMinimo) {
        this.numeroDisciplinasObrigatoriasMinimo = numeroDisciplinasObrigatoriasMinimo;
    }

    public Integer getNumeroDisciplinasOptativasMinimo() {
        return numeroDisciplinasOptativasMinimo;
    }

    public void setNumeroDisciplinasOptativasMinimo(Integer numeroDisciplinasOptativasMinimo) {
        this.numeroDisciplinasOptativasMinimo = numeroDisciplinasOptativasMinimo;
    }

    public Integer getNumeroDisciplinasMinimo() {
        return numeroDisciplinasMinimo;
    }

    public void setNumeroDisciplinasMinimo(Integer numeroDisciplinasMinimo) {
        this.numeroDisciplinasMinimo = numeroDisciplinasMinimo;
    }

    public static CurriculoDTO fromModel(FullCurriculumModel model) {
        CurriculoDTO dto = new CurriculoDTO();
        dto.setCodigoDoCurso(model.getCodigoDoCurso());
        dto.setCodigoDoCurriculo(model.getCodigoDoCurriculo());
        dto.setDuracaoMinima(model.getDuracaoMinima());
        dto.setDuracaoMaxima(model.getDuracaoMaxima());
        dto.setCargaHorariaObrigatoriasMinima(model.getCargaHorariaObrigatoriasMinima());
        dto.setCargaHorariaOptativasMinima(model.getCargaHorariaOptativasMinima());
        dto.setCargaHorariaAtividadesComplementaresMinima(model.getCargaHorariaAtividadesComplementaresMinima());
        dto.setCargaHorariaMinimaTotal(model.getCargaHorariaMinimaTotal());
        dto.setMinimoCreditosObrigatorias(model.getMinimoCreditosObrigatorias());
        dto.setMinimoCreditosOptativas(model.getMinimoCreditosOptativas());
        dto.setMinimoCreditosAtividadesComplementares(model.getMinimoCreditosAtividadesComplementares());
        dto.setMinimoCreditosTotal(model.getMinimoCreditosTotal());
        dto.setNumeroDisciplinasObrigatoriasMinimo(model.getNumeroDisciplinasObrigatoriasMinimo());
        dto.setNumeroDisciplinasOptativasMinimo(model.getNumeroDisciplinasOptativasMinimo());
        dto.setNumeroDisciplinasMinimo(model.getNumeroDisciplinasMinimo());
        return dto;
    }
}
