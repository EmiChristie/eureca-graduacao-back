package br.com.eurecagraduacao.backend.dto.eureca;

import br.com.eurecagraduacao.backend.model.eureca.CurriculumSubjectModel;
import br.com.eurecagraduacao.backend.model.eureca.SubjectModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class DisciplinasCurriculoDTO {
    @JsonProperty("codigo_da_disciplina")
    private Integer codigoDaDisciplina;

    @JsonProperty("nome_da_disciplina")
    private String nomeDaDisciplina;

    @JsonProperty("tipo")
    private String tipo;

    @JsonProperty("status")
    private String status;

    @JsonProperty("semestre_ideal")
    private Integer semestreIdeal;

    @JsonProperty("quantidade_de_creditos")
    private Integer quantidadeDeCreditos;

    @JsonProperty("media_de_aprovacao")
    private Integer mediaDeAprovacao;

    @JsonProperty("codigo_do_setor")
    private Integer codigoDoSetor;

    @JsonProperty("horas_totais")
    private Integer horasTotais;

    @JsonProperty("pre_requisitos")
    private List<String> preRequisitos;

    @JsonProperty("co_requisitos")
    private List<String> coRequisitos;

    @JsonProperty("disciplinas_equivalentes")
    private List<EquivalentSubjectCodeDTO> disciplinasEquivalentes;

    public DisciplinasCurriculoDTO(Integer codigoDaDisciplina, String nome, String tipo, String status, Integer semestreIdeal,
                                   Integer quantidadeDeCreditos, Integer mediaAprovacao, Integer codigoSetor, Integer horasTotais,
                                   List<String> preRequisitos, List<String> coRequisitos, List<EquivalentSubjectCodeDTO> disciplinasEquivalentes) {
        this.codigoDaDisciplina = codigoDaDisciplina;
        this.nomeDaDisciplina = nome;
        this.tipo = tipo;
        this.status = status;
        this.semestreIdeal = semestreIdeal;
        this.quantidadeDeCreditos = quantidadeDeCreditos;
        this.mediaDeAprovacao = mediaAprovacao;
        this.codigoDoSetor = codigoSetor;
        this.horasTotais = horasTotais;
        this.preRequisitos = preRequisitos;
        this.coRequisitos = coRequisitos;
        this.disciplinasEquivalentes = disciplinasEquivalentes;
    }

    public DisciplinasCurriculoDTO() {

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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getSemestreIdeal() {
        return semestreIdeal;
    }

    public void setSemestreIdeal(Integer semestreIdeal) {
        this.semestreIdeal = semestreIdeal;
    }

    public Integer getQuantidadeDeCreditos() {
        return quantidadeDeCreditos;
    }

    public void setQuantidadeDeCreditos(Integer quantidadeDeCreditos) {
        this.quantidadeDeCreditos = quantidadeDeCreditos;
    }

    public Integer getMediaDeAprovacao() {
        return mediaDeAprovacao;
    }

    public void setMediaDeAprovacao(Integer mediaDeAprovacao) {
        this.mediaDeAprovacao = mediaDeAprovacao;
    }

    public Integer getCodigoDoSetor() {
        return codigoDoSetor;
    }

    public void setCodigoDoSetor(Integer codigoDoSetor) {
        this.codigoDoSetor = codigoDoSetor;
    }

    public Integer getHorasTotais() {
        return horasTotais;
    }

    public void setHorasTotais(Integer horasTotais) {
        this.horasTotais = horasTotais;
    }

    public List<String> getPreRequisitos() {
        return preRequisitos;
    }

    public void setPreRequisitos(List<String> preRequisitos) {
        this.preRequisitos = preRequisitos;
    }

    public List<String> getCoRequisitos() {
        return coRequisitos;
    }

    public void setCoRequisitos(List<String> coRequisitos) {
        this.coRequisitos = coRequisitos;
    }

    public List<EquivalentSubjectCodeDTO> getDisciplinasEquivalentes() {
        return disciplinasEquivalentes;
    }

    public void setDisciplinasEquivalentes(List<EquivalentSubjectCodeDTO> disciplinasEquivalentes) {
        this.disciplinasEquivalentes = disciplinasEquivalentes;
    }

    public DisciplinasCurriculoDTO fromModel(SubjectModel subjectModel, CurriculumSubjectModel curriculumSubjectModel) {
        DisciplinasCurriculoDTO disciplinasCurriculoDTO = new DisciplinasCurriculoDTO();

        disciplinasCurriculoDTO.setCodigoDaDisciplina(curriculumSubjectModel.getCodigo());
        disciplinasCurriculoDTO.setNomeDaDisciplina(curriculumSubjectModel.getNome());
        disciplinasCurriculoDTO.setTipo(subjectModel.getTipo());
        disciplinasCurriculoDTO.setStatus(curriculumSubjectModel.getStatus());
        disciplinasCurriculoDTO.setSemestreIdeal(Integer.parseInt(subjectModel.getSemestreIdeal()));
        disciplinasCurriculoDTO.setQuantidadeDeCreditos(curriculumSubjectModel.getCreditos());
        disciplinasCurriculoDTO.setMediaDeAprovacao(curriculumSubjectModel.getMediaAprovacao());
        disciplinasCurriculoDTO.setCodigoDoSetor(curriculumSubjectModel.getCodigoSetor());
        disciplinasCurriculoDTO.setHorasTotais(curriculumSubjectModel.getHorasTotais());
        disciplinasCurriculoDTO.setPreRequisitos(curriculumSubjectModel.getPreRequisitos());
        disciplinasCurriculoDTO.setCoRequisitos(curriculumSubjectModel.getCoRequisitos());

        List<EquivalentSubjectCodeDTO> equivalentSubjects = curriculumSubjectModel.getDisciplinasEquivalentes()
                .stream()
                .map(equivalentSubject -> {
                    EquivalentSubjectCodeDTO dto = new EquivalentSubjectCodeDTO();
                    dto.setCodigoDaDisciplina(equivalentSubject.getCodigo());
                    dto.setNomeDaDisciplina(equivalentSubject.getNome());
                    return dto;
                })
                .toList();
        disciplinasCurriculoDTO.setDisciplinasEquivalentes(equivalentSubjects);

        return disciplinasCurriculoDTO;
    }

}
