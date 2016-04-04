package com.trevore.rpn;

/**
 * Created by trevor on 4/4/16.
 */
public enum MathOperator {
    ADD ('+') {
        @Override
        public double calculate(double first, double second) {
            return first + second;
        }
    },

    SUBTRACT ('-') {
        @Override
        public double calculate(double first, double second) {
            return second - first;
        }
    },

    MULTIPLY ('*') {
        @Override
        public double calculate(double first, double second) {
            return first * second;
        }
    },

    DIVIDE ('/') {
        @Override
        public double calculate(double first, double second) {
            if (first == 0) {
                throw new AssertionError("can't divide by 0");
            }
            return second / first;
        }
    };

    private final char symbol;

    MathOperator(char symbol) {
        this.symbol = symbol;
    }

    public abstract double calculate(double first, double second);

    public static MathOperator fromString(char input) {
        for (MathOperator mathOperator : values()) {
            if (mathOperator.symbol == input) {
                return mathOperator;
            }
        }

        throw new IllegalArgumentException("No matching operator found for " + input);
    }

    public static boolean contains(char input) {
        for (MathOperator mathOperator : values()) {
            if (mathOperator.symbol == input) {
                return true;
            }
        }

        return false;
    }
}
