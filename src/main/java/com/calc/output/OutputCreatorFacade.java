package com.calc.output;

import com.calc.arithmetic.CalculatorOperator;
import com.calc.arithmetic.OperationExecutor;
import com.calc.arithmetic.OperatorStore;

public class OutputCreatorFacade {
    private TextUpdaterFacade textUpdaterFacade;
    private NumericTextUpdater numericTextUpdater;
    private OperatorTextUpdater operatorTextUpdater;
    private CachedTextUpdater cachedTextUpdater;
    private OperationExecutor operationExecutor;
    private OperatorStore operatorStore;

    public OutputCreatorFacade() {
        textUpdaterFacade = TextUpdaterFacade.getInstance();
        numericTextUpdater = new NumericTextUpdater();
        operatorTextUpdater = new OperatorTextUpdater();
        cachedTextUpdater = new CachedTextUpdater();
        operationExecutor = new OperationExecutor();
        operatorStore = OperatorStore.getInstance();
    }

    public void createOutputForNumericButton(String number) {
        numericTextUpdater.updateText(number);
    }

    public void createOutputForOperatorButton(String operator) {
        // 1. check if there is numericText. If yes, execute operation declared before and add operator
        //  1.1 If not, change current operator to one passed as parameter
        // 2. update cachedText
        String currentNumberText = textUpdaterFacade.getNumericText();
        if(!currentNumberText.equals("0")) {
            double currentNumber = Double.parseDouble(currentNumberText);
            operationExecutor.executeOperation(currentNumber);
            textUpdaterFacade.setNumericText("0");
        }
        CalculatorOperator newOperator = CalculatorOperator.getOperator(operator);
        operatorStore.setCurrent(newOperator);
        operatorTextUpdater.updateText(operator);
    }
}
