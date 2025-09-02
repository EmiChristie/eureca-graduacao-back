package br.com.eurecagraduacao.backend.model.eureca;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SubjectModel {

    @JsonProperty("codigo_do_curso")
    private Integer codigoDoCurso;

    @JsonProperty("codigo_do_curriculo")
    private Integer codigoDoCurriculo;

    @JsonProperty("codigo_da_disciplina")
    private Integer codigoDaDisciplina;

    @JsonProperty("tipo")
    private String tipo;

    @JsonProperty("semestre_ideal")
    private String semestreIdeal;

    @JsonProperty("status")
    private String status;

    @JsonProperty("horas_totais")
    private Integer horasTotais;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("quantidade_de_creditos")
    private Integer quantidadeDeCreditos;

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

    public Integer getCodigoDaDisciplina() {
        return codigoDaDisciplina;
    }

    public void setCodigoDaDisciplina(Integer codigoDaDisciplina) {
        this.codigoDaDisciplina = codigoDaDisciplina;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSemestreIdeal() {
        return semestreIdeal;
    }

    public void setSemestreIdeal(String semestreIdeal) {
        this.semestreIdeal = semestreIdeal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getHorasTotais() {
        return horasTotais;
    }

    public void setHorasTotais(Integer horasTotais) {
        this.horasTotais = horasTotais;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidadeDeCreditos() {
        return quantidadeDeCreditos;
    }

    public void setQuantidadeDeCreditos(Integer quantidadeDeCreditos) {
        this.quantidadeDeCreditos = quantidadeDeCreditos;
    }
}
