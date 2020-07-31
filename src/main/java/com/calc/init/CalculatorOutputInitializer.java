package com.calc.init;

import com.calc.controller.CalculatorController;
import com.calc.output.CalculatorOutputFacade;
import com.calc.output.CalculatorTextUpdaterFacade;
import com.calc.screen.store.FxmlLoaderStoreService;
import com.calc.screen.store.FxmlLoaderStoreServiceImpl;
import javafx.fxml.FXMLLoader;

import static com.calc.constant.FxmlFilesPathsStore.CALCULATOR_FXML_FILE_PATH;

public class CalculatorOutputInitializer implements Initializer {
    FxmlLoaderStoreService loaderService = FxmlLoaderStoreServiceImpl.getInstance();

    @Override
    public boolean initialize() {
        FXMLLoader loader = loaderService.getLoader(CALCULATOR_FXML_FILE_PATH);
        CalculatorController controller = (CalculatorController)loader.getController();

        CalculatorTextUpdaterFacade.init(controller.getNumericText(), controller.getOperatorText(), controller.getCachedText())
                .setNumericText("0");

        controller.setCalculatorOutputFacade(new CalculatorOutputFacade());

        return true;
    }
}
