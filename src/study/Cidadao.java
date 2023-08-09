package com.example;
import java.time.LocalDate;

public class Cidadao {

    private LocalDate dataNasc;

    public Cidadao(){
        int randYear, randMonth, randDay;
        randYear = (int)(Math.floor(Math.random()*(2023-1923+1)+1923));
        randMonth = (int)(Math.floor(Math.random()*(12-1+1)+1));
        randDay = (int)(Math.floor(Math.random()*(25-1+1)+1));
        setDataNasc((LocalDate.of(randYear, randMonth, randDay)));
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }


    public int idade() {
        return LocalDate.now().getYear() - dataNasc.getYear();
    }

    public String isEleitor() {
        int idade = idade();
        if (idade>17 && idade<70){
            return "Eleitor Obrigatório";
        } else if (idade>15 || idade > 69) {
            return "Eleitor Facultativo";
        } else {
            return "Não é Eleitor";
        }
    }
    
}
