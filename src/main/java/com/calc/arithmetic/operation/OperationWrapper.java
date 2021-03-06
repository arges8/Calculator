package com.calc.arithmetic.operation;

import com.calc.arithmetic.operator.CalculatorOperator;
import com.calc.arithmetic.operator.NoneOperator;
import com.calc.arithmetic.operator.OperatorFactory;
import com.calc.arithmetic.store.NumberStore;
import com.calc.arithmetic.store.OperatorStore;
import com.calc.arithmetic.store.ProxyCacheStore;

public class OperationWrapper {
    private NumberStore numberStore;
    private OperatorStore operatorStore;
    private ProxyCacheStore cacheStore;
    private StringBuilder cacheTextToAdd;

    public OperationWrapper() {
        numberStore = NumberStore.getInstance();
        operatorStore = OperatorStore.getInstance();
        cacheStore = ProxyCacheStore.getInstance();
        cacheTextToAdd = new StringBuilder();
    }

    public String executeOperationAndUpdateAllStores(String number, String operator) {
        double storedNumber = numberStore.getCurrent();
        double secondNumber = Double.parseDouble(number);
        CalculatorOperator storedOperator = operatorStore.getCurrent();
        cacheTextToAdd.append(number);
        double result = OperationExecutor.executeOperation(storedNumber, secondNumber, storedOperator);
        numberStore.setCurrent(result);
        return updateOperatorAndCacheStores(operator);
    }

    public String updateOperatorAndCacheStores(String operator) {
        if(!areAllStoresDefault()) {
            CalculatorOperator givenOperator = OperatorFactory.createOperator(operator);
            cacheTextToAdd.append(operator);
            operatorStore.setCurrent(givenOperator);
            String cacheFullTextToAdd = cacheTextToAdd.toString();
            cacheStore.updateCurrent(cacheFullTextToAdd);
        }

        String fullCache = cacheStore.getCurrent();
        clearCacheTextToAdd();

        return fullCache;
    }

    public String setAllStoresDefaultAndSaveCacheTextInHistory() {
        double res = numberStore.getCurrent();
        String result = Double.toString(res);
        numberStore.setDefault();
        operatorStore.setDefault();
        cacheStore.finishEquation(result);
        cacheStore.setDefault();

        return result;
    }

    public void setAllStoresDefault() {
        numberStore.setDefault();
        operatorStore.setDefault();
        cacheStore.setDefault();
    }

    private boolean areAllStoresDefault() {
        if(numberStore.getCurrent() == 0.0 &&
                operatorStore.getCurrent() instanceof NoneOperator &&
                "".equals(cacheStore.getCurrent()))
            return true;

        return false;
    }

    private void clearCacheTextToAdd() {
        cacheTextToAdd = new StringBuilder();
    }

}
