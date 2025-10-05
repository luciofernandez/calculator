package com.example.calculator.service;

import org.springframework.stereotype.Service;

import com.example.calculator.dto.OperationType;
import com.example.calculator.integration.TracerClient;


@Service
public class CalculatorServiceImpl implements CalculatorService {
	
    private final TracerClient tracer;
    
    public CalculatorServiceImpl(TracerClient tracerClient) {
        this.tracer = tracerClient;
    }
    
    public double calculate(double a, double b, OperationType operationType) {
    	double result;
    	
        if (operationType == OperationType.ADD) {
           result = add(a,b);
        } else if (operationType == OperationType.SUBTRACT) {
        	result = subtract(a,b);
        } else {
        	throw new IllegalArgumentException("Unsupported operation: " + operationType);
        }
        
        tracer.traceOperation(result);
        
        return result;

    }
	
    private double add(double a, double b) {
        return a + b;
    }
    private double subtract(double a, double b) {
        return a - b;
    }

}
