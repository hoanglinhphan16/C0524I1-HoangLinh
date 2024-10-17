package com.example.finalexammodule4.controller;

import com.example.finalexammodule4.model.Discount;
import com.example.finalexammodule4.service.IDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller
@RequestMapping("/discounts")
public class DiscountController {
    @Autowired
    private IDiscountService discountService;

    @GetMapping
    public ModelAndView getDiscounts() {
        ModelAndView mav = new ModelAndView("list");
        mav.addObject("discounts", discountService.findAll());
        return mav;
    }

    @GetMapping("/create")
    public ModelAndView createDiscount() {
        ModelAndView mav = new ModelAndView("create");
        mav.addObject("discount", new Discount());
        return mav;
    }

    @PostMapping("/create")
    public String createDiscount(@ModelAttribute("discount") Discount discount) {
        discountService.save(discount);
        return "redirect:/discounts";
    }

    @PostMapping("/delete/{id}")
    public String deleteDiscount(@PathVariable Long id) {
        discountService.deleteById(id);
        return "redirect:/discounts";
    }

    @GetMapping("/searchDiscount")
    public ModelAndView searchDiscount(@RequestParam(required = false) LocalDate startDate,
                                       @RequestParam(required = false) LocalDate endDate,
                                       @RequestParam(required = false) Long discountPrice) {
        ModelAndView mav = new ModelAndView("list");
        mav.addObject("discounts", discountService.searchDiscount(startDate, endDate, discountPrice));
        return mav;
    }
}
