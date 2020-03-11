package com.calc.arithmetic.store;

import com.calc.arithmetic.CalculatorOperator;

import java.util.LinkedList;
import java.util.List;

public class ProxyCacheStore implements Store<String> {
    private static volatile ProxyCacheStore instance;
    private CacheStore cacheStore;
    private List<String> cachedEquations;

    private ProxyCacheStore() {
        cacheStore = CacheStore.getInstance();
        cachedEquations = new LinkedList<>();
    }

    public static ProxyCacheStore getInstance() {
        if(instance == null) {
            synchronized (ProxyCacheStore.class) {
                if(instance == null)
                    instance = new ProxyCacheStore();
            }
        }
        return instance;
    }

    @Override
    public String getCurrent() {
        return cacheStore.getCurrent();
    }

    @Override
    public void setCurrent(String cacheToStore) {
        cacheStore.setCurrent(cacheToStore);
    }

    @Override
    public void setDefault() {
        saveEquationInHistory();
        cacheStore.setDefault();
    }

    public void updateCurrent(String cacheToAdd) {
        CalculatorOperator operator = CalculatorOperator.getOperator(cacheToAdd);
        if(operator != CalculatorOperator.NONE)
            updateOperator(cacheToAdd);
        else
            cacheStore.updateCurrent(cacheToAdd);
    }

    public void finishEquation(String result) {
        updateOperator("=");
        String fullEquation = cacheStore.getCurrent() + result;
        cacheStore.setCurrent(fullEquation);
    }

    private void updateOperator(String operator) {
        String currentCache = cacheStore.getCurrent();
        String currentCacheWithoutOperator = currentCache.substring(0, currentCache.length() - 1);
        String cacheWithUpdatedOperator = currentCacheWithoutOperator + operator;
        cacheStore.setCurrent(cacheWithUpdatedOperator);
    }

    private void saveEquationInHistory() {
        String currentCache = cacheStore.getCurrent();
        cachedEquations.add(currentCache);
    }

    public List<String> getHistory() {
        return cachedEquations;
    }
}
