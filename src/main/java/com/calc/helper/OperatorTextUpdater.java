package com.calc.helper;

import javafx.scene.text.Text;

public class OperatorTextUpdater implements OutputCreator {
    private static volatile OperatorTextUpdater instance;
    private Text operatorText;

    private OperatorTextUpdater(Text operatorText) {
        this.operatorText = operatorText;
    }

    public static OperatorTextUpdater getInstance() {
        if(instance != null)
            return instance;

        throw new AssertionError("Instance not initialized. Use init() to create one.");
    }

    public static OperatorTextUpdater init(Text text) {
        if(instance == null) {
            synchronized (OperatorTextUpdater.class) {
                if(instance == null) {
                    instance = new OperatorTextUpdater(text);
                    return instance;
                }
            }
        }
        throw new AssertionError("Instance already initialized");
    }

    @Override
    public void updateText(String text) {
        operatorText.setText(text);
    }
}
