package br.com.prova.tecnica.cwi.exceptions;

public class ParametersAreNotValidException extends Exception {
    public ParametersAreNotValidException() {
        super("Os parâmetros informados não são válidos");
    }
}
