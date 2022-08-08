package com.github.waymaker7.capstone;

import com.github.waymaker7.capstone.user.MyUser;
import com.github.waymaker7.capstone.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/blog")
@RequiredArgsConstructor
@CrossOrigin

public class BlogsController {

    private final BlogsServices blogsServices;

    private final UserService userService;

    @GetMapping
    public List<Blogs> getBlogs(){

        return blogsServices.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createPost(@RequestBody Blogs blogs, Principal principal){
       MyUser user = userService.findByUsername(principal.getName()).orElseThrow();
        blogsServices.createPost(blogs, user.getId());
    }

    @PutMapping
    public void editPost(@RequestBody Blogs blogs){
        blogsServices.editPost(blogs);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>  deletePost(@PathVariable String id, Principal principal){

        try {
            MyUser user = userService.findByUsername(principal.getName()).orElseThrow();
            blogsServices.deletePost(id, user.getId());
            return ResponseEntity.ok().build();
        }
        catch (Exception e){
            return ResponseEntity.notFound().build();
        }

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
