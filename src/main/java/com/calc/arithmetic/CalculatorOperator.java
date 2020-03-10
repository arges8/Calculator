package com.calc.arithmetic;

public enum CalculatorOperator {
    DIVISION, MULTIPLICATION, SUBTRACTION, ADDITION, NONE;

    public static CalculatorOperator getOperator(String operator) {
        switch(operator) {
            case "/":
                return DIVISION;
            case "X":
                return MULTIPLICATION;
            case "-":
                return SUBTRACTION;
            case "+":
                return ADDITION;
            default:
                return NONE;
        }

    }
}
