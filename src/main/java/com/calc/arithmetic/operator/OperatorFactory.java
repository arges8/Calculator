package com.calc.arithmetic.operator;

public class OperatorFactory {

    public static CalculatorOperator createOperator(String operator) {
        switch(operator) {
            case "+":
                return new AdditionOperator();
            case "-":
                return new SubtractionOperator();
            case "X":
                return new MultiplicationOperator();
            case "/":
                return new DivisionOperator();
            default:
                return new NoneOperator();
        }
    }
}
