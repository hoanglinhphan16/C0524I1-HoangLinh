package com.example.spring_security.controller;


import com.example.spring_security.model.blog.Blog;
import com.example.spring_security.service.blog.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;


@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @GetMapping("")
    public String showList(Model model, Principal principal){
        if (principal==null){
            List<Blog> blogList = blogService.findAllByUserName();
            model.addAttribute("blogList",blogList);
        }else {
            String username =principal.getName();
            List<Blog> blogList = blogService.findAllByUserName(username);
            model.addAttribute("blogList",blogList);
        }
        return "blog/list";
    }
    @GetMapping("/create")
    public String showFormCreate(Model model){
        return "blog/create";
    }

    @PostMapping("/create")
    public String save(@RequestParam String title,
                       @RequestParam String content,
                       @RequestParam(defaultValue = "",required = false) String img,
                       Principal principal
                       ){
        String username =principal.getName();
        if (img.equals("")){
         img ="https://i.pinimg.com/236x/65/f0/93/65f0937b7c467362d7a3610ea141f99f.jpg";
        }
        blogService.postBlog(new Blog(title,content,img), username);
        return "redirect:/blog";
    }

}
