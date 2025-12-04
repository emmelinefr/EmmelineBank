package br.com.emmelinebank.terminal.entitites;

import javax.swing.*;
import java.util.ArrayList;


public class Banco {

    private Funcionario gerente;
    private String endereco;
    private ArrayList<Conta> contas = new  ArrayList<>();


    public Banco(Funcionario gerente, String endereco) {
        this.gerente = gerente;
        this.endereco = endereco;
    }


    public Funcionario getGerente() {
        return gerente;
    }

    public void setGerente(Funcionario gerente) {
        this.gerente = gerente;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }


    public void abrirConta(Conta novaConta) {
        contas.add(novaConta);
        JOptionPane.showMessageDialog(null,"Conta de " + novaConta.getTitular() + " aberta com sucesso!");
    }

    public void listarContas() {
        if (contas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma conta encontrada!");
        } else {
            String txtListaDeContas = "";
            for (Conta conta_indice : contas) {
                txtListaDeContas += "\nTitular: " + conta_indice.getTitular() +
                        "\nNúmero da Conta: " + conta_indice.getNumeroConta() +
                        "\nNúmero da Agência: " + conta_indice.getNumeroAgencia() +
                        "\nTipo da Conta: " + conta_indice.getTipo() +
                        "\nSaldo: " + conta_indice.getExtrato() +
                        "\n----------------------------";
            }
            JOptionPane.showMessageDialog(null,
                    txtListaDeContas,
                    "LISTA DE CONTAS",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public Conta pesquisarContaPeloNumero() {
        String numContaPesqStr = JOptionPane.showInputDialog(null, "Digite o numero da conta a ser pesquisada:");
        int numContaPesqInt = Integer.parseInt(numContaPesqStr);

        Conta contaEncontrada = null;
        for (Conta conta_indice : contas) {
            if (conta_indice.getNumeroConta() == numContaPesqInt) {
                contaEncontrada = conta_indice;
                break;
            }
        }

        if (contaEncontrada != null) {
            contaEncontrada.exibirInfoConta();
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma conta encontrada!");
        }

        return contaEncontrada;
    }

    public void encerrarContaPeloNumero() {
        String numContaPesqStr = JOptionPane.showInputDialog(null, "Digite o numero da conta a ser pesquisada:");
        int numContaPesqInt = Integer.parseInt(numContaPesqStr);

        Conta contaEncontrada = null;
        for (Conta conta_indice : contas) {
            if (conta_indice.getNumeroConta() == numContaPesqInt) {
                contaEncontrada = conta_indice;
                break;
            }
        }

        if (contaEncontrada != null) {
            String encerrarContaStr = JOptionPane.showInputDialog(null,
                    contaEncontrada.exibirInfoConta() +
                    "\n1. Encerrar" +
                    "\n2. Cancelar encerramento",
                    "DEJESA ENCERRAR ESTA CONTA?",
                    JOptionPane.QUESTION_MESSAGE);
            int encerrarContaInt = Integer.parseInt(encerrarContaStr);

            if (encerrarContaInt == 1) {
                contas.remove(contaEncontrada);
                JOptionPane.showMessageDialog(null, "Conta encerrada com sucesso!");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma conta encontrada!");
        }
    }

}
