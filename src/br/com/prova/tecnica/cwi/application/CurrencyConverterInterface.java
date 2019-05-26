package br.com.prova.tecnica.cwi.application;

import br.com.prova.tecnica.cwi.exceptions.ParametersAreNotValidException;
import br.com.prova.tecnica.cwi.exceptions.ValueIsNotValidException;

import java.io.IOException;
import java.math.BigDecimal;

public interface CurrencyConverterInterface {

    BigDecimal currencyQuotation(String from, String to, Number value, String quotation) throws ParametersAreNotValidException, IOException, ValueIsNotValidException;
}
