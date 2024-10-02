package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/blogs")
public class BlogController {
    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IBlogService blogService;

    @ModelAttribute("listCategories")
    public List<Category> listCategories() {
        return categoryService.findAll();
    }

    @GetMapping()
    public ResponseEntity<Page<Blog>> listBlog(@PageableDefault(size = 1) Pageable pageable) {
        Page<Blog> blogs = blogService.findAll(pageable);
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<Blog>> listBlogSearch(@RequestParam("search") String search, @PageableDefault(size = 6) Pageable pageable) {
        Page<Blog> blogs;
        if (search != null && !search.isEmpty()) {
            blogs = blogService.findBlogsByTitle(pageable, search);
        } else {
            blogs = blogService.findAll(pageable);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> getBlog(@PathVariable Long id) {
        Blog tempBlog = blogService.findById(id);
        if (tempBlog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tempBlog, HttpStatus.OK);
    }

//    @GetMapping("/create")
//    public ModelAndView createBlog() {
//        ModelAndView modelAndView = new ModelAndView("blog/create");
//        modelAndView.addObject("blog", new Blog());
//        return modelAndView;
//    }

    @PostMapping()
    public ResponseEntity<Blog> create(@RequestBody Blog blog) {
        blogService.save(blog);
        return new ResponseEntity<>(blog, HttpStatus.CREATED);
    }

//    @GetMapping("/update/{id}")
//    public ModelAndView updateForm(@PathVariable Long id) {
//        Blog blog = blogService.findById(id);
//        if (blog != null) {
//            ModelAndView modelAndView = new ModelAndView("blog/update");
//            modelAndView.addObject("blog", blog);
//            return modelAndView;
//        } else {
//            return new ModelAndView("error_404");
//        }
//    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Blog> update(@RequestBody Blog blog, @PathVariable Long id) {
        Blog tempBlog = blogService.findById(id);
        if (tempBlog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blog.setId(tempBlog.getId());
        blogService.save(blog);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

//    @GetMapping("/delete/{id}")
//    public String delete(@PathVariable Long id,
//                         RedirectAttributes redirect) {
//        blogService.delete(id);
//        redirect.addFlashAttribute("message", "Delete blog successfully");
//        return "redirect:/blogs";
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Blog> deleteBlog(@PathVariable Long id) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blogService.delete(id);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }
}
