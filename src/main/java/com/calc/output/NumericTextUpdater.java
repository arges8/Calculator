package com.calc.output;

import javafx.scene.text.Text;

public class NumericTextUpdater implements OutputTextUpdater {
    private static volatile NumericTextUpdater instance;
    private Text numericText;

    private NumericTextUpdater(Text numericText) {
        this.numericText = numericText;
    }

    public static NumericTextUpdater getInstance() throws TextUpdaterExistsException {
        if(instance != null)
            return instance;

        throw new TextUpdaterExistsException(false, TextUpdaterType.NUMERIC);
    }

    public static NumericTextUpdater init(Text text) throws TextUpdaterExistsException {
        if(instance == null) {
            synchronized (NumericTextUpdater.class) {
                if(instance == null) {
                    instance = new NumericTextUpdater(text);
                    return  instance;
                }
            }
        }
        throw new TextUpdaterExistsException(true, TextUpdaterType.NUMERIC);
    }

    @Override
    public void updateText(String text) {
        String updatedNumberText = numericText.getText() + text;
        numericText.setText(updatedNumberText);
    }


}
