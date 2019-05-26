package br.com.prova.tecnica.cwi.application;

import br.com.prova.tecnica.cwi.application.impl.CurrencyConverterInterfaceImpl;
import br.com.prova.tecnica.cwi.exceptions.ParametersAreNotValidException;
import br.com.prova.tecnica.cwi.exceptions.ValueIsNotValidException;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyConverterInterfaceImplTest {

    @Test
    void currencyQuotationToBRLSuccess() throws ValueIsNotValidException, ParametersAreNotValidException, IOException {
        CurrencyConverterInterfaceImpl currencyConverterInterface = new CurrencyConverterInterfaceImpl();
        BigDecimal result = currencyConverterInterface.currencyQuotation("EUR", "BRL", 100, "25/01/2019");

        assertEquals(BigDecimal.valueOf(428.0), result);
    }

    @Test
    void currencyQuotationToUSDSuccess() throws ValueIsNotValidException, ParametersAreNotValidException, IOException {
        CurrencyConverterInterfaceImpl currencyConverterInterface = new CurrencyConverterInterfaceImpl();
        BigDecimal result = currencyConverterInterface.currencyQuotation("EUR", "USD", 100, "25/01/2019");

        assertEquals(BigDecimal.valueOf(113.79), result);
    }

    @Test
    void currencyQuotationToAnyCurrencySuccess() throws ValueIsNotValidException, ParametersAreNotValidException, IOException {
        CurrencyConverterInterfaceImpl currencyConverterInterface = new CurrencyConverterInterfaceImpl();
        BigDecimal result = currencyConverterInterface.currencyQuotation("EUR", "AFN", 100, "25/01/2019");

        assertEquals(BigDecimal.valueOf(8565.14), result);
    }

    @Test
    void takesTheQuotationFromTheImmediatelyPrecedingBusinessDay() throws ValueIsNotValidException, ParametersAreNotValidException, IOException {
        CurrencyConverterInterfaceImpl currencyConverterInterface = new CurrencyConverterInterfaceImpl();
        BigDecimal result = currencyConverterInterface.currencyQuotation("EUR", "AFN", 100, "26/01/2019");

        assertEquals(BigDecimal.valueOf(8565.14), result);
    }

    @Test()
    void takesTheQuotationFromTheImmediatelyPrecedingBusinessDayFileNotFound() {
        CurrencyConverterInterfaceImpl currencyConverterInterface = new CurrencyConverterInterfaceImpl();

        assertThrows(FileNotFoundException.class, () -> {
            currencyConverterInterface.currencyQuotation("EUR", "AFN", Double.NEGATIVE_INFINITY, "27/01/2019");
        });
    }

    @Test()
    void currencyQuotationFromInvalid() {
        CurrencyConverterInterfaceImpl currencyConverterInterface = new CurrencyConverterInterfaceImpl();

        assertThrows(ParametersAreNotValidException.class, () -> {
            currencyConverterInterface.currencyQuotation("EUR", "AFNN", 100, "25/01/2019");
        });
    }

    @Test()
    void currencyQuotationToInvalid() {
        CurrencyConverterInterfaceImpl currencyConverterInterface = new CurrencyConverterInterfaceImpl();

        assertThrows(ParametersAreNotValidException.class, () -> {
            currencyConverterInterface.currencyQuotation("EURO", "AFN", 100, "25/01/2019");
        });
    }

    @Test()
    void currencyQuotationValueSmallerThanZero() {
        CurrencyConverterInterfaceImpl currencyConverterInterface = new CurrencyConverterInterfaceImpl();

        assertThrows(ValueIsNotValidException.class, () -> {
            currencyConverterInterface.currencyQuotation("EUR", "AFN", Double.NEGATIVE_INFINITY, "25/01/2019");
        });
    }
}