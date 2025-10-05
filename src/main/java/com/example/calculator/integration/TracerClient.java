package com.example.calculator.integration;

import org.springframework.stereotype.Component;

import io.corp.calculator.TracerImpl;

@Component
public class TracerClient {

    private final TracerImpl tracer;
    
    public TracerClient() {
        this.tracer = new TracerImpl(); 
    }
	
    public void traceOperation(double result) {
        try {
            tracer.trace(result);
        } catch (Exception e) {
            System.err.println("Error al tracear la operación: " + e.getMessage());
        }
    }
}
