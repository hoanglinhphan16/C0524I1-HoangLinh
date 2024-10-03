package com.example.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@CrossOrigin("*")
@RestController
public class LoginController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/login/messages")
    public Map<String, String> getLoginMessages(@RequestParam(value = "lang", defaultValue = "en") String lang) {
        Locale locale = Locale.forLanguageTag(lang);

        Map<String, String> messages = new HashMap<>();
        messages.put("title", messageSource.getMessage("login.title", null, locale));
        messages.put("username", messageSource.getMessage("login.username", null, locale));
        messages.put("password", messageSource.getMessage("login.password", null, locale));
        messages.put("button", messageSource.getMessage("login.button", null, locale));
        messages.put("error", messageSource.getMessage("login.error", null, locale));

        return messages;
    }
}