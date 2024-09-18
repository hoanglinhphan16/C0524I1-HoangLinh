package com.example.sandwich;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Sandwich{
    @GetMapping("/")
    public String sandwich(Model model){
        String[] list = {"Lettuce","Tomato","Mustard","Sprouts"};
        model.addAttribute("list", list);
        return "/index";
    }

    @PostMapping("/save")
    public String saveSandwich(@RequestParam(name = "selectedItems", required = false) String[] selectedItems, Model model){
        if(selectedItems == null){
            model.addAttribute("message", "You have no choice");
            return "/results";
        }
        model.addAttribute("selectedItems", selectedItems);
        return "/results";
    }
}

