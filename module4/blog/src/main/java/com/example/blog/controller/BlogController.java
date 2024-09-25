package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
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
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IBlogService blogService;

    @ModelAttribute("listCategories")
    public List<Category> listCategories() { return  categoryService.findAll(); };

    @GetMapping()
    public ModelAndView listBlog(@PageableDefault(size = 6) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("blog/list");
        Page<Blog> blogs = blogService.findAll(pageable);
        modelAndView.addObject("blogs", blogs);
        return modelAndView;
    }

    @GetMapping("/search")
    public ModelAndView listBlogSearch(@RequestParam("search") Optional<String> search, @PageableDefault(size = 6) Pageable pageable) {
        Page<Blog> blogs;
        if (search.isPresent()) {
            blogs = blogService.findBlogsByTitle(pageable, search.get());
        } else {
            blogs = blogService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("blog/list");
        modelAndView.addObject("blogs", blogs);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createBlog() {
        ModelAndView modelAndView = new ModelAndView("blog/create");
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
            ModelAndView modelAndView = new ModelAndView("blog/update");
            modelAndView.addObject("blog", blog);
            return modelAndView;
        } else {
            return new ModelAndView("error_404");
        }
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("blog") Blog blog,
                         RedirectAttributes redirect) {
        System.out.println(blog.getCategory().getId());
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

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("blog/detail");
        Blog blog = blogService.findById(id);
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }
}
