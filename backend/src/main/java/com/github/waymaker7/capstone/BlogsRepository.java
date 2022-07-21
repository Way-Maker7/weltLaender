package com.github.waymaker7.capstone;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogsRepository extends MongoRepository<Blogs, String> {

}
