package com.calc.arithmetic;

public interface Store<T> {
    T getCurrent();
    void setCurrent(T objectToStore);
}
