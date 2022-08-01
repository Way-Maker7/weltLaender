package com.github.waymaker7.capstone.user;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class UserServiceTest {
    @Test
    void shouldCreateNewUser(){
        //Given
        UserRepository userRepository = Mockito.mock(UserRepository.class);
        UserCreationDTO userCreationDTO = new UserCreationDTO("testUser", "password", "password");
        UserService userService = new UserService(userRepository);

        //when
        userService.createNewUser(userCreationDTO);
    }
}
