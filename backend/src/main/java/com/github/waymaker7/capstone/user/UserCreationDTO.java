package com.github.waymaker7.capstone.user;

import lombok.Data;

@Data
public class UserCreationDTO {
    private String userName;
    private String passWord;
    private String passwordRepeat;
}
