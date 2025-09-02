package br.com.eurecagraduacao.backend.model.eureca;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class StudentMetricsModel {

    @JsonProperty("matricula_do_estudante")
    private String matriculaDoEstudante;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("codigo_do_curso")
    private Integer codigoDoCurso;

    @JsonProperty("nome_do_curso")
    private String nomeDoCurso;

    @JsonProperty("turno_do_curso")
    private String turnoDoCurso;

    @JsonProperty("codigo_do_curriculo")
    private Integer codigoDoCurriculo;

    @JsonProperty("campus")
    private Integer campus;

    @JsonProperty("nome_do_campus")
    private String nomeDoCampus;

    @JsonProperty("codigo_do_setor")
    private Integer codigoDoSetor;

    @JsonProperty("nome_do_setor")
    private String nomeDoSetor;

    @JsonProperty("estado_civil")
    private String estadoCivil;

    @JsonProperty("endereco")
    private String endereco;

    @JsonProperty("sexo")
    private String sexo;

    @JsonProperty("data_de_nascimento")
    private String dataDeNascimento;

    @JsonProperty("cpf")
    private String cpf;

    @JsonProperty("cep")
    private String cep;

    @JsonProperty("telefone")
    private String telefone;

    @JsonProperty("situacao")
    private String situacao;

    @JsonProperty("motivo_de_evasao")
    private String motivoDeEvasao;

    @JsonProperty("periodo_de_evasao")
    private String periodoDeEvasao;

    @JsonProperty("forma_de_ingresso")
    private String formaDeIngresso;

    @JsonProperty("periodo_de_ingresso")
    private String periodoDeIngresso;

    @JsonProperty("email")
    private String email;

    @JsonProperty("nacionalidade")
    private String nacionalidade;

    @JsonProperty("local_de_nascimento")
    private String localDeNascimento;

    @JsonProperty("naturalidade")
    private String naturalidade;

    @JsonProperty("cor")
    private String cor;

    @JsonProperty("deficiencias")
    private List<String> deficiencias;

    @JsonProperty("ano_de_conclusao_ensino_medio")
    private Integer anoDeConclusaoEnsinoMedio;

    @JsonProperty("tipo_de_ensino_medio")
    private String tipoDeEnsinoMedio;

    @JsonProperty("politica_afirmativa")
    private String politicaAfirmativa;

    @JsonProperty("creditos_do_cra")
    private Integer creditosDoCra;

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

    @JsonProperty("prac_renda_per_capita_ate")
    private double pracRendaPerCapitaAte;

    @JsonProperty("historico_de_metricas")
    private List<MetricsHistoryModel> historicoDeMetricas;

    @JsonProperty("prac_atualizado")
    private String pracAtualizado;

    @JsonProperty("prac_atualizado_em")
    private String pracAtualizadoEm;

    @JsonProperty("prac_cor")
    private String pracCor;

    @JsonProperty("prac_quilombola")
    private String pracQuilombola;

    @JsonProperty("prac_indigena_aldeado")
    private String pracIndigenaAldeado;

    @JsonProperty("prac_deficiente")
    private String pracDeficiente;

    @JsonProperty("prac_deficiencias")
    private List<String> pracDeficiencias;

    @JsonProperty("prac_deslocou_mudou")
    private String pracDeslocouMudou;

    @JsonProperty("ufpb")
    private Integer ufpb;

    // Getters

    public String getMatriculaDoEstudante() {
        return matriculaDoEstudante;
    }

    public String getNome() {
        return nome;
    }

    public Integer getCodigoDoCurso() {
        return codigoDoCurso;
    }

    public String getNomeDoCurso() {
        return nomeDoCurso;
    }

    public String getTurnoDoCurso() {
        return turnoDoCurso;
    }

    public Integer getCodigoDoCurriculo() {
        return codigoDoCurriculo;
    }

    public Integer getCampus() {
        return campus;
    }

    public String getNomeDoCampus() {
        return nomeDoCampus;
    }

    public Integer getCodigoDoSetor() {
        return codigoDoSetor;
    }

    public String getNomeDoSetor() {
        return nomeDoSetor;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getSexo() {
        return sexo;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public String getCep() {
        return cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getSituacao() {
        return situacao;
    }

    public String getMotivoDeEvasao() {
        return motivoDeEvasao;
    }

    public String getPeriodoDeEvasao() {
        return periodoDeEvasao;
    }

    public String getFormaDeIngresso() {
        return formaDeIngresso;
    }

    public String getPeriodoDeIngresso() {
        return periodoDeIngresso;
    }

    public String getEmail() {
        return email;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public String getLocalDeNascimento() {
        return localDeNascimento;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public String getCor() {
        return cor;
    }

    public List<String> getDeficiencias() {
        return deficiencias;
    }

    public Integer getAnoDeConclusaoEnsinoMedio() {
        return anoDeConclusaoEnsinoMedio;
    }

    public String getTipoDeEnsinoMedio() {
        return tipoDeEnsinoMedio;
    }

    public String getPoliticaAfirmativa() {
        return politicaAfirmativa;
    }

    public Integer getCreditosDoCra() {
        return creditosDoCra;
    }

    public double getCra() {
        return cra;
    }

    public double getMc() {
        return mc;
    }

    public double getIech() {
        return iech;
    }

    public double getIepl() {
        return iepl;
    }

    public double getIea() {
        return iea;
    }

    public double getMcn() {
        return mcn;
    }

    public double getIean() {
        return iean;
    }

    public double getNotasAcumuladas() {
        return notasAcumuladas;
    }

    public Integer getPeriodosCompletados() {
        return periodosCompletados;
    }

    public Integer getCreditosTentados() {
        return creditosTentados;
    }

    public Integer getCreditosCompletados() {
        return creditosCompletados;
    }

    public Integer getCreditosIsentos() {
        return creditosIsentos;
    }

    public Integer getCreditosFalhados() {
        return creditosFalhados;
    }

    public Integer getCreditosSuspensos() {
        return creditosSuspensos;
    }

    public Integer getCreditosEmAndamento() {
        return creditosEmAndamento;
    }

    public double getVelocidadeMedia() {
        return velocidadeMedia;
    }

    public double getTaxaDeSucesso() {
        return taxaDeSucesso;
    }

    public double getPracRendaPerCapitaAte() {
        return pracRendaPerCapitaAte;
    }

    public List<MetricsHistoryModel> getHistoricoDeMetricas() {
        return historicoDeMetricas;
    }

    public String getPracAtualizado() {
        return pracAtualizado;
    }

    public String getPracAtualizadoEm() {
        return pracAtualizadoEm;
    }

    public String getPracCor() {
        return pracCor;
    }

    public String getPracQuilombola() {
        return pracQuilombola;
    }

    public String getPracIndigenaAldeado() {
        return pracIndigenaAldeado;
    }

    public String getPracDeficiente() {
        return pracDeficiente;
    }

    public List<String> getPracDeficiencias() {
        return pracDeficiencias;
    }

    public String getPracDeslocouMudou() {
        return pracDeslocouMudou;
    }

    public Integer getUfpb() {
        return ufpb;
    }

}
