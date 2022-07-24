package com.github.waymaker7.capstone;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/blog")
public class BlogsController {

    @GetMapping
    public List<Blogs> getBlogs(){

        return null;
    }



}
