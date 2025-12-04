package br.com.emmelinebank.terminal.main;

import br.com.emmelinebank.terminal.entitites.*;

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
                            "\n5. Sair",
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
            }

        } while (opcaoInt != 5);
            JOptionPane.showMessageDialog(null, "Obrigado por usar o EmmelineBank!");

    }
}
