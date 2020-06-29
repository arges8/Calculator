//package com.calc.arithmetic.operation;
//
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class OperationTest {
//
//    @Test
//    void testDividingWithNaturalNumberResultExpected() {
//        double result = Operation.division(6,3);
//        assertEquals(2, result);
//    }
//
//    @Test
//    void testDividingWithRealNumberResultExpected() {
//        double result = Operation.division(6,4);
//        assertEquals(1.5, result);
//    }
//
//    @Test
//    void testThrowArithmeticExceptionWhenDividingByZero() {
//        assertThrows(ArithmeticException.class, () -> Operation.division(6, 0));
//    }
//
//    @Test
//    void testMultiplyingTwoNaturalNumbers() {
//        double result = Operation.multiplication(6, 3);
//        assertEquals(18, result);
//    }
//
//
//    @Test
//    void testMultiplyingTwoRealNumbers() {
//        double result = Operation.multiplication(6.5, 3.2);
//        assertEquals(20.8, result);
//    }
//
//    @Test
//    void testMultiplyingByZero() {
//        double result = Operation.multiplication(6.5, 0);
//        assertEquals(0, result);
//    }
//
//    @Test
//    void testSubtractingTwoNaturalNumbers() {
//        double result = Operation.subtraction(6, 2);
//        assertEquals(4, result);
//    }
//
//    @Test
//    void testSubtractingTwoRealNumbers() {
//        double result = Operation.subtraction(6.5, 2.3);
//        assertEquals(4.2, result);
//    }
//
//    @Test
//    void testSubtractingTwoNegativeNumbers() {
//        double result = Operation.subtraction(-6, -2);
//        assertEquals(-4, result);
//    }
//
//    @Test
//    void testAddingTwoNaturalNumbers() {
//        double result = Operation.addition(6, 2);
//        assertEquals(8, result);
//    }
//
//    @Test
//    void testAddingTwoRealNumbers() {
//        double result = Operation.addition(6.5, 2.3);
//        assertEquals(8.8, result);
//    }
//
//    @Test
//    void testAddingTwoNegativeNumbers() {
//        double result = Operation.addition(-6.5, -2.3);
//        assertEquals(-8.8, result);
//    }
//}