package br.com.prova.tecnica.cwi.exceptions;

public class ValueIsNotValidException extends Exception {
    public ValueIsNotValidException() {
        super("O Valor não pode ser menor que zero");
    }
}
