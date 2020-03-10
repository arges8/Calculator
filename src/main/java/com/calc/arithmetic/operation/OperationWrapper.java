package com.calc.arithmetic.operation;

import com.calc.arithmetic.*;
import com.calc.arithmetic.store.NumberStore;
import com.calc.arithmetic.store.OperatorStore;
import com.calc.arithmetic.store.ProxyCacheStore;

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
        CalculatorOperator storedOperator = operatorStore.getCurrent();
        double result = operationExecutor.executeOperation(storedNumber, secondNumber, storedOperator);
        numberStore.setCurrent(result);
        cacheTextToAdd.append(number);
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
