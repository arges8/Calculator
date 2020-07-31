package com.calc.controller;

import com.calc.screen.ScreenChangerService;
import com.calc.output.OutputCreatorFacade;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

import static com.calc.constant.FxmlFilesPathsStore.HISTORY_FXML_FILE_PATH;

public class CalculatorController implements Controller{

    @FXML
    private Text numericText;

    @FXML
    private Text operatorText;

    @FXML
    private Text cachedText;

    private ScreenChangerService screenChanger;

    private OutputCreatorFacade outputCreatorFacade;

    public void setOutputCreatorFacade(OutputCreatorFacade outputCreatorFacade) {
        this.outputCreatorFacade = outputCreatorFacade;
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

    @FXML
    void handleHistoryButton(ActionEvent event) {
        outputCreatorFacade.createOutputForHistoryButton();
        screenChanger.setScreen(HISTORY_FXML_FILE_PATH);
    }

    @Override
    public void setScreenChanger(ScreenChangerService screenChanger) {
        this.screenChanger = screenChanger;
    }

    public Text getNumericText() {
        return numericText;
    }

    public Text getOperatorText() {
        return operatorText;
    }

    public Text getCachedText() {
        return cachedText;
    }
}