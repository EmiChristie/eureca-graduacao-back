package br.com.eurecagraduacao.backend.dto.backend;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class DisciplinaReprovacaoDTO {

    @JsonProperty("codigo_da_disciplina")
    private Integer codigo;

    @JsonProperty("nome_da_disciplina")
    private String nome;

    @JsonProperty("total_de_matriculas")
    private int totalDeMatriculas;

    @JsonProperty("total_de_reprovacoes")
    private int numeroDeReprovacoes;

    @JsonProperty("porcentagem_de_reprovacoes")
    private BigDecimal porcentagemDeReprovacoes;

    public DisciplinaReprovacaoDTO(Integer codigo, String nome, int numeroDeReprovacoes, int totalDeMatriculas, BigDecimal porcentagemDeReprovacoes) {
        this.codigo = codigo;
        this.nome = nome;
        this.numeroDeReprovacoes = numeroDeReprovacoes;
        this.totalDeMatriculas = totalDeMatriculas;
        this.porcentagemDeReprovacoes = porcentagemDeReprovacoes;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getNumeroDeReprovacoes() {
        return numeroDeReprovacoes;
    }

    public int getTotalDeMatriculas() {
        return totalDeMatriculas;
    }

    public BigDecimal getPorcentagemDeReprovacoes() {
        return porcentagemDeReprovacoes;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNumeroDeReprovacoes(int numeroDeReprovacoes) {
        this.numeroDeReprovacoes = numeroDeReprovacoes;
    }

    public void setTotalDeMatriculas(int totalDeMatriculas) {
        this.totalDeMatriculas = totalDeMatriculas;
    }

    public void setPorcentagemDeReprovacoes(BigDecimal porcentagemDeReprovacoes) {
        this.porcentagemDeReprovacoes = porcentagemDeReprovacoes;
    }
}
