package com.example.calculator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.calculator.model.OperationRequest;
import com.ejemplo.calculator.model.OperationResponse;
import com.example.calculator.api.CalculatorApi;
import com.example.calculator.dto.OperationType;
import com.example.calculator.service.CalculatorService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class CalculatorController implements CalculatorApi {

	private final CalculatorService calculatorService;

	@Override
	public ResponseEntity<OperationResponse> calculate(OperationRequest request) {
		try {

			OperationType operationType = OperationType.fromString(request.getOperation());

			double result = calculatorService.calculate(request.getNumber1(), request.getNumber2(), operationType);

			return ResponseEntity.ok(new OperationResponse(result));

		} catch (IllegalArgumentException ex) {
			return ResponseEntity.badRequest().body(new OperationResponse(null));
		}

	}

}
