package com.example.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MathUtilTest {
    @Test
    void testMdcP1() {
        Integer numbs[] = {-6, 0};
        int spected = 6;

        int actual = MathUtil.mdc(numbs);

        assertEquals(spected, actual);
    }

    @Test
    void testMdcP2Impar() {
        Integer numbs[] = {21, 6};
        int spected = 3;

        int actual = MathUtil.mdc(numbs);

        assertEquals(spected, actual);
    }

    @Test
    void testMdcP2Impar2() {
        Integer numbs[] = {22, 7};
        int spected = 1;

        int actual = MathUtil.mdc(numbs);

        assertEquals(spected, actual);
    }

    @Test
    void testMdcP4() {
        Integer numbs[] = {6, 3};
        
        int m = 2;

        Integer numbsM[] = new Integer[numbs.length];

        int spected = m*MathUtil.mdc(numbs);

        for (int i = 0; i < numbsM.length; i++) {
            numbsM[i] = numbs[i] * m;
        }

        int actual = MathUtil.mdc(numbsM);
        assertEquals(spected, actual);
    }

    @Test
    void testMdcP5() {

        Integer numbs[] = {-6, 0};
        Integer numbs2[] = {0, -6};

        int spected = MathUtil.mdc(numbs2);
        int actual = MathUtil.mdc(numbs);

        assertEquals(spected, actual);
    }
    
    @Test
    void testMdcZeroArgs() {
        int spected = MathUtil.mdc();
        int actual = MathUtil.mdc();

        assertEquals(spected, actual);
    }

    @Test
    void testMediaP1Int() {
        Double numbs[] = {4d, 6d};

        double spected = 5;

        double actual = MathUtil.media(numbs);

        assertEquals(spected, actual);
    }

    @Test
    void testMediaP1Zero() {
        Double[] numbs = {0d, 0d};

        double spected = 0;

        double actual = MathUtil.media(numbs);

        assertEquals(spected, actual);
    }

    @Test
    void testMediaP1SpectedFloat() {
        Double numbs[] = {4d, 7d};

        double spected = 5.5d;

        double actual = MathUtil.media(numbs);

        assertEquals(spected, actual);
    }

    @Test
    void testMediaP1ArgsFloat() {
        Double numbs[] = {4.5d, 6.3d};

        double spected = 5.4d;

        double actual = MathUtil.media(numbs);

        assertEquals(spected, actual);
    }

    @Test
    void testSimpleMdcP1BImpar() {
        int a = 6;
        int b = 3;

        int spected = 3;

        int actual = MathUtil.simpleMdc(a , b);

        assertEquals(spected, actual);
    }

    @Test
    void testSimpleMdcP3Negativo() {
        int a = -6;
        int b = 0;

        int spected = 6;

        int actual = MathUtil.simpleMdc(a , b);

        assertEquals(spected, actual);
    }

    @Test
    void testSimpleMdcP3Positivo() {
        int a = 6;
        int b = 0;

        int spected = 6;

        int actual = MathUtil.simpleMdc(a , b);

        assertEquals(spected, actual);
    }

    @Test
    void testSimpleMmcP1() {
        int a = 21;
        int b = 6;

        int spected = 42;

        int actual = MathUtil.mmc(a , b);

        assertEquals(spected, actual);
    }
}