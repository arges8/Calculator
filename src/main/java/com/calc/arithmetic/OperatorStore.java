package com.calc.arithmetic;

public class OperatorStore implements Store<CalculatorOperator> {
    private static volatile OperatorStore instance;
    private CalculatorOperator currentOperator;

    private OperatorStore() {
        currentOperator = CalculatorOperator.NONE;
    }

    public static OperatorStore getInstance() {
        if(instance == null) {
            synchronized (OperatorStore.class) {
                if(instance == null)
                    instance = new OperatorStore();
            }
        }
        return instance;
    }

    @Override
    public CalculatorOperator getCurrent() {
        return currentOperator;
    }

    @Override
    public void setCurrent(CalculatorOperator operatorToStore) {
        this.currentOperator = operatorToStore;
    }
}
