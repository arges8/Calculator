package com.calc.arithmetic;

public class OperationExecutor {
    private OperatorStore operatorStore;
    private NumberStore numberStore;

    public OperationExecutor() {
        operatorStore = OperatorStore.getInstance();
        numberStore = NumberStore.getInstance();
    }

    public void executeOperation(double secondNumber) {
        CalculatorOperator operator = operatorStore.getCurrent();
        double numberStored = numberStore.getCurrent();
        double resultOfOperation = 0;

        switch(operator) {
            case DIVISION:
                // TODO: catch dividing by 0
                resultOfOperation = Operation.division(numberStored, secondNumber);
                break;
            case MULTIPLICATION:
                resultOfOperation = Operation.multiplication(numberStored, secondNumber);
                break;
            case SUBTRACTION:
                resultOfOperation = Operation.subtraction(numberStored, secondNumber);
                break;
            case ADDITION:
                resultOfOperation = Operation.addition(numberStored, secondNumber);
                break;
            case NONE:
                resultOfOperation = secondNumber;
                break;
        }
        operatorStore.setDefault();
        numberStore.setCurrent(resultOfOperation);
    }

}
