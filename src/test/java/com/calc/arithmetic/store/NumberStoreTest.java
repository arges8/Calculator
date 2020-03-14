package com.calc.arithmetic.store;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class NumberStoreTest {
    NumberStore numberStore = NumberStore.getInstance();

    @AfterEach
    void setToDefault() {
        numberStore.setDefault();
    }

    @Test
    void testGettingStoredNumber() {
        double storedNumber = numberStore.getCurrent();
        assertEquals(0, storedNumber);
    }

    @ParameterizedTest
    @ValueSource(doubles = { 8.3, 11, -3, 15.4, 45.11, 0, -17.9 })
    void testSettingNumberToStore(double numberToStore) {
        checkIfNumberSetInStoreIsValid(numberToStore);
    }

    @ParameterizedTest
    @ValueSource(doubles = { 8.3, 11, -3, 15.4, 45.11, 0, -17.9 })
    void testSettingNumberStoreDefault(double numberToStore) {
        checkIfNumberSetInStoreIsValid(numberToStore);
        numberStore.setDefault();
        double storedNumber = numberStore.getCurrent();
        assertEquals(0, storedNumber);
    }

    private void checkIfNumberSetInStoreIsValid(double numberToStore) {
        numberStore.setCurrent(numberToStore);
        double storedNumber = numberStore.getCurrent();
        assertEquals(numberToStore, storedNumber);
    }

}