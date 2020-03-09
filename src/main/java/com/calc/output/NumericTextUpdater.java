package com.calc.output;

public class NumericTextUpdater implements OutputTextUpdater {
    private TextUpdaterFacade textUpdaterFacade;

    public NumericTextUpdater() {
        textUpdaterFacade = TextUpdaterFacade.getInstance();
    }


    @Override
    public void updateText(String text) {
        String updatedNumberText = textUpdaterFacade.getNumericText() + text;
        textUpdaterFacade.setNumericText(updatedNumberText);
    }


}
