package br.com.eurecagraduacao.backend.model.sig;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurriculumCodeSigModel {

    @JsonProperty("codigo_do_curriculo")
    private String codigoDoCurriculo;

    public String getCodigoDoCurriculo() {
        return codigoDoCurriculo;
    }

    public void setCodigoDoCurriculo(String codigoDoCurriculo) {
        this.codigoDoCurriculo = codigoDoCurriculo;
    }
}
