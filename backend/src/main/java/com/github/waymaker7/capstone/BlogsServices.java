package com.github.waymaker7.capstone;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BlogsServices {

    private final BlogsRepository blogsRepository;

    public void createPost(Blogs blogs) {
        blogsRepository.save(blogs);
    }

    public List<Blogs> findAll(){
    return blogsRepository.findAll();
}

    public void editPost(Blogs blogs) {
        blogsRepository.save(blogs);
    }

    public void deletePost(String id) {
        blogsRepository.deleteById(id);
    }

    public Blogs findById(String id) {
        return  blogsRepository.findById(id).orElseThrow();
    }

    public void updatePost(Blogs blogs) {
        blogsRepository.save(blogs);
    }
}
