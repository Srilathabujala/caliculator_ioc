package com.example.caliculator_ioc;

public class MultiplyStrategy implements OperationStrategy{
    @Override
    public double apply(double num1, double num2) {
        return num1 * num2;
    }
}
