package com.calc.output;

import javafx.scene.text.Text;

public class OutputCreatorFacade {
    private NumericTextUpdater numericTextUpdater;
    private OperatorTextUpdater operatorTextUpdater;
    private CachedTextUpdater cachedTextUpdater;

    public OutputCreatorFacade(Text numericText, Text operatorText, Text cachedText) {
        initializeTextUpdaters(numericText, operatorText, cachedText);
    }

    private void initializeTextUpdaters(Text numericText, Text operatorText, Text cachedText) {
        try {
            numericTextUpdater = NumericTextUpdater.init(numericText);
            operatorTextUpdater = OperatorTextUpdater.init(operatorText);
            cachedTextUpdater = CachedTextUpdater.init(cachedText);
        } catch (TextUpdaterExistsException e) {
            e.printStackTrace();
        }
    }

    public void createOutputForNumericButton(String number) {
        numericTextUpdater.updateText(number);
    }

    public void createOutputForOperatorButton(String operator) {
        // 1. check if there is numericText. If yes, execute operation declared before and add operator
        //  1.1 If not, change current operator to one passed as parameter
        // 2. update cachedText

    }
}
