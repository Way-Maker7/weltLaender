package com.github.waymaker7.capstone;


import com.github.waymaker7.capstone.user.LoginData;
import com.github.waymaker7.capstone.user.LoginResponse;
import com.github.waymaker7.capstone.user.UserCreationData;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.security.core.userdetails.User;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WeltLaenderIT {

    @Autowired
     BlogsRepository blogsRepository;

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void shouldCreateBlog(){
        UserCreationData userCreationData = new UserCreationData("user", "123", "123");
        ResponseEntity<Void> registersResponse = restTemplate.postForEntity("/api/users", userCreationData, Void.class);
        Assertions.assertThat(registersResponse.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        LoginData loginData = new LoginData("user", "123");
        ResponseEntity<LoginResponse> loginResponseResponseEntity = restTemplate.postForEntity("/api/auth/login", loginData, LoginResponse.class);
        Assertions.assertThat(loginResponseResponseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(loginResponseResponseEntity.getBody().getJwt()).isNotBlank();

        String jwt = loginResponseResponseEntity.getBody().getJwt();
        Blogs blogs = new Blogs("", "mutter");
        restTemplate.exchange("/api/blog",
                HttpMethod.POST,
                new HttpEntity<>(blogs, createHeader(jwt)),
                Void.class);

        List<Blogs> blogsList = blogsRepository.findAll();

        Blogs blogs1 = blogsList.get(0);
        Assertions.assertThat(blogs1.getAuthor()).isEqualTo("user");
        Assertions.assertThat(blogs1.getContent()).isEqualTo("mutter");

    }
    private HttpHeaders createHeader (String token) {
        HttpHeaders header = new HttpHeaders();
        header.set("Authorization", "Bearer " + token);
        return header;
    }

}
