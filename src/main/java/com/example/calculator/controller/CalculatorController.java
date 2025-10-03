package com.example.calculator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.calculator.model.OperationRequest;
import com.ejemplo.calculator.model.OperationResponse;
import com.example.calculator.api.CalculatorApi;
import com.example.calculator.service.CalculatorService;

import io.corp.calculator.TracerImpl;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class CalculatorController implements CalculatorApi {
	
	private final CalculatorService service;
	
    @Override
    public ResponseEntity<OperationResponse> add(OperationRequest request) {
    	OperationResponse response = new OperationResponse();
    	double result = service.add(request.getNumber1(), request.getNumber2());
    	response.setResult(result);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<OperationResponse> subtract(OperationRequest request) {
    	OperationResponse response = new OperationResponse();
    	double result = service.subtract(request.getNumber1(), request.getNumber2());
        response.setResult(result);
        return ResponseEntity.ok(response);
    }
}
