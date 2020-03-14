package com.calc.arithmetic.store;

import com.calc.arithmetic.CalculatorOperator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

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
        assertEquals(CalculatorOperator.NONE, storedOperator);
    }

    @ParameterizedTest
    @EnumSource(CalculatorOperator.class)
    void testSettingOperatorToStore(CalculatorOperator operator) {
        checkIfOperatorSetInStoreIsValid(operator);
    }

    @ParameterizedTest
    @EnumSource(CalculatorOperator.class)
    void testSettingOperatorStoreDefault(CalculatorOperator operator) {
        checkIfOperatorSetInStoreIsValid(operator);
        operatorStore.setDefault();
        CalculatorOperator storedOperator = operatorStore.getCurrent();
        assertEquals(CalculatorOperator.NONE, storedOperator);
    }

    private void checkIfOperatorSetInStoreIsValid(CalculatorOperator operatorToStore) {
        operatorStore.setCurrent(operatorToStore);
        CalculatorOperator storedOperator = operatorStore.getCurrent();
        assertEquals(operatorToStore, storedOperator);
    }
}