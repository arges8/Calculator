package com.calc.output;

import java.util.LinkedList;
import java.util.List;

public class CachedTextUpdater implements OutputTextUpdater {
    private TextUpdaterFacade textUpdaterFacade;
    private StringBuilder currentEquation;
    private List<String> equations;

    public CachedTextUpdater() {
        textUpdaterFacade = TextUpdaterFacade.getInstance();
        equations = new LinkedList<>();
        currentEquation = new StringBuilder();
    }

    @Override
    public void updateText(String text) {
        if(text.contains("=")) {
            String cachedTextWithoutEqualsOperator = text.replaceFirst("=", "");
            currentEquation.append(cachedTextWithoutEqualsOperator);
            String fullEquation = currentEquation.toString();
            currentEquation = new StringBuilder();
            equations.add(fullEquation);
            textUpdaterFacade.setCachedText("");
        } else {
            currentEquation.append(text);
            String currentEquationToShow = currentEquation.toString();
            textUpdaterFacade.setCachedText(currentEquationToShow);
        }
    }
}
