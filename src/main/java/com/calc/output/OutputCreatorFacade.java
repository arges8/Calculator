package com.calc.output;

import javafx.scene.text.Text;

public class OutputCreatorFacade {
    private TextUpdaterFacade textUpdaterFacade;
    private NumericTextUpdater numericTextUpdater;
    private OperatorTextUpdater operatorTextUpdater;
    private CachedTextUpdater cachedTextUpdater;

    public OutputCreatorFacade(Text numericText, Text operatorText, Text cachedText) {
        textUpdaterFacade = TextUpdaterFacade.init(numericText, operatorText, cachedText);
        numericTextUpdater = new NumericTextUpdater();
        operatorTextUpdater = new OperatorTextUpdater();
        cachedTextUpdater = new CachedTextUpdater();
    }

    public void createOutputForNumericButton(String number) {
        numericTextUpdater.updateText(number);
    }

    public void createOutputForOperatorButton(String operator) {
        // 1. check if there is numericText. If yes, execute operation declared before and add operator
        //  1.1 If not, change current operator to one passed as parameter
        // 2. update cachedText
        String currentNumber = textUpdaterFacade.getNumericText();
        if(currentNumber.length() > 0) {

        }

    }
}
