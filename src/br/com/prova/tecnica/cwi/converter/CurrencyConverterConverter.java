package br.com.prova.tecnica.cwi.converter;

import br.com.prova.tecnica.cwi.entity.CurrencyConverter;

public class CurrencyConverterConverter {

    public CurrencyConverter currencyConverte(String[] priceList) {
        return new CurrencyConverter(priceList[0], priceList[1], priceList[2], priceList[3], priceList[4],
                priceList[5], priceList[6], priceList[7]);
    }
}
