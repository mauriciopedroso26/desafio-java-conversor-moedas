package br.com.prova.tecnica.cwi;

import br.com.prova.tecnica.cwi.application.impl.CurrencyConverterInterfaceImpl;
import br.com.prova.tecnica.cwi.exceptions.ParametersAreNotValidException;
import br.com.prova.tecnica.cwi.exceptions.ValueIsNotValidException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ParametersAreNotValidException, IOException, ValueIsNotValidException {
        CurrencyConverterInterfaceImpl currencyConverterInterface = new CurrencyConverterInterfaceImpl();
        System.out.println(currencyConverterInterface.currencyQuotation("BRL", "EUR", 1000, "26/01/2019"));
    }
}
