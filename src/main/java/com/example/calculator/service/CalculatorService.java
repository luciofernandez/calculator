package com.example.calculator.service;

/**
 * Servicio de operaciones matemáticas básicas.
 * <p>
 * Define las operaciones disponibles para la calculadora.
 */
public interface CalculatorService {
	
    /**
     * Suma dos números.
     *
     * @param a primer número
     * @param b segundo número
     * @return la suma de {@code a} y {@code b}
     */
	public double add(double a, double b);
	
    /**
     * Resta dos números.
     *
     * @param a primer número
     * @param b segundo número
     * @return la resta de {@code a - b}
     */
	public double subtract(double a, double b);

}
