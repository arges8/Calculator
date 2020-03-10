package com.calc.arithmetic.store;

public class NumberStore implements Store<Double> {
    private static volatile NumberStore instance;
    private double currentNumber;

    private NumberStore() {
        currentNumber = 0;
    }

    public static NumberStore getInstance() {
        if(instance == null) {
            synchronized (NumberStore.class) {
                if(instance == null)
                    instance = new NumberStore();
            }
        }
        return instance;
    }

    @Override
    public Double getCurrent() {
        return currentNumber;
    }

    @Override
    public void setCurrent(Double numberToStore) {
        this.currentNumber = numberToStore;
    }

    @Override
    public void setDefault() {
        this.currentNumber = 0;
    }
}
