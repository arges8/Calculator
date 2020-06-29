package com.calc.arithmetic.operator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class OperatorFactoryTest {

    @ParameterizedTest
    @MethodSource("provideOperatorImplementations")
    void testCreatingInstancesOfCalculatorOperator(String operatorName, CalculatorOperator operatorInstance){
        CalculatorOperator operator = OperatorFactory.createOperator(operatorName);
        assertEquals(operator.getClass(), operatorInstance.getClass());
    }

    private static Stream<Arguments> provideOperatorImplementations() {
        return Stream.of(
                Arguments.of("", new NoneOperator()),
                Arguments.of("+", new AdditionOperator()),
                Arguments.of("-", new SubtractionOperator()),
                Arguments.of("X", new MultiplicationOperator()),
                Arguments.of("/", new DivisionOperator())
        );
    }
}