package com.calc.arithmetic;

public enum CalculatorOperator {
    DIVISION, MULTIPLICATION, ADDITION, SUBTRACTION;

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
            default:
                throw new IllegalArgumentException("Wrong operator");
        }

    }
}
