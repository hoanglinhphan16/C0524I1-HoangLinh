package com.example.blog.controller;

import com.example.blog.model.Category;
import com.example.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping()
    public ResponseEntity<Page<Category>> listCategory(@PageableDefault(size = 6) Pageable pageable) {
        Page<Category> categories = categoryService.findAll(pageable);
        if (categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<Category>> listCategorySearch(@RequestParam(defaultValue = "0") int page,
                                           @RequestParam(defaultValue = "") String search) {
        Sort sort = Sort.by("name").ascending();
        Pageable pageable = PageRequest.of(page, 6, sort);
        Page<Category> categories = categoryService.searchByName(search, pageable);
        if (categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

//    @GetMapping("/create")
//    public ModelAndView createCategory() {
//        ModelAndView modelAndView = new ModelAndView("category/create");
//        modelAndView.addObject("category", new Category());
//        return modelAndView;
//    }

    @PostMapping()
    public ResponseEntity<Category> create(@RequestBody Category category) {
        categoryService.save(category);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

//    @GetMapping("update/{id}")
//    public ModelAndView updateCategory(@PathVariable Long id) {
//        Category category = categoryService.findById(id);
//        if (category != null) {
//            ModelAndView modelAndView = new ModelAndView("category/update");
//            modelAndView.addObject("category", category);
//            return modelAndView;
//        } else {
//            return new ModelAndView("error_404");
//        }
//    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Category> update(@RequestBody Category category) {
        Category tempCategory = categoryService.findById(category.getId());
        if (tempCategory == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        category.setId(tempCategory.getId());
        categoryService.save(category);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Category> delete(@PathVariable Long id) {
        Category category = categoryService.findById(id);
        if (category == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        categoryService.delete(id);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
}
