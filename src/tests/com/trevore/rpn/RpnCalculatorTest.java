package com.trevore.rpn;

import org.junit.Test;

import static org.junit.Assert.*;

public class RpnCalculatorTest {

    @Test
    public void testCalculate() throws Exception {
        RpnCalculator calculator = new RpnCalculator();
        assertEquals(14.0, calculator.calculate("5 1 2 + 4 * + 3 -"), 0);
        assertEquals(2, calculator.calculate("1 1 +"), 0);
        assertEquals(0, calculator.calculate("1 1 -"), 0);
        assertEquals(-1, calculator.calculate("0 1 -"), 0);
        assertEquals(0, calculator.calculate("-1 1 +"), 0);
        assertEquals(2, calculator.calculate("6 3 /"), 0);
        assertEquals(6, calculator.calculate("6"), 0);
        assertEquals(7.5, calculator.calculate("15 2 /"), 0);
        assertEquals(.161, calculator.calculate("2.5 15.5 /"), .001);
        assertEquals(100, calculator.calculate("10 10 *"), 0);
        assertEquals(0, calculator.calculate("0 1 /"), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoOperator() {
        RpnCalculator calculator = new RpnCalculator();
        calculator.calculate("2 2");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTooManyOperators() {
        RpnCalculator calculator = new RpnCalculator();
        calculator.calculate("2 2 + +");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOnlyOperators() {
        RpnCalculator calculator = new RpnCalculator();
        calculator.calculate("+ +");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidCharacters() {
        RpnCalculator calculator = new RpnCalculator();
        calculator.calculate("2 a +");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoSpaces() {
        RpnCalculator calculator = new RpnCalculator();
        calculator.calculate("22+");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoSpaces2() {
        RpnCalculator calculator = new RpnCalculator();
        calculator.calculate("2 2+ 3");
    }

    @Test(expected = AssertionError.class)
    public void testDivideByZero() {
        RpnCalculator calculator = new RpnCalculator();
        calculator.calculate("1 0 /");
    }

    @Test(expected = NullPointerException.class)
    public void testNullInput() {
        RpnCalculator calculator = new RpnCalculator();
        calculator.calculate(null);
    }
}