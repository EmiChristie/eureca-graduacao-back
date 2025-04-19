package br.com.eurecagraduacao.backend.model.eureca;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EnrollmentModel {

    @JsonProperty("matricula_do_estudante")
    private String matriculaDoEstudante;

    @JsonProperty("codigo_da_disciplina")
    private Integer codigoDaDisciplina;

    @JsonProperty("nome_da_disciplina")
    private String nomeDaDisciplina;

    @JsonProperty("periodo")
    private String periodo;

    @JsonProperty("turma")
    private Integer turma;

    @JsonProperty("status")
    private String status;

    @JsonProperty("tipo")
    private String tipo;

    @JsonProperty("media_final")
    private Double mediaFinal;

    @JsonProperty("dispensas")
    private String dispensas;

    public String getMatriculaDoEstudante() {
        return matriculaDoEstudante;
    }

    public void setMatriculaDoEstudante(String matriculaDoEstudante) {
        this.matriculaDoEstudante = matriculaDoEstudante;
    }

    public Integer getCodigoDaDisciplina() {
        return codigoDaDisciplina;
    }

    public void setCodigoDaDisciplina(Integer codigoDaDisciplina) {
        this.codigoDaDisciplina = codigoDaDisciplina;
    }

    public String getNomeDaDisciplina() {
        return nomeDaDisciplina;
    }

    public void setNomeDaDisciplina(String nomeDaDisciplina) {
        this.nomeDaDisciplina = nomeDaDisciplina;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Integer getTurma() {
        return turma;
    }

    public void setTurma(Integer turma) {
        this.turma = turma;
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

    public Double getMediaFinal() {
        return mediaFinal;
    }

    public void setMediaFinal(Double mediaFinal) {
        this.mediaFinal = mediaFinal;
    }

    public String getDispensas() {
        return dispensas;
    }

    public void setDispensas(String dispensas) {
        this.dispensas = dispensas;
    }

    @Override
    public String toString() {
        return "EnrollmentModel{" +
                "matriculaDoEstudante='" + matriculaDoEstudante + '\'' +
                ", codigoDaDisciplina=" + codigoDaDisciplina +
                ", nomeDaDisciplina='" + nomeDaDisciplina + '\'' +
                ", periodo='" + periodo + '\'' +
                ", turma=" + turma +
                ", status='" + status + '\'' +
                ", tipo='" + tipo + '\'' +
                ", mediaFinal=" + mediaFinal +
                ", dispensas='" + dispensas + '\'' +
                '}';
    }
}
