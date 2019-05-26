package br.com.prova.tecnica.cwi.read;

import br.com.prova.tecnica.cwi.converter.CurrencyConverterConverter;
import br.com.prova.tecnica.cwi.entity.CurrencyConverter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVRead {

    public static List<CurrencyConverter> read(String quotation) {

        List<CurrencyConverter> currentConverterList = new ArrayList<>();
        String tmp = System.getProperty("java.io.tmpdir");
        String arquivoCSV = tmp + "/" + quotation + ".csv";
        BufferedReader br = null;
        String linha = "";
        String csvDivisor = ";";
        try {

            br = new BufferedReader(new FileReader(arquivoCSV));
            while ((linha = br.readLine()) != null) {

                String[] priceList = linha.split(csvDivisor);
                CurrencyConverterConverter currencyConverterConverter = new CurrencyConverterConverter();
                currentConverterList.add(currencyConverterConverter.currencyConverte(priceList));
            }
            return currentConverterList;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return currentConverterList;
    }
}