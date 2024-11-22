/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.centropol.jsfkalkulacka.controllers;

import cz.centropol.jsfkalkulacka.dto.CalculatorDTO;
import cz.centropol.jsfkalkulacka.services.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author rybcak
 */
@Controller
@RequestMapping("/")
public class CalculatorController {
    @Autowired
    private CalculatorService calculatorService;
    
    @GetMapping("/calculator")
    public String calculator(@ModelAttribute CalculatorDTO calculatorDTO) {
        return "index";
    }
    
    @PostMapping("/calculator")
    public String calculator(@ModelAttribute CalculatorDTO calculatorDTO, Model model) {
        double calculationResult = calculatorService.calculate(calculatorDTO);
        model.addAttribute("calculationResult", calculationResult);
        return "result";
    }
    
    
}
