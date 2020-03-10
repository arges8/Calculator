package com.calc.output;

import com.calc.wrapper.OperationWrapper;

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
        textUpdaterFacade.setOperatorText(operator);
        textUpdaterFacade.setCachedText(cache);

        operatorUsedRecently = true;
    }

    public void createOutputForEqualsButton() {

    }
}
