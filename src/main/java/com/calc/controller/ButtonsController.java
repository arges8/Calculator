package com.calc.controller;

import com.calc.helper.CachedTextUpdater;
import com.calc.helper.NumericTextUpdater;
import com.calc.helper.OperatorTextUpdater;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class ButtonsController {

    @FXML
    private Text numericText;

    @FXML
    private Text operatorText;

    @FXML
    private Text cachedText;

    @FXML
    private void initialize() {
        NumericTextUpdater.init(numericText);
        OperatorTextUpdater.init(operatorText);
        CachedTextUpdater.init(cachedText);
    }

    @FXML
    private void handleNumberButton(ActionEvent event) {
        String number = ((Button)event.getSource()).getText();
        NumericTextUpdater numericTextUpdater = NumericTextUpdater.getInstance();
        numericTextUpdater.updateText(number);
    }

    @FXML
    private void handleOperatorButton(ActionEvent event) {
        String operator = ((Button)event.getSource()).getText();

    }
}
