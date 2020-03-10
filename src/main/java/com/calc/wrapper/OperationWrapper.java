package com.calc.wrapper;

import com.calc.arithmetic.*;

public class OperationWrapper {
    private NumberStore numberStore;
    private OperatorStore operatorStore;
    private ProxyCacheStore cacheStore;
    private StringBuilder cacheTextToAdd;
    private OperationExecutor operationExecutor;

    public OperationWrapper() {
        numberStore = NumberStore.getInstance();
        operatorStore = OperatorStore.getInstance();
        cacheStore = ProxyCacheStore.getInstance();
        cacheTextToAdd = new StringBuilder();
        operationExecutor = new OperationExecutor();
    }

    public String executeOperationAndUpdateAllStores(String number, String operator) {
        double storedNumber = numberStore.getCurrent();
        double secondNumber = Double.parseDouble(number);
        CalculatorOperator givenOperator = CalculatorOperator.getOperator(operator);
        double result = operationExecutor.executeOperation(storedNumber, secondNumber, givenOperator);
        numberStore.setCurrent(result);
        cacheTextToAdd.append((int)result);
        return updateOperatorAndCacheStores(operator);
    }

    public String updateOperatorAndCacheStores(String operator) {
        CalculatorOperator givenOperator = CalculatorOperator.getOperator(operator);
        operatorStore.setCurrent(givenOperator);
        cacheTextToAdd.append(operator);
        String cacheFullTextToAdd = cacheTextToAdd.toString();
        cacheStore.updateCurrent(cacheFullTextToAdd);
        String fullCache = cacheStore.getCurrent();
        clearCacheTextToAdd();
        return fullCache;
    }

    private void clearCacheTextToAdd() {
        cacheTextToAdd = new StringBuilder();
    }

}
