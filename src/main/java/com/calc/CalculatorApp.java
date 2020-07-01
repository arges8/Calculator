package com.calc;
import com.calc.screen.ScreenLoaderService;
import com.calc.screen.ScreenStoreServiceImpl;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static com.calc.constant.FxmlFilesPathsStore.CALCULATOR_FXML_FILE_PATH;
import static com.calc.constant.FxmlFilesPathsStore.HISTORY_FXML_FILE_PATH;

public class CalculatorApp extends Application {

//    private static final String CALCULATOR_FXML_FILE_PATH = "/template/calculatorapp.fxml";
//    private static final String HISTORY_FXML_FILE_PATH = "/template/history.fxml";

    @Override
    public void start(Stage stage) throws Exception {
        ScreenLoaderService screenLoader = new ScreenLoaderService(new ScreenStoreServiceImpl());
        screenLoader.loadScreen(CALCULATOR_FXML_FILE_PATH);
        screenLoader.loadScreen(HISTORY_FXML_FILE_PATH);
        screenLoader.setScreen(CALCULATOR_FXML_FILE_PATH);


        //Parent root = FXMLLoader.load(getClass().getResource("/template/calculatorapp.fxml"));
        Group root = new Group();
        root.getChildren().addAll(screenLoader);
        stage.setTitle("Calculator");
        stage.setScene(new Scene(root));
        stage.resizableProperty().setValue(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
