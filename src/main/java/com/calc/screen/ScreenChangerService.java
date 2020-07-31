package com.calc.screen;

import com.calc.controller.Controller;
import com.calc.screen.store.FxmlLoaderStoreService;
import com.calc.screen.store.FxmlLoaderStoreServiceImpl;
import com.calc.screen.store.ScreenStoreService;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import java.io.IOException;
import java.util.NoSuchElementException;

public class ScreenChangerService extends StackPane {
    private ScreenStoreService screenStore;
    private FxmlLoaderStoreService loaderStore = FxmlLoaderStoreServiceImpl.getInstance();

    public ScreenChangerService(ScreenStoreService screenStore) {
        this.screenStore = screenStore;
    }

    public void loadScreen(String fxmlFilePath) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFilePath));
        Parent loadedScreen = loader.load();
        Controller controller = loader.getController();
        controller.setScreenChanger(this);
        loaderStore.addLoader(fxmlFilePath, loader);
        screenStore.addScreen(fxmlFilePath, loadedScreen);
    }

    public void setScreen(String fxmlFilePath) {
        if(screenStore.getScreen(fxmlFilePath) != null) {
            final DoubleProperty opacity = opacityProperty();
            if(!getChildren().isEmpty()) {
                changeDisplayedScreenAndRunAnimations(fxmlFilePath, opacity);
            } else {
                displayFirstScreenAndRunAnimations(fxmlFilePath, opacity);
            }
        } else {
            throw new NoSuchElementException("There is no screen loaded for path: " + fxmlFilePath);
        }
    }

    private void changeDisplayedScreenAndRunAnimations(String fxmlFilePath, DoubleProperty opacity) {
        Timeline fade = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(opacity, 1.0)),
                new KeyFrame(new Duration(100), event -> {
                    getChildren().remove(0);
                    getChildren().add(screenStore.getScreen(fxmlFilePath));
                    Timeline fadeIn = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                            new KeyFrame(new Duration(100), new KeyValue(opacity, 1.0)));
                    fadeIn.play();
                }));
        fade.play();
    }

    private void displayFirstScreenAndRunAnimations(String fxmlFilePath, DoubleProperty opacity) {
        setOpacity(0.0);
        getChildren().add(screenStore.getScreen(fxmlFilePath));
        Timeline fade = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(opacity, 1.0)),
                new KeyFrame(new Duration(100), new KeyValue(opacity, 1.0)));
        fade.play();
    }
}
