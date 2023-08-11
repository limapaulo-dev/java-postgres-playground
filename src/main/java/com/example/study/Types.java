package com.example.study;

public class Types {
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
        System.out.println("Minha Idade: "+ minhaIdade);
        System.out.println("Meu sexo é: "+ meuSexo);
        System.out.println("Estamos Online? "+ onlineCheck);
        System.out.println("-----------------------------\n");
    }
}
