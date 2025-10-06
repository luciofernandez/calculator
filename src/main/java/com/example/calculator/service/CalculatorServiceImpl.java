package com.example.calculator.service;

import org.springframework.stereotype.Service;

import com.example.calculator.integration.TracerClient;


@Service
public class CalculatorServiceImpl implements CalculatorService {
	
    private final TracerClient tracer;
    
    public CalculatorServiceImpl(TracerClient tracerClient) {
        this.tracer = tracerClient;
    }
    
    public double add(double a, double b) {
        double result = a + b;
        tracer.traceOperation(result);
        return result;
    }
    public double subtract(double a, double b) {
        double result = a - b;
        tracer.traceOperation(result);
        return result;
    }
    

}
