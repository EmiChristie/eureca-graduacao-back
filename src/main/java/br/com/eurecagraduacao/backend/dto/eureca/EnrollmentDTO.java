package br.com.eurecagraduacao.backend.dto.eureca;

import br.com.eurecagraduacao.backend.model.eureca.EnrollmentModel;

public class EnrollmentDTO {

    private String status;
    private String periodo;
    private Double mediaFinal;

    public EnrollmentDTO() {
    }

    public EnrollmentDTO(String status, String periodo, Double mediaFinal) {
        this.status = status;
        this.periodo = periodo;
        this.mediaFinal = mediaFinal;
    }

    public static EnrollmentDTO fromModel(EnrollmentModel model) {
        return new EnrollmentDTO(
                model.getStatus(),
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
                ", periodo='" + periodo + '\'' +
                ", mediaFinal=" + mediaFinal +
                '}';
    }
}
