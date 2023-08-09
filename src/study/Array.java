package com.example;

import java.util.Arrays;

public class Array {

    private int intArray[];

    public void setIntArray(int array[]){
        this.intArray = array;
    }

    public static void iterateIntArray(int[] array){
        for (var element : array) {            
            System.out.println(element);
        }
    }

    public static void fillDoubleArray(double[][] array){      
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++){
                double a = Math.round(Math.random()* 100);
                double b = Math.round(Math.random()* 100) / 100d;
                array[i][j] = a + b;
            }           
        }
    }

    public static void printDoubleArray(double[][] array){      
        for (int i = 0; i < array.length; i++) {
            if (i > 0){
                System.out.println("");
            }
            for (int j = 0; j < array[i].length; j++){
                System.out.printf("%5.2f ", array[i][j]);
            }           
        }
    }

    public static void main(String[] args) {

    int intArray[] = {10, 50, 78};

    int newArray[] = new int[4];
    newArray[0] = 100;
    newArray[1] = 200;
    newArray[2] = 300;
    newArray[3] = 400;
    
    //int array2d[][] = new int[3][3]; //3d array
    int array3d[][][] = new int[3][3][3]; //3d array
    Object array2d[][] = {{25, 21, 54}, {12, 44, 57}, {"hi"}};

    double doubleMatrix[][] = new double[5][5];

    Integer [][][] matrix = new Integer[3][3][3];
        
    System.out.println(Arrays.toString(intArray));
    System.out.println("");

    System.out.println(intArray[0]);
    System.out.println(intArray[1]);
    System.out.println(intArray[2]);
    System.out.println("");

    fillDoubleArray(doubleMatrix);
    printDoubleArray(doubleMatrix);
    System.out.println("");

    }
}
