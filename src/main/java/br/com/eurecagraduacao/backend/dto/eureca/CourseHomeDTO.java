package br.com.eurecagraduacao.backend.dto.eureca;

import br.com.eurecagraduacao.backend.model.sig.CursoSigModel;
import com.fasterxml.jackson.annotation.JsonProperty;

import static br.com.eurecagraduacao.backend.util.MapeamentoCursos.getAreaDeRetencao;
import static br.com.eurecagraduacao.backend.util.MapeamentoUtils.mapArea;
import static br.com.eurecagraduacao.backend.util.StringUtils.formatarNome;

public class CourseHomeDTO {

    @JsonProperty("codigo_do_curso")
    private Integer codigoDoCurso;

    @JsonProperty("descricao")
    private String descricao;

    @JsonProperty("campus")
    private Integer campus;

    @JsonProperty("nome_do_campus")
    private String nomeDoCampus;

    @JsonProperty("area_de_retencao")
    private Integer areaDeRetencao;

    @JsonProperty("area_de_retencao_descricao")
    private String areaDeRetencaoDesc;

    @JsonProperty("codigo_do_curriculo")
    private Integer curriculo;

    public CourseHomeDTO(Integer codigoDoCurso, String descricao, Integer campus, String nomeDoCampus, Integer areaDeRetencao, Integer curriculo) {
        this.codigoDoCurso = codigoDoCurso;
        this.descricao = descricao;
        this.campus = campus;
        this.nomeDoCampus = nomeDoCampus;
        this.areaDeRetencao = areaDeRetencao;
        this.areaDeRetencaoDesc = mapArea(areaDeRetencao);
        this.curriculo = curriculo;
    }

    public static CourseHomeDTO fromModel(CursoSigModel model, Integer curriculo) {
        return new CourseHomeDTO(
                model.getCodigoDoCurso(),
                formatarNome(model.getDescricao()),
                model.getCampus(),
                formatarNome(model.getNomeDoCampus()),
                getAreaDeRetencao(model.getCodigoDoCurso()),
                curriculo
        );
    }

    @Override
    public String toString() {
        return "CourseDTO{" +
                "codigoDoCurso=" + codigoDoCurso +
                ", descricao='" + descricao + '\'' +
                ", campus=" + campus +
                ", nomeDoCampus='" + nomeDoCampus + '\'' +
                ", areaDeRetencao=" + areaDeRetencao +
                ", areaDeRetencaoDesc='" + areaDeRetencaoDesc + '\'' +
                ", curriculo='" + curriculo + '\'' +
                '}';
    }
}
