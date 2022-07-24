package com.github.waymaker7.capstone;


import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Blogs {

    @Id
    private String id;

    public String hello(){
        return "sabou";
    }


}
