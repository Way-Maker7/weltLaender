package com.github.waymaker7.capstone.user;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @PostMapping
    public void createUser(UserCreationDTO userCreationDTO){

    }

}
