package com.example;

import com.example.utils.MathUtil;

public class AppMath {

    public static void main(String[] args) {

        var mdc = MathUtil.mdc(6, 0);
        var mdc2 = MathUtil.mdc(0, 0, 0);
        var mdc3 = MathUtil.mdc(31, 29, 59);

        var mmc = MathUtil.mmc(21, 6);

        System.out.println("MDC: " + mdc);
        System.out.println("MDC2: " + mdc2);
        System.out.println("MDC3: " + mdc2);
    }
    
}
