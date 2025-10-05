package com.example.calculator.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.calculator.dto.OperationType;
import com.example.calculator.integration.TracerClient;

@ExtendWith(MockitoExtension.class)
public class CalculatorServiceImplTest {

    private CalculatorServiceImpl calculatorService;
    
    @Mock
    private TracerClient tracer;

    @BeforeEach
    void setUp() {
        calculatorService = new CalculatorServiceImpl(tracer);
    }

    @Test
    void testAdd() {
        double result = calculatorService.calculate(5.0, 3.0, OperationType.ADD);
        assertEquals(8.0, result, 0.0001, "La suma debería ser 8.0");
    }

    @Test
    void testSubtract() {
        double result = calculatorService.calculate(10.0, 4.0, OperationType.SUBTRACT);
        assertEquals(6.0, result, 0.0001, "La resta debería ser 6.0");
    }

    @Test
    void testAddWithNegatives() {
        double result = calculatorService.calculate(-2.0, -3.0, OperationType.ADD);
        assertEquals(-5.0, result, 0.0001, "La suma de negativos debería ser -5.0");
    }

    @Test
    void testSubtractWithNegatives() {
        double result = calculatorService.calculate(-5.0, -2.0, OperationType.SUBTRACT);
        assertEquals(-3.0, result, 0.0001, "La resta de negativos debería ser -3.0");
    }
    
	@Test
	void testInvalidOperator() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
        	calculatorService.calculate(10.0, 4.0, null);
        });
        assertTrue(exception.getMessage().contains("Unsupported operation"));

	}
}