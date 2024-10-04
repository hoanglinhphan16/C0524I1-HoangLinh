package com.example.spring_security.respository.blog;


import com.example.spring_security.model.blog.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findBlogByAppUserUserName(String userName);
}
