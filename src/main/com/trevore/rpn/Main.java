package com.trevore.rpn;

public class Main {

    public static void main(String[] args) {
        RpnCalculator calculator = new RpnCalculator();
        System.out.println(calculator.calculate("5 1 2 + 4 * + 3 -"));
    }

}