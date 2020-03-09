package com.calc.arithmetic;

class Operation {
    public static double division(double a, double b) throws ArithmeticException {
        if(b != 0)
            return a/b;
        throw new ArithmeticException("Dividing by 0");
    }

    public static double multiplication(double a, double b) {
        return a*b;
    }

    public static double subtraction(double a, double b) {
        return a-b;
    }

    public static double addition(double a, double b) {
        return a+b;
    }
}
