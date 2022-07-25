package com.github.waymaker7.capstone;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogsServices {

    private final BlogsRepository blogsRepository;

    public void createPost(Blogs blogs) {
        blogsRepository.save(blogs);
    }

   /* public void createPost(Blogs blogs) {
        BlogsRepository.save(blogs);
    }*/

    public List<Blogs> findAll(){
    return blogsRepository.findAll();
}
}
