package br.com.eurecagraduacao.backend.dto.eureca;

import br.com.eurecagraduacao.backend.model.eureca.CourseModel;
import com.fasterxml.jackson.annotation.JsonProperty;

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

    public static CourseHomeDTO fromModel(CourseModel model, Integer curriculo) {
        return new CourseHomeDTO(
                model.getCodigoDoCurso(),
                model.getDescricao(),
                model.getCampus(),
                model.getNomeDoCampus(),
                model.getAreaDeRetencao(),
                curriculo
        );
    }

    public String mapArea(Integer area){
        if(area == null){
            return "Sem registro";
        }
        return switch (area) {
            case 1 -> "Medicina";
            case 2 -> "Veterinária, Odontologia, Zootecnia";
            case 3 -> "Ciências Exatas e da Terra";
            case 4 -> "Ciências Biológicas";
            case 5 -> "Engenharias";
            case 6 -> "Tecnólogos";
            case 7 -> "Nutrição, Farmácia";
            case 8 -> "Ciências Agrárias";
            case 9 -> "Ciências Exatas – Computação";
            case 10 -> "Ciências Exatas – Matemática e Estatística";
            case 11 -> "Arquitetura/Urbanismo";
            case 12 -> "Artes";
            case 13 -> "Música";
            case 14 -> "Enfermagem, Fisioterapia, Fonoaudiologia e Educação Física";
            case 15 -> "Ciências Sociais Aplicadas";
            case 16 -> "Direito";
            case 17 -> "Linguística e Letras";
            case 18 -> "Ciências Humanas";
            case 19 -> "Psicologia";
            case 20 -> "Formação de Professor";
            default -> "Sem registro";
        };
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
