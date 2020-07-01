package com.calc.controller;

import com.calc.screen.ScreenLoaderService;
import com.calc.output.OutputCreatorFacade;
import com.calc.output.TextUpdaterFacade;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class ButtonsController implements Controller{

    @FXML
    private Text numericText;

    @FXML
    private Text operatorText;

    @FXML
    private Text cachedText;

    private ScreenLoaderService screenLoaderService;

    private OutputCreatorFacade outputCreatorFacade;

    @FXML
    private void initialize() {
        TextUpdaterFacade.init(numericText, operatorText, cachedText).setNumericText("0");
        outputCreatorFacade = new OutputCreatorFacade();
    }

    @FXML
    void handleNumberButton(ActionEvent event) {
        String number = ((Button)event.getSource()).getText();
        outputCreatorFacade.createOutputForNumericButton(number);
    }

    @FXML
    void handleOperatorButton(ActionEvent event) {
        String operator = ((Button)event.getSource()).getText();
        outputCreatorFacade.createOutputForOperatorButton(operator);
    }

    @FXML
    void handleEqualsButton(ActionEvent event) {
        outputCreatorFacade.createOutputForEqualsButton();
    }

    @FXML
    void handleDotButton(ActionEvent event) {
        outputCreatorFacade.createOutputForDotButton();
    }

    @FXML
    void handleBackButton(ActionEvent event) {
        outputCreatorFacade.createOutputForBackButton();
    }

    @FXML
    void handleClearButton(ActionEvent event) {
        outputCreatorFacade.createOutputForClearButton();
    }

    @FXML
    void handlePlusMinusButton(ActionEvent event) {
        outputCreatorFacade.createOutputForPlusMinusButton();
    }

    void handleHistoryButton(ActionEvent event) {

    }

    @Override
    public void setScreenLoader(ScreenLoaderService screenLoader) {
        this.screenLoaderService = screenLoader;
    }
}