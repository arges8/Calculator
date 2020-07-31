package com.calc.controller;

import com.calc.screen.ScreenChangerService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import static com.calc.constant.FxmlFilesPathsStore.CALCULATOR_FXML_FILE_PATH;

public class HistoryController implements Controller{

    @FXML
    private TextArea textArea;

    private ScreenChangerService screenChanger;

    @Override
    public void setScreenChanger(ScreenChangerService screenChanger) {
        this.screenChanger = screenChanger;
    }

    @FXML
    void handleCloseButton(ActionEvent event) {
        screenChanger.setScreen(CALCULATOR_FXML_FILE_PATH);
    }

    public TextArea getTextArea() {
        return textArea;
    }
}
