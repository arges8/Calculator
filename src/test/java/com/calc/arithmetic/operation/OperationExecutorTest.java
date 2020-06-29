package com.calc.arithmetic.operation;

import com.calc.arithmetic.operator.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperationExecutorTest {

    @Test
    void executeDividingOperation() {
        double result = OperationExecutor.executeOperation(54.11, 10,
                new DivisionOperator());
        assertEquals(5.411, result);
    }

    @Test
    void executeMultiplyingOperation() {
        double result = OperationExecutor.executeOperation(54.11, 10,
                new MultiplicationOperator());
        assertEquals(541.1, result);
    }

    @Test
    void executeSubtractingOperation() {
        double result = OperationExecutor.executeOperation(54.11, 10,
                new SubtractionOperator());
        assertEquals(44.11, result);
    }

    @Test
    void executeAddingOperation() {
        double result = OperationExecutor.executeOperation(54.11, 10,
                new AdditionOperator());
        assertEquals(64.11, result);
    }

    @Test
    void executeNoneOperation() {
        double result = OperationExecutor.executeOperation(54.11, 10,
                new NoneOperator());
        assertEquals(10, result);
    }
}