package org.example;
public class App {
    public static void main( String[] args )
    {


  System.out.println("Hello World!");
    DB Database = new DB();
        Database.connect();

        System.out.println("\n############ DEPARTAMENTOS ###############");

    Departamento dpto1 = new Departamento(1);
    Departamento dpto2 = new Departamento(2);
    Departamento dpto3 = new Departamento(3);
    Departamento dpto4 = new Departamento(4);

        System.out.println("Departamento 1: " + dpto1.getNome() + " tem " + dpto1.getQuantidadeFuncionarios().toString() + " funcionários.");
        System.out.println("Departamento 2: " + dpto2.getNome() + " tem " + dpto2.getQuantidadeFuncionarios().toString() + " funcionários.");
        System.out.println("Departamento 3: " + dpto3.getNome() + " tem " + dpto3.getQuantidadeFuncionarios().toString() + " funcionários.");
        System.out.println("Departamento 4: " + dpto4.getNome() + " tem " + dpto4.getQuantidadeFuncionarios().toString() + " funcionários.");

        System.out.println("\n############ FUNCIONÁRIOS ###############");

    Funcionario func1 = new Funcionario(1);
    Funcionario func3 = new Funcionario(3);
    Funcionario func4 = new Funcionario(4);

        System.out.println("Funcionário 1: " + func1.getNome()
                + " trabalha como " + func1.getCargo() + " no Departamento " + func1.getDepartamentoNome()
                + " e recebe R$ " + func1.getSalario().toString());

        System.out.println("Funcionário 3: " + func3.getNome()
                + " trabalha como " + func3.getCargo() + " no Departamento " + func3.getDepartamentoNome()
                + " e recebe R$ " + func3.getSalario().toString());

        System.out.println("Funcionário 4: " + func4.getNome()
                + " trabalha como " + func4.getCargo() + " no Departamento " + func4.getDepartamentoNome()
                + " e recebe R$ " + func4.getSalario().toString());

        func1.setNome("Professor Gabriel");

        System.out.println("Funcionário 1: " + func1.getNome()
                + " trabalha como " + func1.getCargo() + " no Departamento " + func1.getDepartamentoNome()
                + " e recebe R$ " + func1.getSalario().toString());


}
}
