package com.calc;
import com.calc.init.Initializer;
import com.calc.init.OutputInitializer;
import com.calc.screen.ScreenChangerService;
import com.calc.screen.store.ScreenStoreServiceImpl;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static com.calc.constant.FxmlFilesPathsStore.CALCULATOR_FXML_FILE_PATH;
import static com.calc.constant.FxmlFilesPathsStore.HISTORY_FXML_FILE_PATH;

public class CalculatorApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        ScreenChangerService screenChanger = new ScreenChangerService(new ScreenStoreServiceImpl());
        screenChanger.loadScreen(CALCULATOR_FXML_FILE_PATH);
        screenChanger.loadScreen(HISTORY_FXML_FILE_PATH);
        Initializer initializer = new OutputInitializer();
        initializer.initialize();
        screenChanger.setScreen(CALCULATOR_FXML_FILE_PATH);

        Group root = new Group();
        root.getChildren().addAll(screenChanger);
        stage.setTitle("Calculator");
        stage.setScene(new Scene(root));
        stage.resizableProperty().setValue(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
