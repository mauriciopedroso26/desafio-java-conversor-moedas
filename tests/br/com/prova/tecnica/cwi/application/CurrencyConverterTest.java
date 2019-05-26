package br.com.prova.tecnica.cwi.application;

import br.com.prova.tecnica.cwi.download.CurrencyConverterDownload;
import br.com.prova.tecnica.cwi.entity.CurrencyConverter;
import br.com.prova.tecnica.cwi.read.CSVRead;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CurrencyConverterTest {

    @Test()
    void currencyQuotationValidGetEntity() throws IOException {
        String quotationDownload = CurrencyConverterDownload.downloadWithJava7IO("25/01/2019");
        List<CurrencyConverter> currencyConverterList = CSVRead.read(quotationDownload);

        assertEquals("25/01/2019", currencyConverterList.get(0).getPriceDate());
        assertEquals("005", currencyConverterList.get(0).getCodMoeda());
        assertEquals("76,50000000", currencyConverterList.get(0).getParidadeVenda());
    }
}
