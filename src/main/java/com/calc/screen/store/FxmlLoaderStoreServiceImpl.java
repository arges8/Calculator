package com.calc.screen.store;

import javafx.fxml.FXMLLoader;

import java.util.HashMap;
import java.util.Map;

public class FxmlLoaderStoreServiceImpl implements FxmlLoaderStoreService {

    private static volatile FxmlLoaderStoreService instance;
    Map<String, FXMLLoader> loaders = new HashMap<>();

    private FxmlLoaderStoreServiceImpl() {

    }

    public static FxmlLoaderStoreService getInstance() {
        if(instance == null) {
            synchronized(FxmlLoaderStoreServiceImpl.class) {
                if(instance == null) {
                    instance = new FxmlLoaderStoreServiceImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public boolean addLoader(String path, FXMLLoader loader) {
        loaders.put(path, loader);

        return true;
    }

    @Override
    public FXMLLoader getLoader(String path) {
        return loaders.get(path);
    }
}
