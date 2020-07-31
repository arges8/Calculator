package com.calc.output;

import com.calc.arithmetic.operation.OperationWrapper;

public class CalculatorOutputFacade {
    private CalculatorTextUpdaterFacade calculatorTextUpdaterFacade = CalculatorTextUpdaterFacade.getInstance();
    private OperationWrapper operationWrapper = new OperationWrapper();
    private boolean operatorUsedRecently;

    public void createOutputForNumericButton(String number) {
        if(operatorUsedRecently)
            calculatorTextUpdaterFacade.setNumericText(number);
        else
            calculatorTextUpdaterFacade.updateNumericText(number);

        operatorUsedRecently = false;
    }

    public void createOutputForOperatorButton(String operator) {
        String cache;
        if(!operatorUsedRecently) {
            String currentNumberText = calculatorTextUpdaterFacade.getNumericText();
            cache = operationWrapper.executeOperationAndUpdateAllStores(currentNumberText, operator);
        } else {
            cache = operationWrapper.updateOperatorAndCacheStores(operator);
        }

        if(cache.length() > 0) {
            calculatorTextUpdaterFacade.setOperatorText(operator);
            calculatorTextUpdaterFacade.setCachedText(cache);
        }

        operatorUsedRecently = true;
    }

    public void createOutputForEqualsButton() {
        createOutputForOperatorButton("");
        String result = operationWrapper.setAllStoresDefaultAndSaveCacheTextInHistory();
        calculatorTextUpdaterFacade.setCachedText("");
        calculatorTextUpdaterFacade.setOperatorText("");
        calculatorTextUpdaterFacade.setNumericText(result);

        operatorUsedRecently = true;
    }

    public void createOutputForDotButton() {
        calculatorTextUpdaterFacade.updateNumericText(".");
    }

    public void createOutputForBackButton() {
        if(!operatorUsedRecently)
            calculatorTextUpdaterFacade.removeLastDigitFromNumericText();
    }

    public void createOutputForClearButton() {
        operationWrapper.setAllStoresDefault();
        calculatorTextUpdaterFacade.setNumericText("0");
        calculatorTextUpdaterFacade.setOperatorText("");
        calculatorTextUpdaterFacade.setCachedText("");
    }

    public void createOutputForPlusMinusButton() {
        if(!operatorUsedRecently)
            calculatorTextUpdaterFacade.changeSignOfNumericText();
    }

    public void createOutputForHistoryButton() {
        // TODO
    }
}
