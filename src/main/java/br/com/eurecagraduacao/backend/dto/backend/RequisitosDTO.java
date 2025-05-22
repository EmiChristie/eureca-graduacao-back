package br.com.eurecagraduacao.backend.dto.backend;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class RequisitosDTO {

    @JsonProperty("pre_requisitos")
    private List<DisciplinaRelacionadaDTO> preRequisitos;

    @JsonProperty("co_requisitos")
    private List<DisciplinaRelacionadaDTO> coRequisitos;

    @JsonProperty("disciplinas_equivalentes")
    private List<DisciplinaRelacionadaDTO> disciplinasEquivalentes;

    public RequisitosDTO() {
        this.preRequisitos = new ArrayList<>();
        this.coRequisitos = new ArrayList<>();
        this.disciplinasEquivalentes = new ArrayList<>();
    }

    public List<DisciplinaRelacionadaDTO> getPre_requisitos() {
        return preRequisitos;
    }

    public void setPre_requisitos(List<DisciplinaRelacionadaDTO> preRequisitos) {
        this.preRequisitos = preRequisitos;
    }

    public List<DisciplinaRelacionadaDTO> getCo_requisitos() {
        return coRequisitos;
    }

    public void setCo_requisitos(List<DisciplinaRelacionadaDTO> coRequisitos) {
        this.coRequisitos = coRequisitos;
    }

    public List<DisciplinaRelacionadaDTO> getDisciplinas_equivalentes() {
        return disciplinasEquivalentes;
    }

    public void setDisciplinas_equivalentes(List<DisciplinaRelacionadaDTO> disciplinasEquivalentes) {
        this.disciplinasEquivalentes = disciplinasEquivalentes;
    }
}
