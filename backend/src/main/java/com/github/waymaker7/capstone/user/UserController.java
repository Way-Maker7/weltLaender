package com.github.waymaker7.capstone.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody UserCreationData userCreationData){
      try {
          userService.createNewUser(userCreationData);
          return ResponseEntity.status(HttpStatus.CREATED).build();
      }
        catch (IllegalArgumentException e){
          return ResponseEntity.badRequest().build();
        }

    }

}
