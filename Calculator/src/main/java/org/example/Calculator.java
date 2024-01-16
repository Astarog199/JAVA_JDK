package org.example;

/**
 * Написать класс Калькулятор (необобщенный), который содержит обобщенные статические методы:
 * sum(), multiply(), divide(), subtract().
 * Параметры этих методов – два числа разного типа, над которыми должна быть произведена операция.
 */
public class Calculator implements Calculate<Number>{

    private void checkArgs(Number arg1,Number arg2){
        if (arg1 == null || arg2 == null) {
            throw new IllegalArgumentException("Both arguments must be non-null");
        }

//        if (arg1 instanceof String || arg2 instanceof String) {
//            throw new IllegalArgumentException("Invalid argument type.");
//        }
    }


    @Override
    public Number sum(Number arg1, Number arg2) {
        checkArgs(arg1, arg2);
        return arg1.doubleValue() + arg2.doubleValue();
    }

    @Override
    public Number subtract(Number arg1, Number arg2) {
        checkArgs(arg1, arg2);
        return arg1.doubleValue() - arg2.doubleValue();
    }

    @Override
    public Number multiplication(Number arg1, Number arg2) {
        checkArgs(arg1, arg2);
        return arg1.doubleValue() * arg2.doubleValue();
    }

    @Override
    public Number divide(Number arg1, Number arg2) {
        checkArgs(arg1, arg2);
        return arg1.doubleValue() / arg2.doubleValue();
    }
}
