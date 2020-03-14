package com.calc.output;

import com.calc.arithmetic.operation.OperationWrapper;

public class OutputCreatorFacade {
    private TextUpdaterFacade textUpdaterFacade;
    private OperationWrapper operationWrapper;
    private boolean operatorUsedRecently;

    public OutputCreatorFacade() {
        textUpdaterFacade = TextUpdaterFacade.getInstance();
        operationWrapper = new OperationWrapper();
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
        String cache;
        if(!operatorUsedRecently) {
            String currentNumberText = textUpdaterFacade.getNumericText();
            cache = operationWrapper.executeOperationAndUpdateAllStores(currentNumberText, operator);
        } else {
            cache = operationWrapper.updateOperatorAndCacheStores(operator);
        }

        if(cache.length() > 0) {
            textUpdaterFacade.setOperatorText(operator);
            textUpdaterFacade.setCachedText(cache);
        }

        operatorUsedRecently = true;
    }

    public void createOutputForEqualsButton() {
        createOutputForOperatorButton("");
        String result = operationWrapper.setAllStoresDefaultAndSaveCacheTextInHistory();
        textUpdaterFacade.setCachedText("");
        textUpdaterFacade.setOperatorText("");
        textUpdaterFacade.setNumericText(result);

        operatorUsedRecently = true;
    }

    public void createOutputForDotButton() {
        textUpdaterFacade.updateNumericText(".");
    }

    public void createOutputForClearButton() {
        operationWrapper.setAllStoresDefault();
        textUpdaterFacade.setNumericText("0");
        textUpdaterFacade.setOperatorText("");
        textUpdaterFacade.setCachedText("");
    }

    public void createOutputForPlusMinusButton() {

    }
}
