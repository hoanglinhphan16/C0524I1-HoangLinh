package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class Dictionary {
    @GetMapping("/dictionary")
    public String dictionary() {
        return "/dictionary";
    }

    @PostMapping("/dictionary")
    public String dictionaryPost(@RequestParam("word") String word, Model model) {
        Map<String, String> dictionary = new HashMap<String, String>();
        dictionary.put("book", "sach");
        dictionary.put("learn", "hoc");
        dictionary.put("computer", "may tinh");
        dictionary.put("glasses", "kinh");

        String result = dictionary.getOrDefault(word, "Từ này không có trong từ điển.");
        model.addAttribute("result", result);
        return "/dictionary";
    }
}
