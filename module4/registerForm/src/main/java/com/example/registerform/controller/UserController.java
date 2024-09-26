package com.example.registerform.controller;

import com.example.registerform.dto.UserDto;
import com.example.registerform.model.User;
import com.example.registerform.service.IUserService;
import com.example.registerform.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("users")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/create")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("userDto", new UserDto());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute("userDto") UserDto userDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/create";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        redirectAttributes.addFlashAttribute("mess", "Add success");
        userService.save(user);
        return "redirect:/users/create";
    }
}
