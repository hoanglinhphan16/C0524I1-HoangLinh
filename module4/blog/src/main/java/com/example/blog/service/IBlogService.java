package com.example.blog.service;


import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);
    Blog findById(Long id);
    void save(Blog blog);
    void delete(Long id);
    Page<Blog> findBlogsByTitle(Pageable pageable, String title);
}
