package br.com.emmelinebank.terminal.entitites;

import br.com.emmelinebank.terminal.exceptions.SaldoInsuficienteException;
import br.com.emmelinebank.terminal.exceptions.ValorInvalidoException;

public final class ContaPoupanca extends Conta {


    private double juros;
    private static final double IMPOSTO_SAQUE_CONTA_POUPANCA = 1.2;

    public ContaPoupanca(int numeroAgencia, int numeroConta, String titular, double saldo, double juros) {
        super(numeroAgencia, numeroConta, titular, saldo);
        this.juros = juros;
    }

    public ContaPoupanca(int numeroAgencia, int numeroConta, String titular, double juros) {
        super(numeroAgencia, numeroConta, titular);
        this.juros = juros;
    }


    public double getJuros() {
        return juros;
    }

    public void setJuros(double juros) {
        this.juros = juros;
    }


    @Override
    public void sacar(double montante) throws ValorInvalidoException, SaldoInsuficienteException {
        montante += IMPOSTO_SAQUE_CONTA_POUPANCA;
        super.sacar(montante);
    }
}
