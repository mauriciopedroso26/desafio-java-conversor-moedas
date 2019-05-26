package br.com.prova.tecnica.cwi.application.impl;

import br.com.prova.tecnica.cwi.application.CurrencyConverterInterface;
import br.com.prova.tecnica.cwi.download.CurrencyConverterDownload;
import br.com.prova.tecnica.cwi.entity.CurrencyConverter;
import br.com.prova.tecnica.cwi.exceptions.ParametersAreNotValidException;
import br.com.prova.tecnica.cwi.exceptions.ValueIsNotValidException;
import br.com.prova.tecnica.cwi.read.CSVRead;
import br.com.prova.tecnica.cwi.service.CurrencyConverterService;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class CurrencyConverterInterfaceImpl implements CurrencyConverterInterface {

    private CurrencyConverterService currencyConverterService;

    public CurrencyConverterInterfaceImpl() {
        this.currencyConverterService = new CurrencyConverterService();
    }

    @Override
    public BigDecimal currencyQuotation(String from, String to, Number value, String quotation) throws ParametersAreNotValidException, IOException, ValueIsNotValidException {

        String quotationDownload = CurrencyConverterDownload.downloadWithJava7IO(quotation);
        List<CurrencyConverter> currencyConverterList = CSVRead.read(quotationDownload);
        currencyConverterService.validParameter(currencyConverterList, from, to);
        currencyConverterService.validValue(value);

        return currencyConverterService.currencyQuotationBusinessRules(currencyConverterList, from, to, value);
    }
}
