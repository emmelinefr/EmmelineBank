package br.com.emmelinebank.terminal.exceptions;

public class SaldoInsuficienteException extends Exception{

    public SaldoInsuficienteException() {
    }

    public SaldoInsuficienteException(String message) {
        super(message);
    }
}
