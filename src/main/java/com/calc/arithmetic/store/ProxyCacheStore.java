package com.calc.arithmetic.store;

import com.calc.arithmetic.operator.CalculatorOperator;
import com.calc.arithmetic.operator.NoneOperator;
import com.calc.arithmetic.operator.OperatorFactory;

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
        CalculatorOperator operator = OperatorFactory.createOperator(cacheToAdd);
        if(!(operator instanceof NoneOperator))
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
        if(currentCache.length() > 0) {
            String currentCacheWithoutOperator = currentCache.substring(0, currentCache.length() - 1);
            String cacheWithUpdatedOperator = currentCacheWithoutOperator + operator;
            cacheStore.setCurrent(cacheWithUpdatedOperator);
        }
    }

    private void saveEquationInHistory() {
        String currentCache = cacheStore.getCurrent();
        if(currentCache.contains("="))
            cachedEquations.add(currentCache);
    }

    public List<String> getHistory() {
        return cachedEquations;
    }
}
