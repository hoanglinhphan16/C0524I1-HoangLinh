package com.example.music.controller;

import com.example.music.dto.SongDto;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SongController {
    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView mav = new ModelAndView("create");
        mav.addObject("songDto", new SongDto());
        return mav;
    }

    @PostMapping("/create")
    public ModelAndView create(@Validated @ModelAttribute("songDto") SongDto songDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new SongDto().validate(songDto, bindingResult);
        if (bindingResult.hasErrors()) {
            ModelAndView mav = new ModelAndView("create");
            return mav;
        }

        redirectAttributes.addFlashAttribute("songDto", songDto);
        ModelAndView mav = new ModelAndView("redirect:/create");
        return mav;
    }
}
