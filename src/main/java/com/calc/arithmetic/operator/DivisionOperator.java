package com.calc.arithmetic.operator;

import java.util.LinkedList;

public class DivisionOperator implements CalculatorOperator {

    @Override
    public double calculate(LinkedList<Double> nums) {
        if(nums.size() >= 2) {
            double num1 = nums.poll();
            double num2 = nums.poll();
            if(num2 == 0)
                throw new RuntimeException();

            return num1 / num2;
        }

        throw new RuntimeException();
    }
}
