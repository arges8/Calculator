package com.calc.arithmetic;

public class OperationExecutor {
    private OperatorStore operator;
    private NumberStore number;

    public OperationExecutor() {
        operator = OperatorStore.getInstance();
        number = NumberStore.getInstance();
    }


}
