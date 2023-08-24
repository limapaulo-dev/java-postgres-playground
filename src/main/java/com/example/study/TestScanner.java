package com.example.study;

import java.util.Scanner;

public class TestScanner {
    public static void main(String[] args) {

        // Cliente cliente3 = new Cliente();
        // Scanner scanner = new Scanner(System.in);

        // System.out.println("Digite o nome do cliente: ");
        // cliente3.setNome(scanner.nextLine());

        // System.out.println("Digite a renda do cliente, ex 1900: ");
        // cliente3.setRenda(scanner.nextDouble());
        // scanner.nextLine();

        // System.out.println("Digite o sexo do cliente, ex F ou M: ");
        // cliente3.setSexo(scanner.nextLine().charAt(0));

        // System.out.println("\n----------------------");
        // System.out.println("Nome do Cliente1: " + cliente3.getNome());
        // System.out.println("Sexo do Cliente1: " + cliente3.getSexo());
        // System.out.println("Renda do Cliente1: " + cliente3.getRenda());
        // System.out.println("----------------------");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um número");
        String test = scanner.nextLine();
        System.out.println("Número convertido para decimal");
        System.out.println(Double.parseDouble(test));
        System.out.println("Número convertido para Inteiro");
        System.out.println(Math.round(Double.parseDouble(test)));

    }
}

