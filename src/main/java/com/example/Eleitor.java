package com.example;

import java.time.LocalDate;

public class Eleitor {

    

    public static void main(String[] args) {
      
        int randYear, randMonth, randDay;

        int populacao = 25;
        int index = 0;

        boolean smart = false;
        int tentativas = 0;
        int contador = 0;

        System.out.println("-----------");
        System.out.println("Iniciando contagem");
        while (tentativas > 0){
            randYear = (int)(Math.floor(Math.random()*(2023-1923+1)+1923));
            ++contador;

            if (randYear == 2023 || randYear == 1923){
                System.out.println("contagem: " + contador);
                System.out.println("Você é esperto!");
                System.out.println("-----------");
            }

            if (randYear == 2024 || randYear == 1922){
                System.out.println("contagem: " + contador);
                System.out.println("Você é burro!");
                System.out.println("-----------");
            }

            --tentativas;
        }

        while (populacao > 0) {
            System.out.println("-----------");
            System.out.println("Cidadão: " + ++index);
            var Cidadao = new Cidadao();
            System.out.println("Idade: " + Cidadao.idade());
            System.out.println(Cidadao.isEleitor());
            System.out.println("-----------");
            System.out.println("");
            --populacao;
        }

    }
    
}
