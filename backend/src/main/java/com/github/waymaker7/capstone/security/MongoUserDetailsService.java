package com.github.waymaker7.capstone.security;


import com.github.waymaker7.capstone.user.User;
import com.github.waymaker7.capstone.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MongoUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        return userRepository.findByUsername(username)
                .map(user -> new User(user.getUsername(), user.getPassword(), List.of()))
                .orElseThrow(() -> new UsernameNotFoundException(username + " not found"));
    }

}
