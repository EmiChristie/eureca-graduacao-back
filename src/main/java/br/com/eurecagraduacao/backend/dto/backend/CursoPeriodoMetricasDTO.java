package br.com.eurecagraduacao.backend.dto.backend;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CursoPeriodoMetricasDTO {

    @JsonProperty("periodo")
    private String periodo;

    @JsonProperty("total_alunos")
    private int total;

    @JsonProperty("mulheres_ingressantes")
    private int mulheresIngressantes;

    @JsonProperty("mulheres_graduadas")
    private int mulheresGraduadas;

    @JsonProperty("homens_ingressantes")
    private int homensIngressantes;

    @JsonProperty("homens_graduados")
    private int homensGraduados;

    @JsonProperty("graduados")
    private int graduados;

    @JsonProperty("evadidos")
    private int evadidos;

    @JsonProperty("ativos")
    private int ativos;

    @JsonProperty("taxa_de_sucesso")
    private double taxaDeSucesso;

    @JsonProperty("porcentagem_ativos")
    private double porcentagemAtivos;

    @JsonProperty("porcentagem_mulheres_graduadas_em_relacao_aos_graduados")
    private double porcentagemMulheresGraduadas;

    @JsonProperty("porcentagem_mulheres_graduadas_em_relacao_ao_total")
    private double porcentagemMulheresGraduadasTotal;

    @JsonProperty("porcentagem_mulheres_graduadas_em_relacao_as_mulheres_ingressantes")
    private double porcentagemMulheresGraduadasMulheres;

    @JsonProperty("porcentagem_homens_graduados_em_relacao_aos_graduados")
    private double porcentagemHomensGraduados;

    @JsonProperty("porcentagem_homens_graduados_em_relacao_ao_total")
    private double porcentagemHomensGraduadosTotal;

    @JsonProperty("porcentagem_homens_graduados_em_relacao_aos_homens_ingressantes")
    private double porcentagemHomensGraduadosHomens;

    public CursoPeriodoMetricasDTO(String periodo, int ativos, int graduados, int evadidos, int mulheresIngressantes, int mulheresGraduadas, int totalIngressantes) {
        this.periodo = periodo;
        this.ativos = ativos;
        this.graduados = graduados;
        this.mulheresIngressantes = mulheresIngressantes;
        this.mulheresGraduadas = mulheresGraduadas;
        this.evadidos = evadidos;

        int total = ativos + graduados + evadidos;
        int homensIngressantes = total - mulheresIngressantes;
        this.homensIngressantes = homensIngressantes;
        this.homensGraduados = graduados - mulheresGraduadas;

        this.total = total;

        this.taxaDeSucesso = total > 0
                ? BigDecimal.valueOf((graduados * 100.0) / total).setScale(2, RoundingMode.HALF_UP).doubleValue()
                : 0.0;

        this.porcentagemAtivos = total > 0
                ? BigDecimal.valueOf((ativos * 100.0) / total).setScale(2, RoundingMode.HALF_UP).doubleValue()
                : 0.0;

        this.porcentagemMulheresGraduadas = graduados > 0
                ? BigDecimal.valueOf((mulheresGraduadas * 100.0) / graduados).setScale(2, RoundingMode.HALF_UP).doubleValue()
                : 0.0;

        this.porcentagemMulheresGraduadasTotal = totalIngressantes > 0
                ? BigDecimal.valueOf((mulheresGraduadas * 100.0) / totalIngressantes).setScale(2, RoundingMode.HALF_UP).doubleValue()
                : 0.0;

        this.porcentagemMulheresGraduadasMulheres = mulheresIngressantes > 0
                ? BigDecimal.valueOf((mulheresGraduadas * 100.0) / mulheresIngressantes).setScale(2, RoundingMode.HALF_UP).doubleValue()
                : 0.0;


        this.porcentagemHomensGraduados = graduados > 0
                ? BigDecimal.valueOf((homensGraduados * 100.0) / graduados).setScale(2, RoundingMode.HALF_UP).doubleValue()
                : 0.0;

        this.porcentagemHomensGraduadosTotal = totalIngressantes > 0
                ? BigDecimal.valueOf((homensGraduados * 100.0) / totalIngressantes).setScale(2, RoundingMode.HALF_UP).doubleValue()
                : 0.0;

        this.porcentagemHomensGraduadosHomens = homensIngressantes > 0
                ? BigDecimal.valueOf((homensGraduados * 100.0) / homensIngressantes).setScale(2, RoundingMode.HALF_UP).doubleValue()
                : 0.0;
    }


    public String getPeriodo() {
        return periodo;
    }

    public int getAtivos() {
        return ativos;
    }

    public int getGraduados() {
        return graduados;
    }

    public int getEvadidos() {
        return evadidos;
    }

    public double getTaxaDeSucesso() {
        return taxaDeSucesso;
    }

    public double getPorcentagemAtivos() {
        return porcentagemAtivos;
    }
}
