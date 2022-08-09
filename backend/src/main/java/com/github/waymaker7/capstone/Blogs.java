package com.github.waymaker7.capstone;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "articles")
public class Blogs {

    @Id
    private String id;

    private String author;

    //private String userId;

    private String content;

    public Blogs(String author, String content){
        this.author = author;
        this.content = content;
    }




}
