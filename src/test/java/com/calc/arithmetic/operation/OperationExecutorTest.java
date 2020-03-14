package com.calc.arithmetic.operation;

import com.calc.arithmetic.CalculatorOperator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperationExecutorTest {

    @Test
    void executeDividingOperation() {
        double result = OperationExecutor.executeOperation(54.11, 10,
                CalculatorOperator.DIVISION);
        assertEquals(5.411, result);
    }

    @Test
    void executeMultiplyingOperation() {
        double result = OperationExecutor.executeOperation(54.11, 10,
                CalculatorOperator.MULTIPLICATION);
        assertEquals(541.1, result);
    }

    @Test
    void executeSubtractingOperation() {
        double result = OperationExecutor.executeOperation(54.11, 10,
                CalculatorOperator.SUBTRACTION);
        assertEquals(44.11, result);
    }

    @Test
    void executeAddingOperation() {
        double result = OperationExecutor.executeOperation(54.11, 10,
                CalculatorOperator.ADDITION);
        assertEquals(64.11, result);
    }

    @Test
    void executeNoneOperation() {
        double result = OperationExecutor.executeOperation(54.11, 10,
                CalculatorOperator.NONE);
        assertEquals(10, result);
    }
}