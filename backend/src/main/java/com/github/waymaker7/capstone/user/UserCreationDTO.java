package com.github.waymaker7.capstone.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreationDTO {
    private String userName;
    private String passWord;
    private String passwordRepeat;
}
