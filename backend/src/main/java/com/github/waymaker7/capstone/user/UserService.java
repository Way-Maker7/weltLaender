package com.github.waymaker7.capstone.user;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void createNewUser(UserCreationDTO userCreationDTO) {

    }
}
