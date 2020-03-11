package com.openclassrooms.testing;

import java.util.HashSet;
import java.util.Set;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public void longCalculation() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Set<Integer> digitsSet(int number) {
        Set<Integer> integers     = new HashSet<Integer>();
        String       numberString = String.valueOf(number);

        for (int i = 0; i < numberString.length(); i++) {
            if (numberString.charAt(i) != '-') {
                integers.add(Integer.parseInt(numberString, i, i + 1, 10));
            }
        }
        return integers;
    }

    public Double celsiusToFahrenheit(double v) {
        return (v * 1.8) + 32;
    }

    public Double fahrenheitToCelsius(double v) {
        return (v - 32) / (9.0 / 5.0);
    }

    public Double litresToGallons(double v) {
        return v / 3.785411784;
    }

    public Double radiusToAreaOfCircle(double v) {
        return Math.PI * (v * v);
    }
}
