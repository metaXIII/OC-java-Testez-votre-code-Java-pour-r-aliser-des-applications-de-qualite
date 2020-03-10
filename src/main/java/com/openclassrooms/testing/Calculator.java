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
        Set<Integer> integers = new HashSet<>();
        String       integer  = String.valueOf(number);
        for (int i = 0; i < integer.length(); i++) {
            if (integer.charAt(i) != '-')
                integers.add(Integer.parseInt(integer, i, i + 1, 10));
        }
        return integers;
    }
}
