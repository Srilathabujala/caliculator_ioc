package com.example.caliculator_ioc;

public class DivideStrategy implements OperationStrategy{
    @Override
    public double apply(double num1, double num2) {
        if(num2 == 0 ){
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return num1 / num2;
        }
    }

