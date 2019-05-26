package br.com.prova.tecnica.cwi.service;

import br.com.prova.tecnica.cwi.entity.CurrencyConverter;
import br.com.prova.tecnica.cwi.exceptions.ParametersAreNotValidException;
import br.com.prova.tecnica.cwi.exceptions.ValueIsNotValidException;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.stream.Collectors;

public class CurrencyConverterService {

    public BigDecimal currencyQuotationBusinessRules(List<CurrencyConverter> currencyConverterList, String from, String to, Number value) {
        if (to.equals("USD")) {
            BigDecimal valueDouble = filterUSD(currencyConverterList, from, value);
            if (valueDouble != null) return valueDouble;
        } else if (to.equals("BRL")) {
            BigDecimal format = filterBRL(currencyConverterList, from, value);
            if (format != null) return format;
        } else {
            BigDecimal BRLValue = BigDecimal.ZERO;

            for (CurrencyConverter currencyConverter : currencyConverterList) {
                if (currencyConverter.getMoeda().equals(from)) {
                    BRLValue = convertBRL(value, currencyConverter);
                } else if (from.equals("BRL")) {
                    BRLValue = BigDecimal.valueOf(value.doubleValue());
                }
            }

            BigDecimal valueCurrentyInBRL = convertBRLToOtherCurrency(currencyConverterList, to, BRLValue);
            if (valueCurrentyInBRL != null) return valueCurrentyInBRL;
        }
        return null;
    }

    private BigDecimal convertBRLToOtherCurrency(List<CurrencyConverter> currencyConverterList, String to, BigDecimal BRLValue) {
        for (CurrencyConverter currencyConverter : currencyConverterList) {
            if (currencyConverter.getMoeda().equals(to)) {
                String replace = replaceComma(currencyConverter.getTaxaVenda());
                String valueFormat = numberFormat(BRLValue.doubleValue() / Double.parseDouble(replace));

                return BigDecimal.valueOf(Double.parseDouble(valueFormat));
            }
        }
        return null;
    }

    private String replaceComma(String taxaVenda) {
        return taxaVenda.replace(",", ".");
    }

    private BigDecimal filterBRL(List<CurrencyConverter> currencyConverterList, String from, Number value) {
        for (CurrencyConverter currencyConverter : currencyConverterList) {
            if (currencyConverter.getMoeda().equals(from)) {
                return convertBRL(value, currencyConverter);
            }
        }
        return null;
    }

    private BigDecimal convertBRL(Number value, CurrencyConverter currencyConverter) {
        String replace = replaceComma(currencyConverter.getTaxaCompra());
        String valueFormat = numberFormat(value.doubleValue() * Double.parseDouble(replace));

        return BigDecimal.valueOf(Double.parseDouble(valueFormat));
    }

    private BigDecimal filterUSD(List<CurrencyConverter> currencyConverterList, String from, Number value) {
        for (CurrencyConverter currencyConverter : currencyConverterList) {
            if (currencyConverter.getMoeda().equals(from) && currencyConverter.getTipo().equals("A")) {
                String replace = replaceComma(currencyConverter.getParidadeCompra());
                String valueFormat = numberFormat(value.doubleValue() / Double.parseDouble(replace));

                return BigDecimal.valueOf(Double.parseDouble(valueFormat));
            } else if (currencyConverter.getMoeda().equals(from) && currencyConverter.getTipo().equals("B")) {
                String replace = replaceComma(currencyConverter.getParidadeCompra());
                String valueFormat = numberFormat(value.doubleValue() * Double.parseDouble(replace));

                return BigDecimal.valueOf(Double.parseDouble(valueFormat));
            }
        }
        return null;
    }

    public void validParameter(List<CurrencyConverter> currencyConverterList, String from, String to) throws ParametersAreNotValidException {
        List<CurrencyConverter> resultFrom = currencyConverterList.stream().filter(currencyConverter ->
                from.equals(currencyConverter.getMoeda()) || from.equals("BRL")).collect(Collectors.toList());
        List<CurrencyConverter> resultTo = currencyConverterList.stream().filter(currencyConverter ->
                to.equals(currencyConverter.getMoeda()) || to.equals("BRL")).collect(Collectors.toList());

        if (resultFrom.isEmpty() || resultTo.isEmpty()) {
            throw new ParametersAreNotValidException();
        }
    }

    public void validValue(Number value) throws ValueIsNotValidException {
        if (value.doubleValue() < 0) {
            throw new ValueIsNotValidException();
        }
    }

    private String numberFormat(double valor) {
        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        dfs.setDecimalSeparator('.');
        DecimalFormat df = new DecimalFormat("0.00", dfs);
        return df.format(valor);
    }
}
