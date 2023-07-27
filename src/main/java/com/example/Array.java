package com.example;

import java.util.Arrays;

public class Array {
    public static void main(String[] args) {

    int intArray[] = {10, 50, 78};

    int newArray[] = new int[4];
    newArray[0] = 100;
    newArray[1] = 200;
    newArray[2] = 300;
    newArray[3] = 400;
    
    //int array2d[][] = new int[3][3]; //3d array
    int array3d[][][] = new int[3][3][3]; //3d array
    int array2d[][] = {{25, 21, 54}, {12, 44, 57}};

    double doubleArray[] = {10.11d, 50.12d, 78.54d};
        
    System.out.println(Arrays.toString(intArray));
    System.out.println(intArray[0]);
    System.out.println(intArray[1]);
    System.out.println(intArray[2]);

    }
}
