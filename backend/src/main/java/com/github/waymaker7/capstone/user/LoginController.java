package com.github.waymaker7.capstone.user;


import com.github.waymaker7.capstone.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api/auth/login")
@RequiredArgsConstructor

public class LoginController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    private final UserService userService;


    @PostMapping
    public ResponseEntity<LoginResponse> login(@RequestBody LoginData loginData){
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginData.getUsername(),
                    loginData.getPassword()));
            MyUser myUser = userService.findByUsername(loginData.getUsername()).orElseThrow();

            String jwt = jwtService.createJwt(new HashMap<>(), myUser.getId());
            return ResponseEntity.ok(new LoginResponse(jwt));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

    }

}
