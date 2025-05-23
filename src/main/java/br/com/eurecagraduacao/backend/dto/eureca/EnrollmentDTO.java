package br.com.eurecagraduacao.backend.dto.eureca;

import br.com.eurecagraduacao.backend.model.eureca.EnrollmentModel;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EnrollmentDTO {

    @JsonProperty("matricula_do_estudante")
    private String matriculaDoEstudante;

    @JsonProperty("status")
    private String status;

    @JsonProperty("tipo")
    private String tipo;

    @JsonProperty("periodo")
    private String periodo;

    @JsonProperty("media_final")
    private Double mediaFinal;

    public EnrollmentDTO() {
    }

    public EnrollmentDTO(String status, String tipo, String periodo, Double mediaFinal, String matriculaDoEstudante) {
        this.status = status;
        this.tipo = tipo;
        this.periodo = periodo;
        this.mediaFinal = mediaFinal;
        this.matriculaDoEstudante = matriculaDoEstudante;
    }

    public static EnrollmentDTO fromModel(EnrollmentModel model) {
        return new EnrollmentDTO(
                model.getStatus(),
                model.getTipo(),
                model.getPeriodo(),
                model.getMediaFinal(),
                model.getMatriculaDoEstudante()
        );
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Double getMediaFinal() {
        return mediaFinal;
    }

    public void setMediaFinal(Double mediaFinal) {
        this.mediaFinal = mediaFinal;
    }

    public String getMatriculaDoEstudante() {
        return matriculaDoEstudante;
    }

    public void setMatriculaDoEstudante(String matriculaDoEstudante) {
        this.matriculaDoEstudante = matriculaDoEstudante;
    }

    @Override
    public String toString() {
        return "EnrollmentDTO{" +
                "status='" + status + '\'' +
                ", tipo='" + tipo + '\'' +
                ", periodo='" + periodo + '\'' +
                ", mediaFinal=" + mediaFinal +
                ", matriculaDoEstudante='" + matriculaDoEstudante + '\'' +
                '}';
    }
}
