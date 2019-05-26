<h3>Currency Converter</h3>

<h3>You should create the following function:</h3>

- [x] public BigDecimal currencyQuotation(String from, String to, Number value, String quotation);

<br/><h3>Where</h3>

- [x] ! from: String with the currency name (example &quot;USD&quot;) you want to convert;
- [x] ! to: String with the currency name (example &quot;EUR&quot;) you want to see the result;
- [x] ! value: The value that should be converted. The currency of this value will be expressed in the “from” parameter;
- [x] ! quotation: A date as String in the format “dd/MM/yyyy”;

<br/><h4>Restrictions:</h4>

- [x] ! You shall not work with non-native classes / libraries;
- [x] ! If the from or to parameters are not valid, an exception must be thrown;
- [x] ! If the value is smaller than zero, an exception must be thrown;
- [x] ! For non-working days (Saturday and Sunday, ignoring holidays) takes the quotation from the immediately preceding business day. If the quotation of the previous day is not available, an exception must be thrown;
- [x] ! If the quotation date is not available, an exception must be thrown;
- [x] ! The data source used will be the Brazilian Central Bank CSV file available at: http://www4.bcb.gov.br/pec/taxas/batch/cotacaomoedas.asp?id=txtodas
- [x] ! The value must be calculated dynamically with different currencies and data. Quotes must be obtained from the Central Bank through the url informed.
- [x] ! The return value should be rounded to two decimal places;
- [x] ! Watch out for the different currency types (A and B), the Brazilian Central Bank link has guidelines on how to do the calculation. Look for the guidelines on the page that contains the quotations;
- [x] ! You can use the Brazilian Central Bank calculator to test your solution http://www4.bcb.gov.br/pec/conversao/conversao.asp;
