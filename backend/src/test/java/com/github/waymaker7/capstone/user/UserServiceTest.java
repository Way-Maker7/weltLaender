package com.github.waymaker7.capstone.user;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;
import org.mockito.Mockito;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserServiceTest {
    @Test
    void shouldCreateNewUser(){
        //Given
        UserRepository userRepository = Mockito.mock(UserRepository.class);
        PasswordEncoder passwordEncoder = Mockito.mock(PasswordEncoder.class);
        Mockito.when(passwordEncoder.encode("password")).thenReturn("hashedPassword");
        UserCreationData userCreationData = new UserCreationData("testUser", "password", "password");
        UserService userService = new UserService(userRepository, passwordEncoder);

        //when
        userService.createNewUser(userCreationData);

        //then
        User expectedUser = new User();
        expectedUser.setUsername("testUser");
        expectedUser.setPassword("hashedPassword");
        Mockito.verify(userRepository).save(expectedUser);
    }

    @Test
    void shouldNotCreateNewUser_passwordsDoNotMatch(){
        //Given
        UserCreationData userCreationData = new UserCreationData("testUser", "password", "passw0rd");
        UserService userService = new UserService(null, null);

        //when
       // userService.createNewUser(userCreationData);

        //then
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() ->userService.createNewUser(userCreationData))
                .withMessage("passwords do not match");
    }

    @Test
    void shouldNotCreateNewUser_usernameIsBlank(){
        //Given
        UserCreationData userCreationData = new UserCreationData(" ", "password", "password");
        UserService userService = new UserService(null, null);

        //when
        //userService.createNewUser(userCreationData);

        //then
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() ->userService.createNewUser(userCreationData))
                .withMessage("username is blank");
    }

    @Test
    void shouldNotCreateNewUser_usernameIsNull(){
        //Given
        UserCreationData userCreationData = new UserCreationData(null, "password", "password");
        UserService userService = new UserService(null, null);

        //when
        //userService.createNewUser(userCreationData);

        //then
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() ->userService.createNewUser(userCreationData))
                .withMessage("username is blank");
    }
}
