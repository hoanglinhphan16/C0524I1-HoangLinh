package com.example.demo1_spring_boot.controller;

import com.example.demo1_spring_boot.model.Customer;
import com.example.demo1_spring_boot.model.Province;
import com.example.demo1_spring_boot.service.ICustomerService;
import com.example.demo1_spring_boot.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @ModelAttribute("provinces")
    public List<Province> listProvinces() {
        return provinceService.findAll();
    }

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IProvinceService provinceService;

    @GetMapping("")
    public ModelAndView listCustomer(@PageableDefault(size = 2) Pageable pageable) {
        System.out.println(pageable);
        Page<Customer> customers = customerService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("/search")
    public ModelAndView listCustomersSearch(@RequestParam("search") Optional<String> search, Pageable pageable) {
        Page<Customer> customers;
        if(search.isPresent()){
            customers = customerService.findAllByName(pageable, search.get());
        } else {
            customers = customerService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("customer") Customer customer,
                         RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Create new customer successfully");
        return "redirect:/customers";
    }

    @GetMapping("/update/{id}")
    public ModelAndView updateForm(@PathVariable Long id) {
        Customer customer = customerService.findById(id);
        if (customer != null) {
            ModelAndView modelAndView = new ModelAndView("/customer/update");
            modelAndView.addObject("customer", customer);
            return modelAndView;
        } else {
            return new ModelAndView("/error_404");
        }
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("customer") Customer customer,
                         RedirectAttributes redirect) {
        customerService.save(customer);
        redirect.addFlashAttribute("message", "Update customer successfully");
        return "redirect:/customers";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id,
                         RedirectAttributes redirect) {
        customerService.remove(id);
        redirect.addFlashAttribute("message", "Delete customer successfully");
        return "redirect:/customers";
    }
}