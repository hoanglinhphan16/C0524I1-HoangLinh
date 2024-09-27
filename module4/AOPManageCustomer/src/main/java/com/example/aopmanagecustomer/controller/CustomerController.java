package com.example.aopmanagecustomer.controller;

import com.example.aopmanagecustomer.model.Customer;
import com.example.aopmanagecustomer.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("/{id}")
    public ModelAndView showInformation(@PathVariable Long id) {
        try {
            ModelAndView modelAndView = new ModelAndView("/customer/info");
            Customer customer = customerService.findOne(id);
            modelAndView.addObject("customer", customer);
            return modelAndView;
        } catch (Exception e) {
            return new ModelAndView("redirect:/customers");
        }
    }
}
