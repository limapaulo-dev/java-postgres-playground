package com.example.utils;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MathUtil {

    public static int mdc(Integer... numbs){

        if (checkZeros(numbs) == 0){
            return 1;
        }

        var numbsAbs = absNumbs(numbs);
        var divs = getDivs(numbsAbs);

        List<Integer> mdc = new LinkedList<>();
        for (Integer div : divs) {
            boolean isMDV = true;
            for (Integer numb : numbsAbs) {
                if (numb % div != 0){
                    isMDV = false;
                }
            }
            if(isMDV){
                mdc.add((Integer)div);
            }
        }
        return Collections.max(mdc);
    }

    public static int mmc(Integer... numbs){

        int mult = 1;
        
        for (int numb : numbs) {
            mult = mult * numb;
        }

        System.out.println("multiplicação: " + mult + " mdc: " + mdc(numbs));

        int mmc = mult/mdc(numbs);
       
        return mmc;
    }

    private static int checkZeros(Integer[] numbs) {

        int soma = 0;

        for (Integer numb : numbs) {
            soma = soma + numb;
        }

        return soma;
    }

    private static List<Integer> absNumbs(Integer... numbs) {
        List<Integer> absNumbs = new LinkedList<>();

        for (Integer numb : numbs) {
                absNumbs.add(Math.abs(numb));   
        }

        return absNumbs;
    }

    public static int simpleMdc(int a, int b){

        if ( b > 0 && a % b == 0){
            return b;
        } 

        if (a == 0 && b != 0){
            return Math.abs(b);
        }

        if (b == 0 && a != 0){
            return Math.abs(a);
        }

        return 0;
    }

    public static void printArrInt(Integer[] divs, String string) {
        System.out.print(string);  
        for (int numb : divs) {
            System.out.print(numb + " ");    
        }
        System.out.println();
    }

    public static void printListInt(List<Integer> divs, String string) {
        System.out.print(string);  
        for (int numb : divs) {
            System.out.print(numb + " ");    
        }
        System.out.println();
    }

    public static List<Integer> getDivs(List<Integer> numbsAbs) {
        List<Integer> divs = new LinkedList<>();

        for (int numb : numbsAbs) {
            for (int i = 1; i <= numb; i++) {
                if (numb % i == 0 && divs.contains(i) == false){
                    divs.add(i);
                }
            }
        }

        Collections.sort(divs);
        return divs;
    }

    public static double media(Double... numbs){

        double soma = 0;

        for (double numb : numbs) {
            soma = soma + numb;
        }

        double media = soma / numbs.length;

        return media;
    }
    
}
