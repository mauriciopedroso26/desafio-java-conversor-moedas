package br.com.prova.tecnica.cwi.download;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CurrencyConverterDownload {

    public static String downloadWithJava7IO(String quotation) throws IOException {
        String tmp = System.getProperty("java.io.tmpdir");

        try (InputStream in = new URL("https://www4.bcb.gov.br/Download/fechamento/" + formatQuotation(quotation) + ".csv").openStream()) {
            Files.copy(in, Paths.get(tmp + "/" + formatQuotation(quotation) + ".csv"), StandardCopyOption.REPLACE_EXISTING);
            return formatQuotation(quotation);
        } catch (IOException e) {
            InputStream in = new URL("https://www4.bcb.gov.br/Download/fechamento/" + formatQuotationChangingDay(quotation) + ".csv").openStream();
            Files.copy(in, Paths.get(tmp + "/" + formatQuotationChangingDay(quotation) + ".csv"), StandardCopyOption.REPLACE_EXISTING);
            return formatQuotationChangingDay(quotation);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private static String formatQuotation(String quotation){
        String[] split = quotation.split("/");
        return split[2] + split[1] + split[0];
    }

    private static String formatQuotationChangingDay(String quotation){
        String[] split = quotation.split("/");
        int actualDay = Integer.parseInt(split[0]);
        String beforeDay = String.valueOf(actualDay - 1);

        return split[2] + split[1] + beforeDay;
    }
}
