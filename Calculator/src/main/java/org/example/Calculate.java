package org.example;

public interface Calculate<T extends Number> {
    T sum( T arg1, T arg2);
    T subtract(T arg1, T arg2);
    T multiplication(T arg1, T arg2);
    T divide(T arg1, T arg2);
}
