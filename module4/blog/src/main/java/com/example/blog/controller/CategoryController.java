package com.example.blog.controller;

import com.example.blog.model.Category;
import com.example.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping()
    public ModelAndView listCategory(@PageableDefault(size = 6) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("category/list");
        Page<Category> categories = categoryService.findAll(pageable);
        modelAndView.addObject("categories", categories);
        return modelAndView;
    }

    @GetMapping("/search")
    public ModelAndView listCategorySearch(@RequestParam(defaultValue = "0") int page,
                                           @RequestParam(defaultValue = "") String search) {
        Sort sort = Sort.by("name").ascending();
        Pageable pageable = PageRequest.of(page, 6, sort);
        Page<Category> categories = categoryService.searchByName(search, pageable);
        ModelAndView modelAndView = new ModelAndView("category/list");
        modelAndView.addObject("categories", categories);
        modelAndView.addObject("search",search);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createCategory() {
        ModelAndView modelAndView = new ModelAndView("category/create");
        modelAndView.addObject("category", new Category());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Category category,
                         RedirectAttributes redirectAttributes) {
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("message", "Category created successfully");
        return "redirect:/categories";
    }

    @GetMapping("update/{id}")
    public ModelAndView updateCategory(@PathVariable Long id) {
        Category category = categoryService.findById(id);
        if (category != null) {
            ModelAndView modelAndView = new ModelAndView("category/update");
            modelAndView.addObject("category", category);
            return modelAndView;
        } else {
            return new ModelAndView("error_404");
        }
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("category") Category category,
                         RedirectAttributes redirectAttributes) {
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("message", "Category updated successfully");
        return "redirect:/categories";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id,
                         RedirectAttributes redirectAttributes) {
        categoryService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Category deleted successfully");
        return "redirect:/categories";
    }
}
