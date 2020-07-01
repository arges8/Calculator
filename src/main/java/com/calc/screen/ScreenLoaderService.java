package com.calc.screen;

import com.calc.controller.Controller;
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

public class ScreenLoaderService extends StackPane {
    // this service is responsible for switching between the screens (calculator and history)

    private ScreenStoreService screenStore;

    public ScreenLoaderService(ScreenStoreService screenStore) {
        this.screenStore = screenStore;
    }

    public void loadScreen(String fxmlFilePath) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFilePath));
        Parent loadedScreen = loader.load();
        Controller controller = loader.getController();
        controller.setScreenLoader(this);
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
                new KeyFrame(new Duration(1000), event -> {
                    getChildren().remove(0);
                    getChildren().add(screenStore.getScreen(fxmlFilePath));
                    Timeline fadeIn = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                            new KeyFrame(new Duration(800), new KeyValue(opacity, 1.0)));
                    fadeIn.play();
                }));
        fade.play();
    }

    private void displayFirstScreenAndRunAnimations(String fxmlFilePath, DoubleProperty opacity) {
        setOpacity(0.0);
        getChildren().add(screenStore.getScreen(fxmlFilePath));
        Timeline fade = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(opacity, 1.0)),
                new KeyFrame(new Duration(1000), new KeyValue(opacity, 1.0)));
        fade.play();
    }
}
