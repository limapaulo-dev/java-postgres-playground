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

    public static <T> void arrayIterator(T[] array){
        for (int i = 0; i<array.length; i++){
            if (array[i].getClass().isArray()){
                arrayIterator((T[]) array[i]);
                System.out.println("");
            } else {
                System.out.print(array[i] + " ");
            }
        }

/*         for (T element : array) {
            if (element.getClass().isArray()){
                arrayIterator((T[]) element);
            } else {
                System.out.print(element + " ");
            }
        } */
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

    double doubleArray[][] = {{10.11d, 50.12d, 78.54d}, {10.11d, 50.12d, 78.54d}};

    Integer[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        
    System.out.println(Arrays.toString(intArray));
    System.out.println("");

    System.out.println(intArray[0]);
    System.out.println(intArray[1]);
    System.out.println(intArray[2]);
    System.out.println("");

    arrayIterator(array2d);
    System.out.println("");

    arrayIterator(matrix);
    System.out.println("");

    }
}
