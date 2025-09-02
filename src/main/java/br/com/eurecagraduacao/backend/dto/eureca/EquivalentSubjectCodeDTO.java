package br.com.eurecagraduacao.backend.dto.eureca;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EquivalentSubjectCodeDTO {
    @JsonProperty("codigo_da_disciplina")
    private Integer codigoDaDisciplina;

    @JsonProperty("nome_da_disciplina")
    private String nomeDaDisciplina;

    public EquivalentSubjectCodeDTO(Integer codigoDaDisciplina, String nomeDaDisciplina) {
        this.codigoDaDisciplina = codigoDaDisciplina;
        this.nomeDaDisciplina = nomeDaDisciplina;
    }

    public EquivalentSubjectCodeDTO() {

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
}
