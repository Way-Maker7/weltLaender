package com.github.waymaker7.capstone.user;


import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void createNewUser(UserCreationData userCreationData) {

        if(!Objects.equals(userCreationData.getPassword(), userCreationData.getPasswordRepeat())){
            throw new IllegalArgumentException("passwords do not match");
        }

        if(userCreationData.getUsername() == null || userCreationData.getUsername().isBlank()){
            throw new IllegalArgumentException("username is blank");
        }


       MyUser myUser = new MyUser();
       myUser.setUsername(userCreationData.getUsername());
       myUser.setPassword(passwordEncoder.encode(userCreationData.getPassword()));

       userRepository.save(myUser);
    }



    public Optional<MyUser> findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public Optional<MyUser> findById(String userId) {
        return userRepository.findById(userId);
    }
}
