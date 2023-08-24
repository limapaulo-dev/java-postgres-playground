package com.example.study;

import java.util.*;


public class Types {

    public static String getColumnLetter(int columnNumber){
        return "ABCDEFGHIJKLMNOPQRSTUVWXYZ".substring(columnNumber-1, columnNumber);
    }

    public static String getColumnLetters(int columnNumber){

        String columnLetters = "";
        System.out.println(columnNumber);
        
        while(columnNumber > 0){     
            System.out.println("extern loop");      
            while(columnNumber > 26){
                System.out.println("intern loop");
                columnLetters += getColumnLetter(columnNumber % 26);
                System.out.println(columnNumber % 26);
                System.out.println(columnLetters);

                columnNumber = columnNumber - (columnNumber % 26);
                System.out.println(columnNumber);
            }
            columnLetters += getColumnLetter(columnNumber);
            columnNumber -= columnNumber;
        }

        return columnLetters;
    }

    public static void main(String[] args) {

        byte byteNum = 15;
        short shortNum = 15152;
        int intNum = 897985152;
        long longNum = 1546498798;

        float floatNum = 15.15f;
        double doubleNum = 415.554654654d;

        int minhaIdade = 35;
        char meuSexo = 'M';
        String meuNome = "Paulo Lima";
        boolean onlineConection = true;

        String onlineCheck = (onlineConection) ? "Sim" : "Não";

        System.out.println("\n-----------------------------");
        System.out.println("Meu nome é: " + meuNome);
        System.out.println("Minha Idade: " + minhaIdade);
        System.out.println("Meu sexo é: " + meuSexo);
        System.out.println("Estamos Online? " + onlineCheck);
        System.out.println("-----------------------------\n");

        System.out.printf("%s %d %f %f", meuNome, minhaIdade, floatNum, doubleNum);
        System.out.println();
        System.out.println("Estamos Online? " + onlineCheck + " oh yeah");

        String[] stringWords = { "maria", "paulo", "joao" };
        String[] stringPreffix = { "maria", "mariana", "marcia" };

        char[] charArray = stringWords[0].toCharArray();

        String name = "" + stringWords[0];

        boolean[] checkPref = new boolean[2];
    
        System.out.println(name);

        String word = "bla";
        String wordBig = "blabla";
        String wordSum = word + word;

        System.out.println(wordBig == wordSum);
        System.out.println(wordBig == wordSum);
        System.out.println(wordBig == wordSum);

        System.out.println(word.length() % 2 != 0 );

        System.out.println(word.substring(0, 1) );
        System.out.println(word.substring(1, 2) );

        String columnLetter = getColumnLetter(1);
        String columnLetter2 = getColumnLetter(2);
        
        System.out.println(columnLetter);
        System.out.println(columnLetter2);

        // String columnLetter50 = getColumnLetters(50);
        // System.out.println(columnLetter50);

        // String columnLetter701 = getColumnLetters(701);
        // System.out.println(columnLetter50);

        char character = 'A' + 25;

        System.out.println(character);
        
    }
}
