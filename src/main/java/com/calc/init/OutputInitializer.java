package com.calc.init;

import com.calc.controller.CalculatorController;
import com.calc.output.OutputCreatorFacade;
import com.calc.output.TextUpdaterFacade;
import com.calc.screen.store.FxmlLoaderStoreService;
import com.calc.screen.store.FxmlLoaderStoreServiceImpl;
import javafx.fxml.FXMLLoader;

import static com.calc.constant.FxmlFilesPathsStore.CALCULATOR_FXML_FILE_PATH;

public class OutputInitializer implements Initializer {

    @Override
    public boolean initialize() {
        FxmlLoaderStoreService loaderService = FxmlLoaderStoreServiceImpl.getInstance();
        FXMLLoader loader = loaderService.getLoader(CALCULATOR_FXML_FILE_PATH);
        CalculatorController controller = (CalculatorController)loader.getController();

        TextUpdaterFacade.init(controller.getNumericText(), controller.getOperatorText(), controller.getCachedText())
                .setNumericText("0");

        controller.setOutputCreatorFacade(new OutputCreatorFacade());

        return true;
    }
}
