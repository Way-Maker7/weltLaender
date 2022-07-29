package com.github.waymaker7.capstone;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/blog")
@RequiredArgsConstructor
@CrossOrigin

public class BlogsController {

    private final BlogsServices blogsServices;
    @GetMapping
    public List<Blogs> getBlogs(){

        return blogsServices.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createPost(@RequestBody Blogs blogs){
        blogsServices.createPost(blogs);
    }

    @PutMapping
    public void editPost(@RequestBody Blogs blogs){
        blogsServices.editPost(blogs);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable String id){
        blogsServices.deletePost(id);
    }

    @PutMapping("{id}")
    public void updatePost(@RequestBody Blogs blogs){
        blogsServices.updatePost(blogs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blogs> getBlogs(@PathVariable String id){
        try {
            return ResponseEntity.ok(blogsServices.findById(id));
        }
        catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }



}
