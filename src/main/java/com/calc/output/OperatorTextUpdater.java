package com.calc.output;

public class OperatorTextUpdater implements OutputTextUpdater {
    private TextUpdaterFacade textUpdaterFacade;

    public OperatorTextUpdater() {
        textUpdaterFacade = TextUpdaterFacade.getInstance();
    }

    @Override
    public void updateText(String text) {
        textUpdaterFacade.setOperatorText(text);
    }
}
