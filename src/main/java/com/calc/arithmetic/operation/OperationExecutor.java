package com.calc.arithmetic.operation;

import com.calc.arithmetic.operator.CalculatorOperator;

import java.util.LinkedList;

class OperationExecutor {

    static double executeOperation(double numberStored, double secondNumber, CalculatorOperator operator) {
        LinkedList<Double> nums = new LinkedList<>();
        nums.add(numberStored);
        nums.add(secondNumber);

        double resultOfOperation = operator.calculate(nums);

        return resultOfOperation;
    }

}
