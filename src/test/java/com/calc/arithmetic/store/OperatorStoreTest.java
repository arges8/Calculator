package com.calc.arithmetic.store;

import com.calc.arithmetic.operator.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class OperatorStoreTest {
    OperatorStore operatorStore = OperatorStore.getInstance();

    @AfterEach
    void setToDefault() {
        operatorStore.setDefault();
    }

    @Test
    void testGettingStoredOperator() {
        CalculatorOperator storedOperator = operatorStore.getCurrent();
        assertTrue(storedOperator instanceof NoneOperator);
    }

    @ParameterizedTest
    @MethodSource("provideOperatorImplementations")
    void testSettingOperatorToStore(CalculatorOperator operator) {
        checkIfOperatorSetInStoreIsValid(operator);
    }

    @ParameterizedTest
    @MethodSource("provideOperatorImplementations")
    void testSettingOperatorStoreDefault(CalculatorOperator operator) {
        checkIfOperatorSetInStoreIsValid(operator);
        operatorStore.setDefault();
        CalculatorOperator storedOperator = operatorStore.getCurrent();
        assertTrue(storedOperator instanceof NoneOperator);
    }

    private static Stream<Arguments> provideOperatorImplementations() {
        return Stream.of(
                Arguments.of(new NoneOperator()),
                Arguments.of(new AdditionOperator()),
                Arguments.of(new SubtractionOperator()),
                Arguments.of(new MultiplicationOperator()),
                Arguments.of(new DivisionOperator())
        );
    }

    private void checkIfOperatorSetInStoreIsValid(CalculatorOperator operatorToStore) {
        operatorStore.setCurrent(operatorToStore);
        CalculatorOperator storedOperator = operatorStore.getCurrent();
        assertEquals(operatorToStore, storedOperator);
    }
}