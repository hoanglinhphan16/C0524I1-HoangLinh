package com.example.caculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Caculator {
    @GetMapping("/")
    public String caculator(Model model) {
        String[] list = {"Addition", "Subtraction", "Multiplication", "Division"};
        model.addAttribute("list", list);
        return "/index";
    }

    @PostMapping("/result")
    public String result(@RequestParam("selectedItem") String selectedItem
            , @RequestParam("value1") int value1
            , @RequestParam("value2") int value2, Model model) {
        String[] list = {"Addition", "Subtraction", "Multiplication", "Division"};
        model.addAttribute("list", list);
        if (selectedItem.equals("Addition")) {
            model.addAttribute("result", value1 + value2);
        } else if (selectedItem.equals("Subtraction")) {
            model.addAttribute("result", value1 - value2);
        } else if (selectedItem.equals("Multiplication")) {
            model.addAttribute("result", value1 * value2);
        } else if (selectedItem.equals("Division")) {
            if (value2 == 0) {
                model.addAttribute("result", "ERORRRRRRRRRR");
            } else {
                model.addAttribute("result", value1 / value2);
            }
        }
        return "/index";
    }
}