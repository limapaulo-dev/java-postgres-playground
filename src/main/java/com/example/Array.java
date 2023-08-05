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

/*     public static void printIntMatrix(int[] array){
        for (var element : array) {     
            if (element.getClass().isArray()) {
                printIntMatrix(element);
            } else {
                System.out.println(element);
            }           
        }
    } */

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

    double doubleArray[] = {10.11d, 50.12d, 78.54d};
        
    System.out.println(Arrays.toString(intArray));
    System.out.println("");

    System.out.println(intArray[0]);
    System.out.println(intArray[1]);
    System.out.println(intArray[2]);
    System.out.println("");

    iterateIntArray(newArray);

/*     printIntMatrix(array2d); */

    }

    
}
