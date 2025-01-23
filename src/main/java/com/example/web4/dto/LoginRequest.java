package com.example.web4.dto;

import com.example.web4.domain.User;
import com.example.web4.utils.PasswordUtils;
import lombok.Data;

@Data
public class LoginRequest {
    private final String login;
    private final String password;

    public static LoginRequest toDTO(User user){
        return new LoginRequest(
                user.getLogin(),
                user.getPassword()
        );
    }

    public static User toDomainObject(LoginRequest loginRequest){
        return User.builder()
                .login(loginRequest.getLogin())
                .password(PasswordUtils.hashPassword(loginRequest.getPassword()))
                .build();
    }
}
