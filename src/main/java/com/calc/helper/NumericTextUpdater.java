package com.calc.helper;

import javafx.scene.text.Text;

public class NumericTextUpdater implements OutputCreator {
    private static volatile NumericTextUpdater instance;
    private Text numericText;

    private NumericTextUpdater(Text numericText) {
        this.numericText = numericText;
    }

    public static NumericTextUpdater getInstance() throws AssertionError {
        if(instance != null)
            return instance;

        throw new AssertionError("Instance not initialized. Use init() to create one.");
    }

    public static NumericTextUpdater init(Text text) throws AssertionError {
        if(instance == null) {
            synchronized (NumericTextUpdater.class) {
                if(instance == null) {
                    instance = new NumericTextUpdater(text);
                    return  instance;
                }
            }
        }
        throw new AssertionError("Instance already initialized");
    }

    @Override
    public void updateText(String text) {
        String updatedNumberText = numericText.getText() + text;
        numericText.setText(updatedNumberText);
    }


}
