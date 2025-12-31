package com.demo.calculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @GetMapping("/")
    public String home() {
        return "calculator";
    }

    @PostMapping("/calculate")
    public String calculate(
            @RequestParam int a,
            @RequestParam int b,
            @RequestParam String op,
            Model model
    ) {
        int result = 0;

        switch (op) {
            case "add" -> result = a + b;
            case "sub" -> result = a - b;
            case "mul" -> result = a * b;
            case "div" -> result = (b != 0) ? a / b : 0;
        }

        model.addAttribute("result", result);
        return "calculator";
    }
}
