package com.calc.arithmetic;

public enum CalculatorOperator {
    DIVISION, MULTIPLICATION, ADDITION, SUBTRACTION, NONE;

    public static CalculatorOperator getOperator(String operator) {
        switch(operator) {
            case "/":
                return DIVISION;
            case "X":
                return MULTIPLICATION;
            case "+":
                return ADDITION;
            case "-":
                return SUBTRACTION;
            case "":
                return NONE;
            default:
                throw new IllegalArgumentException("Wrong operator");
        }

    }
}
