package com.github.waymaker7.capstone.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserServiceTest {
    @Test
    void shouldCreateNewUser(){
        //Given
        UserRepository userRepository = Mockito.mock(UserRepository.class);
        PasswordEncoder passwordEncoder = Mockito.mock(PasswordEncoder.class);
        Mockito.when(passwordEncoder.encode("password")).thenReturn("hashedPassword");
        UserCreationDTO userCreationDTO = new UserCreationDTO("testUser", "password", "password");
        UserService userService = new UserService(userRepository, passwordEncoder);

        //when
        userService.createNewUser(userCreationDTO);

        //then
        User expectedUser = new User();
        expectedUser.setUsername("textUser");
        expectedUser.setPassword("hashedPassword");
        Mockito.verify(userRepository).save(expectedUser);
    }

    @Test
    void shouldNotCreateNewUser_passwordsDoNotMatch(){
        //Given
        UserCreationDTO userCreationDTO = new UserCreationDTO("testUser", "password", "passw0rd");
        UserService userService = new UserService(null, null);

        //when
        userService.createNewUser(userCreationDTO);

        //then
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() ->userService.createNewUser(userCreationDTO))
                .withMessage("passwords do not match");
    }
}
