package br.com.eurecagraduacao.backend.dto.backend;

import java.math.BigDecimal;

public class DisciplinaReprovacaoDTO {

    private Integer codigo;
    private String nome;
    private int numeroDeReprovacoes;
    private BigDecimal porcentagemDeReprovacoes;

    public DisciplinaReprovacaoDTO(Integer codigo, String nome, int numeroDeReprovacoes, BigDecimal porcentagemDeReprovacoes) {
        this.codigo = codigo;
        this.nome = nome;
        this.numeroDeReprovacoes = numeroDeReprovacoes;
        this.porcentagemDeReprovacoes = porcentagemDeReprovacoes;
    }

    public BigDecimal getPorcentagemDeReprovacoes() {
        return porcentagemDeReprovacoes;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public Integer getNumeroDeReprovacoes() {
        return numeroDeReprovacoes;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNumeroDeReprovacoes(Integer numeroDeReprovacoes) {
        this.numeroDeReprovacoes = numeroDeReprovacoes;
    }

    public void setPorcentagemDeReprovacoes(BigDecimal porcentagemDeReprovacoes) {
        this.porcentagemDeReprovacoes = porcentagemDeReprovacoes;
    }
}
