package com.example;

public class Classes {
    public static void main(String[] args) {
        System.out.println("\nEstudo sobre Classes");
        Cliente cliente1 = new Cliente();

        cliente1.setNome("Roberto Nascimento");
        cliente1.setSexo('m');
        cliente1.setAnoNasc(1957);
        cliente1.setRenda(1900.00);

        var splitNamecliente1 = cliente1.getNome().split(" ");

        System.out.println("Nome do Cliente1: " + cliente1.getNome());
        System.out.println("Sexo do Cliente1: " + cliente1.getSexo());
        System.out.println("Ano de Nascimento do Cliente1: " + cliente1.getAnoNasc());
        System.out.println("Renda do Cliente1: " + cliente1.getRenda());
        System.out.println("Cliente1 é VIP?: " + cliente1.isVIP());
        System.out.println("----------------------");

        Cliente cliente2 = new Cliente("Maria Eduarda", 'f', 1967, 2900.00);

        System.out.println("Nome do Cliente2: " + cliente2.getNome());
        System.out.println("Sexo do Cliente2: " + cliente2.getSexo());
        System.out.println("Ano de Nascimento do Cliente2: " + cliente2.getAnoNasc());
        System.out.println("Renda do Cliente2: " + cliente2.getRenda());
        System.out.println("Cliente2 é VIP?: " + cliente2.isVIP());
        System.out.println("----------------------");
    }
}
