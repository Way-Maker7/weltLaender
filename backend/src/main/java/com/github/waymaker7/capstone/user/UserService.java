package com.github.waymaker7.capstone.user;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
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


       User user = new User();
       user.setUsername(userCreationData.getUsername());
       user.setPassword(passwordEncoder.encode(userCreationData.getPassword()));

       userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        return findByUsername(username)
                .map(user -> new org.springframework.security.core.userdetails
                        .User(user.getUsername(), user.getPassword(), List.of()))
                .orElseThrow(() -> new UsernameNotFoundException(username + " not found"));
    }

    public Optional<User> findByUsername(String username){
        return userRepository.findByUsername(username);
    }
}
