package com.example.calculator.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.calculator.service.CalculatorService;

@WebMvcTest(CalculatorController.class) 
public class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;  
    
    @MockitoBean
    private CalculatorService calculatorService;


    @Test
    void testAdd() throws Exception {
    	
        when(calculatorService.add(2.0, 3.0)).thenReturn(5.0);

        mockMvc.perform(post("/calculator/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                          "number1": 2.0,
                          "number2": 3.0
                        }
                        """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(5.0));
    }
    

	@Test
	void testSubtract() throws Exception {
        when(calculatorService.subtract(10.0, 4.0)).thenReturn(6.0);

        mockMvc.perform(post("/calculator/subtract")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                          "number1": 10.0,
                          "number2": 4.0
                        }
                        """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(6.0));
	}
	
}
