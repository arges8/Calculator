package com.calc.arithmetic.operator;

import java.util.LinkedList;

public class NoneOperator implements CalculatorOperator {

    @Override
    public double calculate(LinkedList<Double> nums) {
        if(nums.size() >= 2) {
            nums.poll();
            return nums.poll();
        } else if(nums.size() == 1) {
            return nums.poll();
        }

        return 0;
    }
}
