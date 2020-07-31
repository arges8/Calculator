package com.calc.screen.store;

import javafx.scene.Node;

public interface ScreenStoreService {
    void addScreen(String filePath, Node screen);
    Node getScreen(String filePath);
}
