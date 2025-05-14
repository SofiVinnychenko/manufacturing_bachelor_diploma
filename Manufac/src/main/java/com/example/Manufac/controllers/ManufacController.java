package com.example.Manufac.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ManufacController {

    @GetMapping("/orders")
    public String orders(Model model) {
        model.addAttribute("title", "Main");
        return "orders";
    }

}
