package br.com.eurecagraduacao.backend.model.sig;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class StudentSigModel {

    @JsonProperty("matricula_do_estudante")
    private String matriculaDoEstudante;

    @JsonProperty("codigo_do_curso")
    private Integer codigoDoCurso;

    @JsonProperty("nome_do_curso")
    private String nomeDoCurso;

    @JsonProperty("turno_do_curso")
    private String turnoDoCurso;

    @JsonProperty("codigo_do_curriculo")
    private String codigoDoCurriculo;

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

    @JsonProperty("sexo")
    private String sexo;

    @JsonProperty("idade")
    private String idade;

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

    @JsonProperty("nacionalidade")
    private String nacionalidade;

    @JsonProperty("local_de_nascimento")
    private String localDeNascimento;

    @JsonProperty("naturalidade")
    private String naturalidade;

    @JsonProperty("cor")
    private String cor;

    @JsonProperty("deficiencias")
    private String deficiencias;

    @JsonProperty("ano_de_conclusao_ensino_medio")
    private String anoDeConclusaoEnsinoMedio;

    @JsonProperty("tipo_de_ensino_medio")
    private String tipoDeEnsinoMedio;

    @JsonProperty("politica_afirmativa")
    private String politicaAfirmativa;

    @JsonProperty("renda_per_capita")
    private Integer rendaPerCapita;

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

    public String getMatriculaDoEstudante() {
        return matriculaDoEstudante;
    }

    public void setMatriculaDoEstudante(String matriculaDoEstudante) {
        this.matriculaDoEstudante = matriculaDoEstudante;
    }

    public Integer getCodigoDoCurso() {
        return codigoDoCurso;
    }

    public void setCodigoDoCurso(Integer codigoDoCurso) {
        this.codigoDoCurso = codigoDoCurso;
    }

    public String getNomeDoCurso() {
        return nomeDoCurso;
    }

    public void setNomeDoCurso(String nomeDoCurso) {
        this.nomeDoCurso = nomeDoCurso;
    }

    public String getTurnoDoCurso() {
        return turnoDoCurso;
    }

    public void setTurnoDoCurso(String turnoDoCurso) {
        this.turnoDoCurso = turnoDoCurso;
    }

    public String getCodigoDoCurriculo() {
        return codigoDoCurriculo;
    }

    public void setCodigoDoCurriculo(String codigoDoCurriculo) {
        this.codigoDoCurriculo = codigoDoCurriculo;
    }

    public Integer getCampus() {
        return campus;
    }

    public void setCampus(Integer campus) {
        this.campus = campus;
    }

    public String getNomeDoCampus() {
        return nomeDoCampus;
    }

    public void setNomeDoCampus(String nomeDoCampus) {
        this.nomeDoCampus = nomeDoCampus;
    }

    public Integer getCodigoDoSetor() {
        return codigoDoSetor;
    }

    public void setCodigoDoSetor(Integer codigoDoSetor) {
        this.codigoDoSetor = codigoDoSetor;
    }

    public String getNomeDoSetor() {
        return nomeDoSetor;
    }

    public void setNomeDoSetor(String nomeDoSetor) {
        this.nomeDoSetor = nomeDoSetor;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getMotivoDeEvasao() {
        return motivoDeEvasao;
    }

    public void setMotivoDeEvasao(String motivoDeEvasao) {
        this.motivoDeEvasao = motivoDeEvasao;
    }

    public String getPeriodoDeEvasao() {
        return periodoDeEvasao;
    }

    public void setPeriodoDeEvasao(String periodoDeEvasao) {
        this.periodoDeEvasao = periodoDeEvasao;
    }

    public String getFormaDeIngresso() {
        return formaDeIngresso;
    }

    public void setFormaDeIngresso(String formaDeIngresso) {
        this.formaDeIngresso = formaDeIngresso;
    }

    public String getPeriodoDeIngresso() {
        return periodoDeIngresso;
    }

    public void setPeriodoDeIngresso(String periodoDeIngresso) {
        this.periodoDeIngresso = periodoDeIngresso;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getLocalDeNascimento() {
        return localDeNascimento;
    }

    public void setLocalDeNascimento(String localDeNascimento) {
        this.localDeNascimento = localDeNascimento;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getDeficiencias() {
        return deficiencias;
    }

    public List<String> getDeficienciasAsList() {
        return deficiencias != null ? List.of(deficiencias) : List.of();
    }

    public void setDeficiencias(String deficiencias) {
        this.deficiencias = deficiencias;
    }

    public String getAnoDeConclusaoEnsinoMedio() {
        return anoDeConclusaoEnsinoMedio;
    }

    public void setAnoDeConclusaoEnsinoMedio(String anoDeConclusaoEnsinoMedio) {
        this.anoDeConclusaoEnsinoMedio = anoDeConclusaoEnsinoMedio;
    }

    public String getTipoDeEnsinoMedio() {
        return tipoDeEnsinoMedio;
    }

    public void setTipoDeEnsinoMedio(String tipoDeEnsinoMedio) {
        this.tipoDeEnsinoMedio = tipoDeEnsinoMedio;
    }

    public String getPoliticaAfirmativa() {
        return politicaAfirmativa;
    }

    public void setPoliticaAfirmativa(String politicaAfirmativa) {
        this.politicaAfirmativa = politicaAfirmativa;
    }

    public Integer getRendaPerCapita() {
        return rendaPerCapita;
    }

    public void setRendaPerCapita(Integer rendaPerCapita) {
        this.rendaPerCapita = rendaPerCapita;
    }

    public Integer getCreditosDoCra() {
        return creditosDoCra;
    }

    public void setCreditosDoCra(Integer creditosDoCra) {
        this.creditosDoCra = creditosDoCra;
    }

    public Double getNotasAcumuladas() {
        return notasAcumuladas;
    }

    public void setNotasAcumuladas(Double notasAcumuladas) {
        this.notasAcumuladas = notasAcumuladas;
    }

    public Integer getPeriodosCompletados() {
        return periodosCompletados;
    }

    public void setPeriodosCompletados(Integer periodosCompletados) {
        this.periodosCompletados = periodosCompletados;
    }

    public Integer getCreditosTentados() {
        return creditosTentados;
    }

    public void setCreditosTentados(Integer creditosTentados) {
        this.creditosTentados = creditosTentados;
    }

    public Integer getCreditosCompletados() {
        return creditosCompletados;
    }

    public void setCreditosCompletados(Integer creditosCompletados) {
        this.creditosCompletados = creditosCompletados;
    }

    public Integer getCreditosIsentos() {
        return creditosIsentos;
    }

    public void setCreditosIsentos(Integer creditosIsentos) {
        this.creditosIsentos = creditosIsentos;
    }

    public Integer getCreditosFalhados() {
        return creditosFalhados;
    }

    public void setCreditosFalhados(Integer creditosFalhados) {
        this.creditosFalhados = creditosFalhados;
    }

    public Integer getCreditosSuspensos() {
        return creditosSuspensos;
    }

    public void setCreditosSuspensos(Integer creditosSuspensos) {
        this.creditosSuspensos = creditosSuspensos;
    }

    public Integer getCreditosEmAndamento() {
        return creditosEmAndamento;
    }

    public void setCreditosEmAndamento(Integer creditosEmAndamento) {
        this.creditosEmAndamento = creditosEmAndamento;
    }

    public Double getVelocidadeMedia() {
        return velocidadeMedia;
    }

    public void setVelocidadeMedia(Double velocidadeMedia) {
        this.velocidadeMedia = velocidadeMedia;
    }

    public Double getTaxaDeSucesso() {
        return taxaDeSucesso;
    }

    public void setTaxaDeSucesso(Double taxaDeSucesso) {
        this.taxaDeSucesso = taxaDeSucesso;
    }
}
