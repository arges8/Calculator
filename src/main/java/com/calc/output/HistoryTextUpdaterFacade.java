package com.calc.output;

import javafx.scene.control.TextArea;

import java.util.List;

public class HistoryTextUpdaterFacade {
    private static volatile HistoryTextUpdaterFacade instance;
    private TextArea textArea;

    private HistoryTextUpdaterFacade(TextArea textArea) {
        this.textArea = textArea;
    }

    public static HistoryTextUpdaterFacade getInstance() {
        if(instance != null)
            return instance;

        throw new AssertionError("Instance of HistoryTextUpdaterFacade is not created");
    }

    public static HistoryTextUpdaterFacade init(TextArea textArea) {
        if(instance == null) {
            instance = new HistoryTextUpdaterFacade(textArea);
            return instance;
        }
        throw new AssertionError("Instance of HistoryTextUpdaterFacade is already created");
    }

    public void updateTextArea(List<String> cachedEquations) {
        textArea.clear();
        for(String equation : cachedEquations)
            textArea.appendText(equation);
    }
}
