package br.com.eurecagraduacao.backend.model.eureca;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurriculumCodeModel {

    @JsonProperty("codigo_do_curriculo")
    private int codigoDoCurriculo;

    public int getCodigoDoCurriculo() {
        return codigoDoCurriculo;
    }

    public void setCodigoDoCurriculo(int codigoDoCurriculo) {
        this.codigoDoCurriculo = codigoDoCurriculo;
    }
}
