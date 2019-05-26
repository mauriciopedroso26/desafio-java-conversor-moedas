package br.com.prova.tecnica.cwi.entity;

public class CurrencyConverter {

    private String priceDate;
    private String codMoeda;
    private String tipo;
    private String moeda;
    private String taxaCompra;
    private String taxaVenda;
    private String paridadeCompra;
    private String paridadeVenda;

    public CurrencyConverter() {
    }

    public CurrencyConverter(String priceDate, String codMoeda, String tipo, String moeda, String taxaCompra,
                             String taxaVenda, String paridadeCompra, String paridadeVenda) {
        this.priceDate = priceDate;
        this.codMoeda = codMoeda;
        this.tipo = tipo;
        this.moeda = moeda;
        this.taxaCompra = taxaCompra;
        this.taxaVenda = taxaVenda;
        this.paridadeCompra = paridadeCompra;
        this.paridadeVenda = paridadeVenda;
    }

    public String getPriceDate() {
        return priceDate;
    }

    public String getCodMoeda() {
        return codMoeda;
    }

    public String getTipo() {
        return tipo;
    }

    public String getMoeda() {
        return moeda;
    }

    public String getTaxaCompra() {
        return taxaCompra;
    }

    public String getTaxaVenda() {
        return taxaVenda;
    }

    public String getParidadeCompra() {
        return paridadeCompra;
    }

    public String getParidadeVenda() {
        return paridadeVenda;
    }
}
