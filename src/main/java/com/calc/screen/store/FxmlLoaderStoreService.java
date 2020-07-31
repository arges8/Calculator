package com.calc.screen.store;

import javafx.fxml.FXMLLoader;

public interface FxmlLoaderStoreService {
    boolean addLoader(String path, FXMLLoader loader);
    FXMLLoader getLoader(String path);
}
