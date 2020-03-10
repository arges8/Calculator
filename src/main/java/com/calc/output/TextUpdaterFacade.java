package com.calc.output;

import javafx.scene.text.Text;

public class TextUpdaterFacade {
    private static volatile TextUpdaterFacade instance;
    private Text numericText;
    private Text operatorText;
    private Text cachedText;

    private TextUpdaterFacade(Text numericText, Text operatorText, Text cachedText) {
        this.numericText = numericText;
        this.operatorText = operatorText;
        this.cachedText = cachedText;
    }

    public static TextUpdaterFacade getInstance() throws AssertionError {
        if(instance != null)
            return instance;

        throw new AssertionError("Instance of TextUpdaterFacade is not created");
    }

    public static TextUpdaterFacade init(Text numericText, Text operatorText, Text cachedText) throws AssertionError {
        if(instance == null) {
            synchronized (TextUpdaterFacade.class) {
                if(instance == null) {
                    instance = new TextUpdaterFacade(numericText, operatorText, cachedText);
                    return instance;
                }
            }
        }
        throw new AssertionError("Instance of TextUpdaterFacade is already created");
    }

    public String getNumericText() {
        return numericText.getText();
    }

    public void setNumericText(String numericText) {
        this.numericText.setText(numericText);
    }

    public void updateNumericText(String text) {
        String currentNumericText = numericText.getText();
        String updatedNumberText = "0".equals(currentNumericText) ? text : currentNumericText + text;
        numericText.setText(updatedNumberText);
    }

    public String getOperatorText() {
        return operatorText.getText();
    }

    public void setOperatorText(String operatorText) {
        this.operatorText.setText(operatorText);
    }

    public String getCachedText() {
        return cachedText.getText();
    }

    public void setCachedText(String cachedText) {
        this.cachedText.setText(cachedText);
    }


}
