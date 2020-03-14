package com.calc.arithmetic.store;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CacheStoreTest {
    CacheStore cacheStore = CacheStore.getInstance();

    @AfterEach
    void setToDefault() {
        cacheStore.setDefault();
    }

    @Test
    void testGettingStoredCache() {
        String storedCache = cacheStore.getCurrent();
        assertEquals("", storedCache);
    }

    @ParameterizedTest
    @ValueSource(strings = { "", "44+11=55", "65-11X2=108" })
    void testSettingCacheToStore(String cacheToStore) {
        checkIfCacheSetInStoreIsValid(cacheToStore);
    }

    @ParameterizedTest
    @ValueSource(strings = { "", "44+11=55", "65-11X2=108" })
    void testSettingCacheStoreToDefault(String cacheToStore) {
        checkIfCacheSetInStoreIsValid(cacheToStore);
        cacheStore.setDefault();
        String cacheStored = cacheStore.getCurrent();
        assertEquals("", cacheStored);
    }

    private void checkIfCacheSetInStoreIsValid(String cacheToStore) {
        cacheStore.setCurrent(cacheToStore);
        String storedCache = cacheStore.getCurrent();
        assertEquals(cacheToStore, storedCache);
    }

}