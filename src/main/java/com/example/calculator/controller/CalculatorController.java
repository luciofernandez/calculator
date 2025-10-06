package com.example.calculator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.calculator.model.AddRequest;
import com.ejemplo.calculator.model.CalculatorResponse;
import com.ejemplo.calculator.model.SubtractRequest;
import com.example.calculator.api.CalculatorApi;
import com.example.calculator.service.CalculatorService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class CalculatorController implements CalculatorApi {

	private final CalculatorService calculatorService;
	

    @Override
    public ResponseEntity<CalculatorResponse> add(AddRequest request) {
    	double result = calculatorService.add(request.getNumber1(), request.getNumber2());
        return ResponseEntity.ok(new CalculatorResponse(result));
    }

    @Override
    public ResponseEntity<CalculatorResponse> subtract(SubtractRequest request) {
    	double result = calculatorService.subtract(request.getNumber1(), request.getNumber2());
        return ResponseEntity.ok(new CalculatorResponse(result));
    }
    
}
