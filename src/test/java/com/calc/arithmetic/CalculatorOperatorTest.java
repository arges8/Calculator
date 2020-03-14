package com.calc.arithmetic;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorOperatorTest {

    @Test
    void testGettingDivisionOperator() {
        CalculatorOperator operator = CalculatorOperator.getOperator("/");
        assertEquals(CalculatorOperator.DIVISION, operator);
    }

    @Test
    void testGettingMultiplicationOperator() {
        CalculatorOperator operator = CalculatorOperator.getOperator("X");
        assertEquals(CalculatorOperator.MULTIPLICATION, operator);
    }

    @Test
    void testGettingAdditionOperator() {
        CalculatorOperator operator = CalculatorOperator.getOperator("+");
        assertEquals(CalculatorOperator.ADDITION, operator);
    }

    @Test
    void testGettingSubtractionOperator() {
        CalculatorOperator operator = CalculatorOperator.getOperator("-");
        assertEquals(CalculatorOperator.SUBTRACTION, operator);
    }

    @Test
    void testGettingNoneOfOperatorsEmptyString() {
        CalculatorOperator operator = CalculatorOperator.getOperator("");
        assertEquals(CalculatorOperator.NONE, operator);
    }

    @Test
    void testGettingNoneOfOperatorsTestString() {
        CalculatorOperator operator = CalculatorOperator.getOperator("test");
        assertEquals(CalculatorOperator.NONE, operator);
    }
}