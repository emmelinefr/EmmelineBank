package br.com.emmelinebank.terminal.main;

import br.com.emmelinebank.terminal.entitites.*;
import br.com.emmelinebank.terminal.exceptions.SaldoInsuficienteException;
import br.com.emmelinebank.terminal.exceptions.ValorInvalidoException;

import javax.swing.*;

public class main {
    static void main() {

        //Contrata o gerente
        Funcionario gerenteSouza = new Funcionario("Souza", 1, 12000, CargoFuncionario.GERENTE);
        //Cria o banco
        Banco emmelineBank = new Banco(gerenteSouza, "Rua ABC, nº123");


        int opcaoInt;
        do {
            String opcaoStr = JOptionPane.showInputDialog(null,
                    "OPÇÕES:" +
                            "\n1. Listar Contas" +
                            "\n2. Adicionar Conta" +
                            "\n3. Pesquisar Conta por Número" +
                            "\n4. Encerrar Conta" +
                            "\n5. Sacar" +
                            "\n6. Depositar" +
                            "\n7. Sair",
                            "EmmelineBank",
                            JOptionPane.INFORMATION_MESSAGE);
            opcaoInt  = Integer.parseInt(opcaoStr);

            switch (opcaoInt) {
                case 1: //lista contas
                    emmelineBank.listarContas();
                    break;

                //todo aqui poderia ser um método criarConta() e depois colocava o de adicionar
                case 2: //adicionar conta
                    String titularStr = JOptionPane.showInputDialog(null, "Digite o nome do titular");

                    String numAgencia = JOptionPane.showInputDialog(null, "Digite o número da agência");
                    int numAgenciaInt = Integer.parseInt(numAgencia);

                    String numContaStr = JOptionPane.showInputDialog(null, "Digite o número da conta");
                    int numContaInt = Integer.parseInt(numContaStr);

                    String tipoDaContaStr = JOptionPane.showInputDialog(null,
                            "1. Conta Corrente" +
                                    "\n2. Conta Poupanca",
                                    "TIPO DA CONTA",
                                    JOptionPane.QUESTION_MESSAGE);
                    int tipoDaContaInt = Integer.parseInt(tipoDaContaStr);

                    Conta novaConta = null;

                    if (tipoDaContaInt == 1) {
                        novaConta = new ContaCorrente(numAgenciaInt, numContaInt, titularStr);

                    } else if (tipoDaContaInt == 2) {
                        String jurosStr = JOptionPane.showInputDialog(null, "Digite o valor do juros:");
                        double jurosDoub = Double.parseDouble(jurosStr);

                        novaConta = new ContaPoupanca(numAgenciaInt, numContaInt, titularStr, jurosDoub);

                    } else {
                        JOptionPane.showMessageDialog(null, "Opção inválida!");
                    }

                    //adiciona na lista de contas
                    if (novaConta != null) {
                        emmelineBank.abrirConta(novaConta);
                    }
                    break;

                case 3: //pesquisar conta por número
                    emmelineBank.pesquisarContaPeloNumero();
                    break;

                case 4: //encerrar conta pelo número
                    emmelineBank.encerrarContaPeloNumero();
                    break;

                case 5: // sacar
                    Conta contaEncontradaSacar = emmelineBank.pesquisarContaPeloNumero();

                    if (contaEncontradaSacar == null) {
                        JOptionPane.showMessageDialog(null, "Nenhuma conta encontrada!");
                        break;
                    }

                    String valorSaqueSacarStr = JOptionPane.showInputDialog(null, "Sr(a) " + contaEncontradaSacar.getTitular() + ", quanto você deseja sacar?"
                    );
                    double valorSaqueSacarDou = Double.parseDouble(valorSaqueSacarStr);

                    try {
                        contaEncontradaSacar.sacar(valorSaqueSacarDou);
                        JOptionPane.showMessageDialog(null, "Saque realizado com sucesso!");

                    } catch (ValorInvalidoException e) {
                        JOptionPane.showMessageDialog(null, "Você informou um valor inválido!");

                    } catch (SaldoInsuficienteException e) {
                        JOptionPane.showMessageDialog(null, "Você não tem saldo suficiente!");
                    }

                    JOptionPane.showMessageDialog(null, "Operação encerrada!");
                    break;

                case 6:
                    Conta contaEncontradaDepositar = emmelineBank.pesquisarContaPeloNumero();

                    if (contaEncontradaDepositar == null) {
                        JOptionPane.showMessageDialog(null, "Nenhuma conta encontrada!");
                        break;
                    }

                    String valorDepositarStr = JOptionPane.showInputDialog(null, "Sr(a) " + contaEncontradaDepositar.getTitular() + ", quanto você deseja depositar?"
                    );
                    double valorDepositarDou = Double.parseDouble(valorDepositarStr);

                    try {
                        contaEncontradaDepositar.depositar(valorDepositarDou);
                        JOptionPane.showMessageDialog(null, "Saque realizado com sucesso!");

                    } catch (ValorInvalidoException e) {
                        JOptionPane.showMessageDialog(null, "Você informou um valor inválido!");
                    }

                    JOptionPane.showMessageDialog(null, "Operação encerrada!");
                    break;
            }


        } while (opcaoInt != 7);
            JOptionPane.showMessageDialog(null, "Obrigado por usar o EmmelineBank!");

    }
}
