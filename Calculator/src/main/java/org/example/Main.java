package org.example;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println("sum: " + calculator.sum(10.5, 9));
        System.out.println("subtract: " + calculator.subtract(55, 9));
        System.out.println("multiplication: " + calculator.multiplication(10, 9));
        System.out.println("divide: " + calculator.divide(null, 9.6));
    }
}