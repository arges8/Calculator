package com.calc.output;

import javafx.scene.text.Text;

import java.util.LinkedList;
import java.util.List;

public class CachedTextUpdater implements OutputTextUpdater {
    private static volatile CachedTextUpdater instance;
    private Text cachedText;
    private StringBuilder currentEquation;
    private List<String> equations;

    private CachedTextUpdater(Text cachedText) {
        this.cachedText = cachedText;
        equations = new LinkedList<>();
        currentEquation = new StringBuilder();
    }

    public static CachedTextUpdater getInstance() throws TextUpdaterExistsException {
        if(instance != null)
            return instance;

        throw new TextUpdaterExistsException(false, TextUpdaterType.CACHED);
    }

    public static CachedTextUpdater init(Text text) throws TextUpdaterExistsException {
        if(instance == null) {
            synchronized (CachedTextUpdater.class) {
                if(instance == null) {
                    instance = new CachedTextUpdater(text);
                    return instance;
                }
            }
        }
        throw new TextUpdaterExistsException(true, TextUpdaterType.CACHED);
    }

    @Override
    public void updateText(String text) {
        if(text.contains("=")) {
            String cachedTextWithoutEqualsOperator = text.replaceFirst("=", "");
            currentEquation.append(cachedTextWithoutEqualsOperator);
            String fullEquation = currentEquation.toString();
            currentEquation = new StringBuilder();
            equations.add(fullEquation);
            cachedText.setText("");
        } else {
            currentEquation.append(text);
            String currentEquationToShow = currentEquation.toString();
            cachedText.setText(currentEquationToShow);
        }
    }
}
