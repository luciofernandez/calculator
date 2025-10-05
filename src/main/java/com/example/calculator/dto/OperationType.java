package com.example.calculator.dto;

public enum OperationType {
    ADD,
    SUBTRACT;
    
    public static OperationType fromString(String op) {
        for (OperationType operation : values()) {
            if (operation.name().equalsIgnoreCase(op)) {
                return operation;
            }
        }
        throw new IllegalArgumentException(
            "Invalid operation: " + op + ". Allowed: add, subtract."
        );
    }
}