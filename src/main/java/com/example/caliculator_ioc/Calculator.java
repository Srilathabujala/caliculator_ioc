package com.example.caliculator_ioc;

import java.util.HashMap;
import java.util.Map;

public class    Calculator {

    private final Map<Operation, OperationStrategy> operationStrategies = new HashMap<>();

    public Calculator() {
        operationStrategies.put(Operation.ADD, new AddStrategy());
        operationStrategies.put(Operation.SUBTRACT, new SubtractStrategy());
        operationStrategies.put(Operation.MULTIPLY, new MultiplyStrategy());
        operationStrategies.put(Operation.DIVIDE, new DivideStrategy());
    }

    public double calculate(Operation op, double num1, double num2) {
        OperationStrategy strategy = operationStrategies.get(op);
        if (strategy == null) {
            throw new UnsupportedOperationException("Operation not supported");
        }
        return strategy.apply(num1, num2);
    }

    public double   chainCalculate(double initialValue, Object... operationsAndNumbers) {
        double result = initialValue;
        for (int i = 0; i < operationsAndNumbers.length; i += 2) {
            Operation op = (Operation) operationsAndNumbers[i];
            double num = (double) operationsAndNumbers[i + 1];
            result = calculate(op, result, num);
        }
        return result;
    }

}