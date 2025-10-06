package com.example.calculator.service;

/**
 * Basic math operations service.
 * <p>
 * Defines the operations available for the calculator.
 */
public interface CalculatorService {
	
    /**
     * Add two numbers.
     *
     * @param a first number
     * @param b second number
     * @return the sum of {@code a} and {@code b}
     */
	public double add(double a, double b);
	
    /**
     * Subtract two numbers.
     *
     * @param a first number
     * @param b second number
     * @return the subtraction of {@code a - b}
     */
	public double subtract(double a, double b);

}
