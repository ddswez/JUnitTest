package com.example.lpf.junittest.junit;

/**
 * Created by lpf on 17/6/16.
 */

public class Calculator {
    public int add(int one, int another) {
        return one + another;
    }

    public int multiply(int one, int another) {
        return one * another;
    }

    public double divide(double divident, double dividor) {
        if (dividor == 0) throw new IllegalArgumentException("Dividor cannot be 0");

        return divident / dividor;
    }
}
