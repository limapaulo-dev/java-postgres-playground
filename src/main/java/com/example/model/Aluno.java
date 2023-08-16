package com.example.model;

public class Aluno {
    private String name;
    private Long matricula = null;
    private double nota1, nota2, nota3;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getMatricula() {
        return matricula;
    }
    public double getNota1() {
        return nota1;
    }
    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }
    public double getNota2() {
        return nota2;
    }
    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }
    public double getNota3() {
        return nota3;
    }
    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }

    public double calculateMedia(){
        return (this.nota1 + this.nota2 + this.nota3) / 3;
    }
}
