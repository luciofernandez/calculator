package com.example.calculator.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import com.ejemplo.calculator.model.OperationRequest;
import com.ejemplo.calculator.model.OperationResponse;
import com.example.calculator.dto.OperationType;
import com.example.calculator.service.CalculatorService;

public class CalculatorControllerTest {

	private CalculatorService calculatorService;
	private CalculatorController calculatorController;

	@BeforeEach
	void setUp() {
		calculatorService = Mockito.mock(CalculatorService.class);
		calculatorController = new CalculatorController(calculatorService);
	}

	@Test
	void testAdd() {
		OperationRequest request = new OperationRequest();
		request.setNumber1(5.0);
		request.setNumber2(3.0);
		request.setOperation(OperationType.ADD.name());

		when(calculatorService.calculate(5.0, 3.0, OperationType.ADD)).thenReturn(8.0);

		ResponseEntity<OperationResponse> response = calculatorController.calculate(request);

		assertEquals(200, response.getStatusCodeValue());
		assertEquals(8.0, response.getBody().getResult());
	}

	@Test
	void testSubtract() {
		OperationRequest request = new OperationRequest();
		request.setNumber1(10.0);
		request.setNumber2(4.0);
		request.setOperation(OperationType.SUBTRACT.name());

		when(calculatorService.calculate(10.0, 4.0, OperationType.SUBTRACT)).thenReturn(6.0);

		ResponseEntity<OperationResponse> response = calculatorController.calculate(request);

		assertEquals(200, response.getStatusCodeValue());
		assertEquals(6.0, response.getBody().getResult());
	}
	
}
