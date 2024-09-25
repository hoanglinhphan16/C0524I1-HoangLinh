package com.example.blog.service;

import com.example.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {
    Page<Category> findAll(Pageable pageable);
    Category findById(Long id);
    void save(Category blog);
    void delete(Long id);
    List<Category> findAll();
    Page<Category> searchByName(String name, Pageable pageable);
}
