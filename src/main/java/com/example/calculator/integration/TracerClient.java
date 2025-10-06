package com.example.calculator.integration;

import org.springframework.stereotype.Component;

import io.corp.calculator.TracerAPI;
import io.corp.calculator.TracerImpl;

@Component
public class TracerClient implements TracerAPI {

    private TracerImpl tracer;
    
    public TracerClient() {
        this.tracer = new TracerImpl(); 
    }
	
	@Override
	public <T> void trace(T result) {
        try {
            tracer.trace(result);
        } catch (Exception e) {
            System.err.println("Error al tracear la operación: " + e.getMessage());
        }		
	}
}
