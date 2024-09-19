package com.example.controller;

import com.example.model.Setting;
import com.example.service.ILanguageService;
import com.example.service.IPageSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MailController {

    @Autowired
    private ILanguageService languageService;
    @Autowired
    private IPageSizeService pageSizeService;

    @ModelAttribute("languages")
    public List<String> getLanguages(Model model) {
        return languageService.getLanguages();
    }

    @ModelAttribute("pageSizes")
    public List<String> getPageSizes(Model model) {
        return pageSizeService.getPageSizes();
    }

    @GetMapping("/")
    public String getForm(Model model) {
        model.addAttribute("setting", new Setting());
        return "/index";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Setting setting, Model model) {
        System.out.println(setting);
        return "/index";
    }
}
