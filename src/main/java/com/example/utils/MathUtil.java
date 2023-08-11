package com.example.utils;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MathUtil {

    public static int mdc(Integer... numbs){

        List<Integer> mdc = new LinkedList<>();

        var divs = getDivs(numbs);

        boolean isMDV = true;

        for (Integer div : divs) {
            isMDV = true;
            for (Integer numb : numbs) {       
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

    public static void printArrInt(Integer[] divs, String name) {
        System.out.print(name +": ");  
        for (int numb : divs) {
            System.out.print(numb + " ");    
        }
        System.out.println();
    }

    public static void printListInt(List<Integer> divs, String name) {
        System.out.print(name +": ");  
        for (int numb : divs) {
            System.out.print(numb + " ");    
        }
        System.out.println();
    }

    public static List<Integer> getDivs(Integer... numbs) {
        List<Integer> divs = new LinkedList<>();

        for (int numb : numbs) {
            for (int i = 1; i <= numb; i++) {
                if (numb % i == 0 && divs.contains(i) == false){
                    divs.add(i);
                }
            }
        }

        Collections.sort(divs);
        return divs;
    }
    
}
