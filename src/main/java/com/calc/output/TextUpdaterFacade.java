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
        String updatedNumberText = cutDecimalFractionIfEqualsZero(numericText);
        this.numericText.setText(updatedNumberText);
    }

    public void updateNumericText(String text) {
        if(!ifDotThenAddItToNumericTextAndReturnTrue(text)) {
            String currentNumericText = numericText.getText();
            String updatedNumberText = "0".equals(currentNumericText) ? text : currentNumericText + text;
            numericText.setText(updatedNumberText);
        }
    }

    public void removeLastDigitFromNumericText() {
        String currentNumericText = numericText.getText();
        if(currentNumericText.length() > 1) {
            String updatedNumberText = currentNumericText.substring(0, currentNumericText.length() - 1);
            numericText.setText(updatedNumberText);
        } else {
            numericText.setText("0");
        }
    }

    public void changeSignOfNumericText() {
        String currentNumericText = numericText.getText();
        if(!"0".equals(currentNumericText)) {
            String updatedNumericText = currentNumericText.contains("-") ?
                    currentNumericText.replaceFirst("-", "") : "-" + currentNumericText;
            numericText.setText(updatedNumericText);
        }
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

    private String cutDecimalFractionIfEqualsZero(String number) {
        if(number != null && number.length() >= 2) {
            if(number.charAt(number.length() - 2) == '.' && number.charAt(number.length() - 1) == '0') {
                String numberWithoutDecimalFraction = number.substring(0, number.length() - 2);
                return numberWithoutDecimalFraction;
            }
        }
        return number;
    }

    private boolean ifDotThenAddItToNumericTextAndReturnTrue(String text) {
        if(".".equals(text)) {
            String currentNumericText = numericText.getText();
            if(!currentNumericText.contains(".")) {
                String finalNumberText = currentNumericText + ".";
                numericText.setText(finalNumberText);
            }
            return true;
        }
        return false;
    }


}
