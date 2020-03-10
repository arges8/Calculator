package com.calc.arithmetic.store;

interface Store<T> {
    T getCurrent();
    void setCurrent(T objectToStore);
    void setDefault();
}
