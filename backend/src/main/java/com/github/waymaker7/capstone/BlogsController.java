package com.github.waymaker7.capstone;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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



}
