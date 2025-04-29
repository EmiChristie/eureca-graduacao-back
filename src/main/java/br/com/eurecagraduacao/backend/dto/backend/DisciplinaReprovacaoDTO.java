package br.com.eurecagraduacao.backend.dto.backend;

public class DisciplinaReprovacaoDTO {

    private Integer codigo;
    private String nome;
    private Integer numeroDeReprovacoes;

    public DisciplinaReprovacaoDTO(Integer codigo, String nome, Integer numeroDeReprovacoes) {
        this.codigo = codigo;
        this.nome = nome;
        this.numeroDeReprovacoes = numeroDeReprovacoes;
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
}
