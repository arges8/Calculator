package com.calc.controller;

import com.calc.output.OutputCreatorFacade;
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

    private OutputCreatorFacade outputCreatorFacade;

    @FXML
    private void initialize() {
        outputCreatorFacade = new OutputCreatorFacade(numericText, operatorText, cachedText);
    }

    @FXML
    private void handleNumberButton(ActionEvent event) {
        String number = ((Button)event.getSource()).getText();
        outputCreatorFacade.createOutputForNumericButton(number);
    }

    @FXML
    private void handleOperatorButton(ActionEvent event) {
        String operator = ((Button)event.getSource()).getText();

    }
}
