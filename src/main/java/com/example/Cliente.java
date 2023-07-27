package com.example;

public class Cliente {
    private String nomeCliente;
    private char sexoCliente;
    private int anoNascCliente;
    private double rendaCliente;
    private boolean VIP;
    
    public Cliente(){
        System.out.println("\n----------------------");
        System.out.println("Classe Cliente Criada!");
        System.out.println("----------------------");

        setVIP(randomBool());
    }

    public Cliente(String nomeCliente, char sexoCliente, int anoNascCliente, double rendaCliente){
        this();
        System.out.println("Utilizando Parâmetros");
        System.out.println("----------------------");
        
        setNome(nomeCliente);
        setSexo(sexoCliente);
        setAnoNasc(anoNascCliente);
        setRenda(rendaCliente);
    }

    public boolean randomBool(){
        return (Math.random() > 0.5) ? true : false;
    }

    public String getNome(){
        return this.nomeCliente;
    }
    public char getSexo(){
        return this.sexoCliente;
    }
    public int getAnoNasc(){
        return this.anoNascCliente;
    }
    public double getRenda(){
        return this.rendaCliente;
    }
    public boolean isVIP(){
        return this.VIP;
    }

    public void setNome(String nome){
        this.nomeCliente = (nome instanceof String) ? nome : "";
    }
    public void setSexo(char sexo){
        this.sexoCliente = (sexo == 'M' || sexo == 'F') ? sexo : ' ';
    }
    public void setAnoNasc(int ano){
        this.anoNascCliente = (ano > 0) ? ano : 0;
    }
    public void setRenda(double renda){
        this.rendaCliente = (renda > 0) ? renda : 0;
    }
    public void setVIP(boolean vip){
        this.VIP = vip;
    }
}