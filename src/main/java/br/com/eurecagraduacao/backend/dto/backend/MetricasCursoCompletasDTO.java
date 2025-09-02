package br.com.eurecagraduacao.backend.dto.backend;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MetricasCursoCompletasDTO {

    @JsonProperty("codigo_do_curso")
    private Integer codigoDoCurso;

    @JsonProperty("taxa_de_sucesso")
    private double taxaDeSucesso;

    @JsonProperty("quantidade_de_graduados")
    private Integer quantidadeDeGraduados;

    @JsonProperty("quantidade_de_evadidos")
    private Integer quantidadeDeEvadidos;

    @JsonProperty("quantidade_mulheres_graduadas")
    private Integer quantidadeMulheresGraduadas;

    @JsonProperty("porcentagem_mulheres_graduadas")
    private double pctMulheresGraduadas;

    @JsonProperty("motivo_de_evasao_mais_comum")
    private List<MotivoDeEvasaoDTO> motivoDeEvasaoMaisComum;

    @JsonProperty("quantidade_real_periodos")
    private List<QuantidadeRealPeriodosDTO> quantidadeRealPeriodos;

    @JsonProperty("graduados_e_evadidos_por_periodo")
    private List<GraduadosEEvadidosPorPeriodoDTO> graduadosEevadidosPorPeriodo;

    @JsonProperty("qtd_media_graduados_por_periodo")
    private Integer qtdMediaGraduadosPorPeriodo;

    @JsonProperty("qtd_media_evadidos_por_periodo")
    private Integer qtdMediaEvadidosPorPeriodo;

    @JsonProperty("periodo_mais_comum_de_evadir")
    private Integer periodoMaisComumDeEvadir;

    @JsonProperty("qtd_media_creditos_reprovados")
    private double qtdMediaCreditosReprovados;

    /*
    @JsonProperty("quantidade_real_creditos")
    private QuantidadeRealCreditosDTO quantidadeRealCreditos;

    @JsonProperty("media_de_metricas")
    private MediaDeMetricasDTO mediaDeMetricas;

    @JsonProperty("maior_cra_ativo")
    private double maiorCraAtivo;

    @JsonProperty("menor_cra_ativo")
    private double menorCraAtivo;

    @JsonProperty("porcentagem_graduados_que_se_formam_com_o_minimo_de_creditos")
    private double porcentagemGraduadosMinCreditos;

    @JsonProperty("porcentagem_graduados_que_se_formam_com_o_minimo_de_periodos")
    private double porcentagemGraduadosMinPeriodos;

    @JsonProperty("porcentagem_graduados_que_ultrapassaram_o_max_periodos")
    private double porcentagemGraduadosMaxPeriodos;

    @JsonProperty("velocidade_media_curso")
    private double velocidadeMediaCurso;

    @JsonProperty("qtd_media_ingressantes_por_periodo")
    private Integer qtdMediaIngressantesPorPeriodo;

    @JsonProperty("quantidade_de_ativos")
    private Integer quantidadeDeAtivos;

    */

    public MetricasCursoCompletasDTO(Integer codigoDoCurso, double taxaDeSucesso, int size, int size1, int qtdMulheresGraduadas, double pctMulheresGraduadas, List<MotivoDeEvasaoDTO> motivosDeEvasaoMaisComuns, List<QuantidadeRealPeriodosDTO> quantidadeRealPeriodos, List<GraduadosEEvadidosPorPeriodoDTO> graduadosEEvadidosPorPeriodo, int qtdMediaGraduadosPeriodo, int qtdMediaEvadidosPeriodo, int periodoMaisComumDeEvadir, int qtdMediaCreditosReprovados) {
        this.codigoDoCurso = codigoDoCurso;
        this.taxaDeSucesso = taxaDeSucesso;
        this.quantidadeDeGraduados = size;
        this.quantidadeDeEvadidos = size1;
        this.quantidadeMulheresGraduadas = qtdMulheresGraduadas;
        this.pctMulheresGraduadas = pctMulheresGraduadas;
        this.motivoDeEvasaoMaisComum = motivosDeEvasaoMaisComuns;
        this.quantidadeRealPeriodos = quantidadeRealPeriodos;
        this.graduadosEevadidosPorPeriodo = graduadosEEvadidosPorPeriodo;
        this.qtdMediaGraduadosPorPeriodo = qtdMediaGraduadosPeriodo;
        this.qtdMediaEvadidosPorPeriodo = qtdMediaEvadidosPeriodo;
        this.periodoMaisComumDeEvadir = periodoMaisComumDeEvadir;
        this.qtdMediaCreditosReprovados = qtdMediaCreditosReprovados;
    }
}

/*
{
	"codigo_do_curso": 0,
	"taxa_de_sucesso": 0.0,
	"quantidade_de_graduados": 0,
	"quantidade_de_evadidos": 0,
	"quantidade_mulheres_graduadas": 0,
	"porcentagem_mulheres_graduadas": 0.0,
	"motivo_de_evasao_mais_comum": [
		{
			"motivo": "string",
			"porcentagem_evadidos": 0.0,
		},
	],

//metrica que depende mais ou menos do currículo ativo que estou observando:

	"quantidade_real_periodos": [
		{
			"quantidade_de_periodos": 0,
			"quantidade_de_graduados": 0,
			"porcentagem_de_graduados": 0.0,
		},
	],
	"graduados_e_evadidos_por_periodo": [
		{
			"quantidade_graduados_periodo": 0,
			"quantidade_evadidos_periodo": 0,
			"taxa_de_sucesso_periodo": 0.0,
			"periodo": "string",
		},
	],
	"qtd_media_graduados_por_periodo": 0,
	"qtd_media_evadidos_por_periodo": 0,
	"periodo_mais_comum_de_evadir": 0,
	"qtd_media_creditos_reprovados": 0,

//fiz ate aqui -----------------------------------------------------------------------------------------------------------


//metricas que exclusivamente dependem do currículo que estou observando:

	"quantidade_real_creditos": {
		"quantidade_media_creditos": 0,
		"quantidade_a_mais_que_o_minimo": 0,
		"porcentagem_a_mais_que_o_minimo": 0.0,
	},
	"porcentagem_graduados_que_se_formam_com_o_minimo_de_creditos": 0.0,
	"porcentagem_graduados_que_se_formam_com_o_minimo_de_periodos": 0.0,
	"porcentagem_graduados_que_ultrapassaram_o_max_periodos": 0.0,

//metricas que usam os alunos ativos ou outros grupos fora dos graduados/evadidos dos últimos 5 anos (objeto que eu já usava pra calcular as métricas anteriores):

	"media_de_metricas": {
    		"cra": 0,
    		"mc": 0,
    		"iech": 0,
   		"iepl": 0,
    		"iea": 0,
    		"mcn": 0,
    		"iean": 0,
	},
	"maior_cra_ativo": 0.0,
	"menor_cra_ativo": 0.0,
	"qtd_media_ingressantes_por_periodo": 0,
	"quantidade_de_ativos": 0,
	"velocidade_media_curso": 0,
}
* */