package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping()
    public ModelAndView listBlog() {
        ModelAndView modelAndView = new ModelAndView("list");
        List<Blog> blogs = blogService.findAll();
        modelAndView.addObject("blogs", blogs);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createBlog() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("blog") Blog blog,
                         RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Create new blog successfully");
        return "redirect:/blogs";
    }

    @GetMapping("/update/{id}")
    public ModelAndView updateForm(@PathVariable Long id) {
        Blog blog = blogService.findById(id);
        if (blog != null) {
            ModelAndView modelAndView = new ModelAndView("update");
            modelAndView.addObject("blog", blog);
            return modelAndView;
        } else {
            return new ModelAndView("error_404");
        }
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("customer") Blog blog,
                         RedirectAttributes redirect) {
        blogService.save(blog);
        redirect.addFlashAttribute("message", "Update blog successfully");
        return "redirect:/blogs";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id,
                         RedirectAttributes redirect) {
        blogService.delete(id);
        redirect.addFlashAttribute("message", "Delete blog successfully");
        return "redirect:/blogs";
    }

}
