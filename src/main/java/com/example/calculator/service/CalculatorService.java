package com.example.calculator.service;

import com.example.calculator.dto.OperationType;

public interface CalculatorService {
	
	public double calculate(double number1, double number2, OperationType operationType);

}
