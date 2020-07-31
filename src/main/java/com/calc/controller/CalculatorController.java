package com.calc.controller;

import com.calc.output.HistoryOutputFacade;
import com.calc.screen.ScreenChangerService;
import com.calc.output.CalculatorOutputFacade;
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

    private CalculatorOutputFacade calculatorOutputFacade;

    private HistoryOutputFacade historyOutputFacade;

    public void setCalculatorOutputFacade(CalculatorOutputFacade calculatorOutputFacade) {
        this.calculatorOutputFacade = calculatorOutputFacade;
    }

    public void setHistoryOutputFacade(HistoryOutputFacade historyOutputFacade) {
        this.historyOutputFacade = historyOutputFacade;
    }

    @FXML
    void handleNumberButton(ActionEvent event) {
        String number = ((Button)event.getSource()).getText();
        calculatorOutputFacade.createOutputForNumericButton(number);
    }

    @FXML
    void handleOperatorButton(ActionEvent event) {
        String operator = ((Button)event.getSource()).getText();
        calculatorOutputFacade.createOutputForOperatorButton(operator);
    }

    @FXML
    void handleEqualsButton(ActionEvent event) {
        calculatorOutputFacade.createOutputForEqualsButton();
    }

    @FXML
    void handleDotButton(ActionEvent event) {
        calculatorOutputFacade.createOutputForDotButton();
    }

    @FXML
    void handleBackButton(ActionEvent event) {
        calculatorOutputFacade.createOutputForBackButton();
    }

    @FXML
    void handleClearButton(ActionEvent event) {
        calculatorOutputFacade.createOutputForClearButton();
    }

    @FXML
    void handlePlusMinusButton(ActionEvent event) {
        calculatorOutputFacade.createOutputForPlusMinusButton();
    }

    @FXML
    void handleHistoryButton(ActionEvent event) {
        historyOutputFacade.createOutputForHistoryButton();
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