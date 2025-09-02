package br.com.eurecagraduacao.backend.dto.backend;

public class TaxaSucessoDTO {

    private double taxaDeSucesso;
    private int quantidadeDeGraduados;
    private int quantidadeDeEvadidos;
    private String motivoEvasaoMaisComum;

    public TaxaSucessoDTO(double taxaDeSucesso, int quantidadeDeGraduados, int quantidadeDeEvadidos, String motivoEvasaoMaisComum) {
        this.taxaDeSucesso = taxaDeSucesso;
        this.quantidadeDeGraduados = quantidadeDeGraduados;
        this.quantidadeDeEvadidos = quantidadeDeEvadidos;
        this.motivoEvasaoMaisComum = motivoEvasaoMaisComum;
    }

    public double getTaxaDeSucesso() {
        return taxaDeSucesso;
    }

    public int getQuantidadeDeGraduados() {
        return quantidadeDeGraduados;
    }

    public int getQuantidadeDeEvadidos() {
        return quantidadeDeEvadidos;
    }

    public String getMotivoEvasaoMaisComum() {
        return motivoEvasaoMaisComum;
    }
}
