/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.centropol.jsfkalkulacka.services;

import cz.centropol.jsfkalkulacka.dto.CalculatorDTO;
import cz.centropol.jsfkalkulacka.exceptions.DivisionByZeroException;
import org.springframework.stereotype.Service;

/**
 *
 * @author rybcak
 */
@Service
public class CalculatorService {
    public double calculate(CalculatorDTO calculatorDTO) {
        switch (calculatorDTO.getOperation()) {
            case "+" -> {
                return calculatorDTO.getNumberOne() + calculatorDTO.getNumberTwo();
            }
            case "-" -> {
                return calculatorDTO.getNumberOne() - calculatorDTO.getNumberTwo();
            }
            case "*" -> {
                return calculatorDTO.getNumberOne() * calculatorDTO.getNumberTwo();
            }
            case "/" -> {
                if (calculatorDTO.getNumberTwo() == 0) {
                    throw new DivisionByZeroException("Cannot divide by zero!");
                }
                return calculatorDTO.getNumberOne() / calculatorDTO.getNumberTwo();
            }
            default -> throw new IllegalArgumentException("UNSUPPORTED OPERATION");
        }
    
    }
    
}
