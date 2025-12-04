package br.com.emmelinebank.terminal.entitites;

public class Funcionario {

    private String nome;
    private long matricula;
    private double salario;
    private CargoFuncionario cargo;


    public Funcionario(String nome, long matricula, double salario, CargoFuncionario cargo) {
        this.nome = nome;
        this.matricula = matricula;
        this.salario = salario;
        this.cargo = cargo;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getMatricula() {
        return matricula;
    }

    public void setMatricula(long matricula) {
        this.matricula = matricula;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public CargoFuncionario getCargo() {
        return cargo;
    }

    public void setCargo(CargoFuncionario cargo) {
        this.cargo = cargo;
    }
}
