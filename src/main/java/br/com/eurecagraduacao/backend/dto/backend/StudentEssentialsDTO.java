package br.com.eurecagraduacao.backend.dto.backend;

import br.com.eurecagraduacao.backend.model.eureca.StudentModel;
import br.com.eurecagraduacao.backend.model.sig.StudentSigModel;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StudentEssentialsDTO {

    @JsonProperty("matricula_do_estudante")
    private String matriculaDoEstudante;

    @JsonProperty("periodo_de_ingresso")
    private String periodoDeIngresso;

    public StudentEssentialsDTO(String matricula, String periodo) {
        this.matriculaDoEstudante = matricula;
        this.periodoDeIngresso = periodo;
    }

    public static StudentEssentialsDTO fromModel(StudentModel model) {
        return new StudentEssentialsDTO(
                model.getMatriculaDoEstudante(),
                model.getPeriodoDeIngresso()
        );
    }

    public static StudentEssentialsDTO fromModelSig(StudentSigModel model) {
        return new StudentEssentialsDTO(
                model.getMatriculaDoEstudante(),
                model.getPeriodoDeIngresso()
        );
    }

    public String getMatriculaDoEstudante() {
        return matriculaDoEstudante;
    }

    public void setMatriculaDoEstudante(String matriculaDoEstudante) {
        this.matriculaDoEstudante = matriculaDoEstudante;
    }

    public String getPeriodoDeIngresso() {
        return periodoDeIngresso;
    }

    public void setPeriodoDeIngresso(String periodoDeIngresso) {
        this.periodoDeIngresso = periodoDeIngresso;
    }
}
