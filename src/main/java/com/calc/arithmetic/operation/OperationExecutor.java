package com.calc.arithmetic.operation;

import com.calc.arithmetic.CalculatorOperator;

class OperationExecutor {

    static double executeOperation(double numberStored, double secondNumber, CalculatorOperator operator) {
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

        return resultOfOperation;
    }

}
