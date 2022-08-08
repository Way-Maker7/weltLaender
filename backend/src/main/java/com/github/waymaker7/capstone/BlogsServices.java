package com.github.waymaker7.capstone;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class BlogsServices {

    private final BlogsRepository blogsRepository;

    public void createPost(Blogs blogs, String userId) {
        blogs.setId(userId);
        blogsRepository.save(blogs);
    }

    public List<Blogs> findAll(){
    return blogsRepository.findAll();
}

    public void editPost(Blogs blogs, String userId) {
        if(Objects.equals(userId, blogs.getUserId())){
            blogsRepository.save(blogs);
        }
        else {
            throw new IllegalArgumentException("you are not allow to edit this post!");
        }
    }

    public void deletePost(String id, String userId) {

       blogsRepository.deleteByIdAndUserId(id, userId)
               .orElseThrow(() -> new IllegalStateException("you are not allow to delete this post!"));
    }

    public Blogs findById(String id) {
        return  blogsRepository.findById(id).orElseThrow();
    }


    public void updatePost(Blogs blogs) {
        blogsRepository.save(blogs);
    }
}
