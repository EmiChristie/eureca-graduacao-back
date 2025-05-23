package br.com.eurecagraduacao.backend.dto.eureca;

import br.com.eurecagraduacao.backend.model.eureca.EnrollmentModel;

public class EnrollmentDTO {

    private String status;
    private String tipo;
    private String periodo;
    private Double mediaFinal;

    public EnrollmentDTO() {
    }

    public EnrollmentDTO(String status, String tipo, String periodo, Double mediaFinal) {
        this.status = status;
        this.tipo = tipo;
        this.periodo = periodo;
        this.mediaFinal = mediaFinal;
    }

    public static EnrollmentDTO fromModel(EnrollmentModel model) {
        return new EnrollmentDTO(
                model.getStatus(),
                model.getTipo(),
                model.getPeriodo(),
                model.getMediaFinal()
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

    @Override
    public String toString() {
        return "EnrollmentDTO{" +
                "status='" + status + '\'' +
                ", tipo='" + tipo + '\'' +
                ", periodo='" + periodo + '\'' +
                ", mediaFinal=" + mediaFinal +
                '}';
    }
}
