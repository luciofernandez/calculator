package com.example.calculator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.calculator.model.OperationRequest;
import com.ejemplo.calculator.model.OperationResponse;
import com.example.calculator.api.CalculatorApi;
import com.example.calculator.service.CalculatorService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class CalculatorController implements CalculatorApi {

	private final CalculatorService calculatorService;
	

    @Override
    public ResponseEntity<OperationResponse> add(OperationRequest request) {
    	double result = calculatorService.add(request.getNumber1(), request.getNumber2());
        return ResponseEntity.ok(new OperationResponse(result));
    }

    @Override
    public ResponseEntity<OperationResponse> subtract(OperationRequest request) {
    	double result = calculatorService.subtract(request.getNumber1(), request.getNumber2());
        return ResponseEntity.ok(new OperationResponse(result));
    }

}
