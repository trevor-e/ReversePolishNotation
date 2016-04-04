package com.trevore.rpn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;
import java.util.logging.Logger;

public class RpnCalculator {

    private final static Logger LOGGER = Logger.getLogger(RpnCalculator.class.getName());

    private Deque<ValueToken> tokenStack;
    private int currentTokenIndex = 0;

    public double calculate(String input) {
        if (input == null) {
            throw new NullPointerException("Input cannot be null.");
        }

        tokenStack = new ArrayDeque<ValueToken>(input.length());
        currentTokenIndex = 0;

        StringTokenizer tokenizer = new StringTokenizer(input, " ");
        while (tokenizer.hasMoreTokens()) {
            processToken(tokenizer.nextToken());
            currentTokenIndex++;
        }

        if (tokenStack.size() != 1) {
            throw new IllegalArgumentException("Invalid result size of " + tokenStack.size());
        }

        return tokenStack.pop().getValue();
    }

    private void processToken(String token) {
        ValueToken value = token.length() == 1 && MathOperator.contains(token.charAt(0))
                ? new ValueToken(processOperator(token))
                : new ValueToken(token);
        tokenStack.push(value);
        LOGGER.info("Pushing token" + token);
    }

    private double processOperator(String operand) {
        if (tokenStack.size() < 2) {
            throw new IllegalArgumentException("Does not have two operands for operation " + operand + " at position " + currentTokenIndex + ".");
        }

        double first = tokenStack.pop().getValue();
        double second = tokenStack.pop().getValue();
        LOGGER.info("Popping " + first + " and " + second);

        MathOperator mathOperator = MathOperator.fromString(operand.charAt(0));
        return mathOperator.calculate(first, second);
    }

}