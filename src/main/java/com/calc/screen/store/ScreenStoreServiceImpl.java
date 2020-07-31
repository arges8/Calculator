package com.calc.screen.store;

import javafx.scene.Node;

import java.util.HashMap;
import java.util.Map;

public class ScreenStoreServiceImpl implements ScreenStoreService{
    Map<String, Node> screens = new HashMap<>();

    public void addScreen(String filePath, Node screen) {
        screens.put(filePath, screen);
    }

    public Node getScreen(String filePath) {
        return screens.get(filePath);
    }
}
