package com.github.waymaker7.capstone;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BlogsRepository extends MongoRepository<Blogs, String> {

     void deleteByIdAndAuthor(String id, String author);
}
