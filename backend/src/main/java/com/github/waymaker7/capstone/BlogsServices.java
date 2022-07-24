package com.github.waymaker7.capstone;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogsServices {

    private final BlogsRepository blogsRepository;
public List<Blogs> findAll(){
    return blogsRepository.findAll();
}
}
