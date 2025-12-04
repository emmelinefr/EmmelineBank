package br.com.emmelinebank.terminal.entitites;

public final class ContaCorrente extends Conta implements Tributavel {


    public ContaCorrente(int numeroAgencia, int numeroConta, String titular, double saldo) {
        super(numeroAgencia, numeroConta, titular, saldo);
    }

    public ContaCorrente(int numeroAgencia, int numeroConta, String titular) {
        super(numeroAgencia, numeroConta, titular);
    }

    @Override
    public double getTributo() {
        double tributo = 3;

        if (tributo < Tributavel.TRIBUTO_MINIMO) {
            tributo = Tributavel.TRIBUTO_MINIMO;
        }
        return tributo;
    }
}
