package com.example.spring_security.service.blog;

import com.example.spring_security.model.blog.Blog;
import java.util.List;

public interface IBlogService {
    List<Blog> findAllByUserName(String username);
    List<Blog> findAllByUserName();
    boolean postBlog(Blog blog,String username);
}
