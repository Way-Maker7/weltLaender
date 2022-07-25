package com.github.waymaker7.capstone;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blog")
@RequiredArgsConstructor

public class BlogsController {

    private final BlogsServices blogsServices;
    @GetMapping
    public List<Blogs> getBlogs(){

        return blogsServices.findAll();
    }

    @PostMapping
    public void createPost(@RequestBody Blogs blogs){
        blogsServices.createPost(blogs);
    }



}
