package br.com.emmelinebank.terminal.entitites;

import javax.swing.*;

public class Conta {

    private int numeroAgencia;
    private int numeroConta;
    private String titular;
    private double saldo;
    private TipoConta tipo;

    private static final double VALOR_DEPOSITO_MINIMO = 0;
    public static final double VALOR_COTACAO_DOLAR = 5;
    public static final double VALOR_COTACAO_EURO = 6;


    public Conta(int numeroAgencia, int numeroConta, String titular, double saldo, TipoConta tipo) {
        this.numeroAgencia = numeroAgencia;
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = saldo;
        this.tipo = tipo;
    }

    public Conta(int numeroAgencia, int numeroConta, String titular, TipoConta tipo) {
        this.numeroAgencia = numeroAgencia;
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.tipo = tipo;
    }


    public int getNumeroAgencia() {
        return numeroAgencia;
    }

    public void setNumeroAgencia(int numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public TipoConta getTipo() {
        return tipo;
    }

    public void setTipo(TipoConta tipo) {
        this.tipo = tipo;
    }


    public void depositar (double montante) {
        if (montante > VALOR_DEPOSITO_MINIMO) {
            this.saldo += montante;
        }
    }

    public void depositar (double montante, TipoMoeda moeda) {
        double saldoDepositar = 0;

        switch (moeda) {
            case REAL:
                saldoDepositar = montante;
                break;

            case DOLAR:
                saldoDepositar = montante * VALOR_COTACAO_DOLAR;
                break;

            case EURO:
                saldoDepositar = montante * VALOR_COTACAO_EURO;
                break;
        }

        if (saldoDepositar > VALOR_DEPOSITO_MINIMO) {
            this.depositar(saldoDepositar);
        }
    }

    public void sacar (double montante) {
        if (montante > VALOR_DEPOSITO_MINIMO && montante <= saldo) {
            this.saldo -= montante;
        }
    }

    public double getExtrato() {
        return this.saldo;
    }

    public String exibirInfoConta () {
        return "\nTitular: " + this.getTitular() +
                "\nNúmero da Conta: " + this.getNumeroConta() +
                "\nNúmero da Agência: " + this.getNumeroAgencia() +
                "\nTipo da Conta: " + this.getTipo() +
                "\nSaldo: " + this.getExtrato() +
                "\n----------------------------";

    }
}
