package com.calc.init;

import com.calc.controller.CalculatorController;
import com.calc.controller.HistoryController;
import com.calc.output.HistoryOutputFacade;
import com.calc.output.HistoryTextUpdaterFacade;
import com.calc.screen.store.FxmlLoaderStoreService;
import com.calc.screen.store.FxmlLoaderStoreServiceImpl;
import javafx.fxml.FXMLLoader;

import static com.calc.constant.FxmlFilesPathsStore.HISTORY_FXML_FILE_PATH;
import static com.calc.constant.FxmlFilesPathsStore.CALCULATOR_FXML_FILE_PATH;

public class HistoryOutputInitializer implements Initializer {

    FxmlLoaderStoreService loaderService = FxmlLoaderStoreServiceImpl.getInstance();

    @Override
    public boolean initialize() {
        FXMLLoader loader = loaderService.getLoader(HISTORY_FXML_FILE_PATH);
        HistoryController controller = (HistoryController)loader.getController();

        HistoryTextUpdaterFacade.init(controller.getTextArea());
        setHistoryOutputFacadeInCalculatorFacade();
        return true;
    }

    private void setHistoryOutputFacadeInCalculatorFacade() {
        FXMLLoader loader = loaderService.getLoader(CALCULATOR_FXML_FILE_PATH);
        CalculatorController controller = (CalculatorController)loader.getController();
        controller.setHistoryOutputFacade(new HistoryOutputFacade());
    }
}
