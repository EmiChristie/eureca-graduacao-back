package br.com.eurecagraduacao.backend.dto.eureca;

import br.com.eurecagraduacao.backend.model.eureca.StudentModel;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OwnProfileDTO {

    @JsonProperty("matricula_do_estudante")
    private String matriculaDoEstudante;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("codigo_do_curso")
    private Integer codigoDoCurso;

    @JsonProperty("codigo_do_curriculo")
    private Integer codigoDoCurriculo;

    @JsonProperty("campus")
    private Integer campus;

    @JsonProperty("codigo_do_setor")
    private Integer codigoDoSetor;

    @JsonProperty("situacao")
    private String situacao;

    @JsonProperty("cra")
    private double cra;

    @JsonProperty("mc")
    private double mc;

    @JsonProperty("iech")
    private double iech;

    @JsonProperty("iepl")
    private double iepl;

    @JsonProperty("iea")
    private double iea;

    @JsonProperty("mcn")
    private double mcn;

    @JsonProperty("iean")
    private double iean;

    @JsonProperty("creditos_do_cra")
    private Integer creditosDoCra;

    @JsonProperty("notas_acumuladas")
    private double notasAcumuladas;

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
    private double velocidadeMedia;

    @JsonProperty("taxa_de_sucesso")
    private double taxaDeSucesso;

    public static OwnProfileDTO fromModel(StudentModel model) {
        OwnProfileDTO dto = new OwnProfileDTO();
        dto.matriculaDoEstudante = model.getMatriculaDoEstudante();
        dto.nome = model.getNome();
        dto.codigoDoCurso = model.getCodigoDoCurso();
        dto.codigoDoCurriculo = model.getCodigoDoCurriculo();
        dto.campus = model.getCampus();
        dto.codigoDoSetor = model.getCodigoDoSetor();
        dto.situacao = model.getSituacao();
        dto.cra = model.getCra();
        dto.mc = model.getMc();
        dto.iech = model.getIech();
        dto.iepl = model.getIepl();
        dto.iea = model.getIea();
        dto.mcn = model.getMcn();
        dto.iean = model.getIean();
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
        return dto;
    }

    public String getMatriculaDoEstudante() { return matriculaDoEstudante; }
    public String getNome() { return nome; }
    public Integer getCodigoDoCurso() { return codigoDoCurso; }
    public Integer getCodigoDoCurriculo() { return codigoDoCurriculo; }
    public Integer getCampus() { return campus; }
    public Integer getCodigoDoSetor() { return codigoDoSetor; }
    public String getSituacao() { return situacao; }
    public double getCra() { return cra; }
    public double getMc() { return mc; }
    public double getIech() { return iech; }
    public double getIepl() { return iepl; }
    public double getIea() { return iea; }
    public double getMcn() { return mcn; }
    public double getIean() { return iean; }
    public Integer getCreditosDoCra() { return creditosDoCra; }
    public double getNotasAcumuladas() { return notasAcumuladas; }
    public Integer getPeriodosCompletados() { return periodosCompletados; }
    public Integer getCreditosTentados() { return creditosTentados; }
    public Integer getCreditosCompletados() { return creditosCompletados; }
    public Integer getCreditosIsentos() { return creditosIsentos; }
    public Integer getCreditosFalhados() { return creditosFalhados; }
    public Integer getCreditosSuspensos() { return creditosSuspensos; }
    public Integer getCreditosEmAndamento() { return creditosEmAndamento; }
    public double getVelocidadeMedia() { return velocidadeMedia; }
    public double getTaxaDeSucesso() { return taxaDeSucesso; }
}
