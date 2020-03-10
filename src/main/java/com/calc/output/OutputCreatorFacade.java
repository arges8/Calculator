package com.calc.output;

import com.calc.arithmetic.CalculatorOperator;
import com.calc.arithmetic.OperationExecutor;
import com.calc.arithmetic.OperatorStore;
import com.calc.arithmetic.ProxyCacheStore;

public class OutputCreatorFacade {
    private TextUpdaterFacade textUpdaterFacade;
    private OperationExecutor operationExecutor;
    private OperatorStore operatorStore;
    private ProxyCacheStore cacheStore;
    private boolean operatorUsedRecently;

    public OutputCreatorFacade() {
        textUpdaterFacade = TextUpdaterFacade.getInstance();
        operationExecutor = new OperationExecutor();
        operatorStore = OperatorStore.getInstance();
        cacheStore = ProxyCacheStore.getInstance();
        operatorUsedRecently = false;
    }

    public void createOutputForNumericButton(String number) {
        if(operatorUsedRecently)
            textUpdaterFacade.setNumericText(number);
        else
            textUpdaterFacade.updateNumericText(number);

        operatorUsedRecently = false;
    }

    public void createOutputForOperatorButton(String operator) {
        // 1. check if there is numericText. If yes, execute operation declared before and add operator
        //  1.1 If not, change current operator to one passed as parameter
        // 2. update cachedText
        StringBuilder cacheToAdd = new StringBuilder();
        if(!operatorUsedRecently) {
            String currentNumberText = textUpdaterFacade.getNumericText();
            double currentNumber = Double.parseDouble(currentNumberText);
            operationExecutor.executeOperation(currentNumber);
            cacheToAdd.append(currentNumberText);
        }
        CalculatorOperator newOperator = CalculatorOperator.getOperator(operator);
        operatorStore.setCurrent(newOperator);
        textUpdaterFacade.setOperatorText(operator);

        cacheToAdd.append(operator);
        String fullCacheToAdd = cacheToAdd.toString();
        cacheStore.updateCurrent(fullCacheToAdd);
        String fullCache = cacheStore.getCurrent();
        textUpdaterFacade.setCachedText(fullCache);

        operatorUsedRecently = true;
    }
}
