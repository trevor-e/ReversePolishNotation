package com.trevore.rpn;

/**
 * Created by trevor on 4/4/16.
 */
public class ValueToken {

    private double value;

    public ValueToken(String input) {
        try {
            value = Double.parseDouble(input);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("Illegal string as input: " + input);
        }
    }

    public ValueToken(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
