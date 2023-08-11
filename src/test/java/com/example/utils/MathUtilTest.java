package com.example.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MathUtilTest {
    @Test
    void mdc() {
        Integer numbs[] = {3, 6};
        int spected = 3;

        int actual = MathUtil.mdc(numbs);

        assertEquals(spected, actual);
    }
}