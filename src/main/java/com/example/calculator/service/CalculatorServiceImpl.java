package com.example.calculator.service;

import org.springframework.stereotype.Service;

import io.corp.calculator.TracerImpl;

@Service
public class CalculatorServiceImpl implements CalculatorService {
	
    private final TracerImpl tracer;
    
    public CalculatorServiceImpl() {
        this.tracer = new TracerImpl(); 
    }
	
    public double add(double a, double b) {
        double result = a + b;
        tracer.trace(result);
        return result;
    }
    public double subtract(double a, double b) {
        double result = a - b;
        tracer.trace(result);
        return result;
    }

}
