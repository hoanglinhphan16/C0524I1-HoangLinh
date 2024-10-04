package com.example.spring_security.service.blog;



import com.example.spring_security.model.AppUser;
import com.example.spring_security.model.blog.Blog;
import com.example.spring_security.respository.AppUserRepository;
import com.example.spring_security.respository.blog.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;
    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public List<Blog> findAllByUserName(String username) {
        return blogRepository.findBlogByAppUserUserName(username);
    }

    @Override
    public List<Blog> findAllByUserName() {
        return blogRepository.findAll();
    }

    @Override
    public boolean postBlog(Blog blog,String username) {
        AppUser appUser = appUserRepository.findByUserName(username);
        blog.setAppUser(appUser);
        blogRepository.save(blog);
        return true;
    }
}
