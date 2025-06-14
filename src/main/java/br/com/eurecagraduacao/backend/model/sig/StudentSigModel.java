package br.com.eurecagraduacao.backend.model.sig;

import com.fasterxml.jackson.annotation.JsonProperty;

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
    private Integer velocidadeMedia;

    @JsonProperty("taxa_de_sucesso")
    private Double taxaDeSucesso;

    public String getMatriculaDoEstudante() {
        return matriculaDoEstudante;
    }

    public String getPeriodoDeIngresso() {
        return periodoDeIngresso;
    }
}
