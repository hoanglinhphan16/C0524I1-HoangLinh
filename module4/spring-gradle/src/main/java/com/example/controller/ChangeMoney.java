package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChangeMoney {
    @GetMapping("/changeMoney")
    public String changeMoney() {
        return "/changeMoney";
    }

    @PostMapping("/changeMoney")
    public String changeMoney(@RequestParam("money") double money, Model model) {
        double result = (money*24500);
        model.addAttribute("result", result);
        return "/changeMoney";
    }
}
