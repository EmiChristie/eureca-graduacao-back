package br.com.eurecagraduacao.backend.model.eureca;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EnrollmentHistoryModel {

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

    public Integer getCodigoDaDisciplina() {
        return codigoDaDisciplina;
    }

    public String getNomeDaDisciplina() {
        return nomeDaDisciplina;
    }

    public String getPeriodo() {
        return periodo;
    }

    public Integer getTurma() {
        return turma;
    }

    public String getStatus() {
        return status;
    }

    public String getTipo() {
        return tipo;
    }

    public Double getMediaFinal() {
        return mediaFinal;
    }

    public String getDispensas() {
        return dispensas;
    }
}
