package com.calc.output;

import javafx.scene.text.Text;

public class OperatorTextUpdater implements OutputTextUpdater {
    private static volatile OperatorTextUpdater instance;
    private Text operatorText;

    private OperatorTextUpdater(Text operatorText) {
        this.operatorText = operatorText;
    }

    public static OperatorTextUpdater getInstance() throws TextUpdaterExistsException {
        if(instance != null)
            return instance;

        throw new TextUpdaterExistsException(false, TextUpdaterType.OPERATOR);
    }

    public static OperatorTextUpdater init(Text text) throws TextUpdaterExistsException {
        if(instance == null) {
            synchronized (OperatorTextUpdater.class) {
                if(instance == null) {
                    instance = new OperatorTextUpdater(text);
                    return instance;
                }
            }
        }
        throw new TextUpdaterExistsException(true, TextUpdaterType.OPERATOR);
    }

    @Override
    public void updateText(String text) {
        operatorText.setText(text);
    }
}
