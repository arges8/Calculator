package com.calc.output;

public class NumericTextUpdater implements OutputTextUpdater {
    private TextUpdaterFacade textUpdaterFacade;

    public NumericTextUpdater() {
        textUpdaterFacade = TextUpdaterFacade.getInstance();
    }


    @Override
    public void updateText(String text) {
        String currentNumericText = textUpdaterFacade.getNumericText();
        String updatedNumberText;
        if(currentNumericText.equals("0")) {
            updatedNumberText = text;
        } else {
            updatedNumberText = textUpdaterFacade.getNumericText() + text;
        }

        textUpdaterFacade.setNumericText(updatedNumberText);
    }


}
