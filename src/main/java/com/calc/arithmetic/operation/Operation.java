package com.calc.arithmetic.operation;

class Operation {
    static double division(double a, double b) throws ArithmeticException {
        if(b != 0)
            return a/b;
        throw new ArithmeticException("Dividing by 0");
    }

    static double multiplication(double a, double b) {
        return a*b;
    }

    static double subtraction(double a, double b) {
        return a-b;
    }

    static double addition(double a, double b) {
        return a+b;
    }
}
