package br.com.eurecagraduacao.backend.dto.eureca;

import br.com.eurecagraduacao.backend.model.eureca.StudentModel;
import br.com.eurecagraduacao.backend.model.sig.StudentSigModel;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import static br.com.eurecagraduacao.backend.util.CalculoUtils.round2;

public class StudentDTO {

    @JsonProperty("matricula_do_estudante")
    private String matricula;

    @JsonProperty("sexo")
    private String sexo;

    @JsonProperty("cor")
    private String cor;

    @JsonProperty("deficiencias")
    private List<String> deficiencias;

    @JsonProperty("politica_afirmativa")
    private String politicaAfirmativa;

    @JsonProperty("cra")
    private Double cra;

    @JsonProperty("creditos_do_cra")
    private Integer creditosDoCra;

    @JsonProperty("notas_acumuladas")
    private Double notasAcumuladas;

    @JsonProperty("periodos_completados")
    private Integer periodosCompletados;

    @JsonProperty("creditos_tentados")
    private Integer creditosTentados;

    @JsonProperty("creditos_completados")
    private Integer creditosCompletados;

    @JsonProperty("creditos_isentos")
    private Integer creditosIsentos;

    @JsonProperty("creditos_falhados")
    private Integer creditosFalhados;

    @JsonProperty("creditos_suspensos")
    private Integer creditosSuspensos;

    @JsonProperty("creditos_em_andamento")
    private Integer creditosEmAndamento;

    @JsonProperty("velocidade_media")
    private Double velocidadeMedia;

    @JsonProperty("taxa_de_sucesso")
    private Double taxaDeSucesso;

    @JsonProperty("situacao")
    private String situacao;

    @JsonProperty("periodo_de_evasao")
    private String periodoDeEvasao;

    @JsonProperty("motivo_de_evasao")
    private String motivoDeEvasao;

    @JsonProperty("periodo_de_ingresso")
    private String periodoDeIngresso;

    public static StudentDTO fromModel(StudentModel model) {
        StudentDTO dto = new StudentDTO();
        dto.matricula = model.getMatriculaDoEstudante();
        dto.sexo = model.getSexo();
        dto.cor = model.getCor();
        dto.deficiencias = model.getDeficiencias();
        dto.politicaAfirmativa = model.getPoliticaAfirmativa();
        dto.cra = model.getCra();
        dto.creditosDoCra = model.getCreditosDoCra();
        dto.notasAcumuladas = model.getNotasAcumuladas();
        dto.periodosCompletados = model.getPeriodosCompletados();
        dto.creditosTentados = model.getCreditosTentados();
        dto.creditosCompletados = model.getCreditosCompletados();
        dto.creditosIsentos = model.getCreditosIsentos();
        dto.creditosFalhados = model.getCreditosFalhados();
        dto.creditosSuspensos = model.getCreditosSuspensos();
        dto.creditosEmAndamento = model.getCreditosEmAndamento();
        dto.velocidadeMedia = model.getVelocidadeMedia();
        dto.taxaDeSucesso = model.getTaxaDeSucesso();
        dto.situacao = model.getSituacao();
        dto.periodoDeEvasao = model.getPeriodoDeEvasao();
        dto.motivoDeEvasao = model.getMotivoDeEvasao();
        dto.periodoDeIngresso = model.getPeriodoDeIngresso();
        return dto;
    }

    public static StudentDTO fromSigModel(StudentSigModel model) {
        StudentDTO dto = new StudentDTO();
        dto.matricula = model.getMatriculaDoEstudante();
        dto.sexo = (model.getSexo().equalsIgnoreCase("M") ? "MASCULINO" : "FEMININO");
        dto.cor = model.getCor();
        dto.deficiencias = model.getDeficienciasAsList();
        dto.politicaAfirmativa = model.getPoliticaAfirmativa();
        dto.creditosDoCra = model.getCreditosDoCra();
        dto.notasAcumuladas = model.getNotasAcumuladas();
        dto.cra = (dto.creditosDoCra > 0 ? round2(dto.notasAcumuladas/ dto.creditosDoCra) : 0);
        dto.periodosCompletados = model.getPeriodosCompletados();
        dto.creditosTentados = model.getCreditosTentados();
        dto.creditosCompletados = model.getCreditosCompletados();
        dto.creditosIsentos = model.getCreditosIsentos();
        dto.creditosFalhados = model.getCreditosFalhados();
        dto.creditosSuspensos = model.getCreditosSuspensos();
        dto.creditosEmAndamento = model.getCreditosEmAndamento();
        dto.velocidadeMedia = model.getVelocidadeMedia();
        dto.taxaDeSucesso = model.getTaxaDeSucesso();
        dto.situacao = (model.getSituacao().equalsIgnoreCase("ativo") ? "ATIVO" : "INATIVO");
        dto.periodoDeEvasao = model.getPeriodoDeEvasao();
        dto.motivoDeEvasao =   (model.getSituacao().equalsIgnoreCase("ativo") ? "REGULAR" :
                                model.getSituacao().equalsIgnoreCase("CONCLUÍDO") ||
                                model.getSituacao().equalsIgnoreCase("FORMADO") ? "GRADUADO" :
                                "EVADIDO");
        dto.periodoDeIngresso = model.getPeriodoDeIngresso();
        return dto;
    }

    public String getMatricula(){
        return matricula;
    }

    public String getMotivoDeEvasao() {
        return motivoDeEvasao;
    }

    public String getSexo() {
        return sexo;
    }

    public String getPeriodoDeEvasao(){
        return periodoDeEvasao;
    }

    public String getPeriodoDeIngresso(){
        return periodoDeIngresso;
    }

    public Integer getPeriodosCompletados(){
        return periodosCompletados;
    }

    public Integer getCreditosTentados() {
        return creditosTentados;
    }

    public Integer getCreditosFalhados() {
        return creditosFalhados;
    }

    public String getSituacao(){return situacao;}

    public Double getVelocidadeMedia(){return velocidadeMedia;}

    public Double getTaxaDeSucesso(){return taxaDeSucesso;}

    public Double getCra(){return cra;}
}
