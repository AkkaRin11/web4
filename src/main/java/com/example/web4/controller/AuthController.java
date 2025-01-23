package com.example.web4.controller;

import com.example.web4.domain.User;
import com.example.web4.dto.LoginRequest;
import com.example.web4.service.UserService;
import com.example.web4.utils.JwtUtils;
import com.example.web4.utils.PasswordUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/auth")
public class AuthController {
    private final UserService userService;

    @PostMapping("/sign_up")
    public ResponseEntity<String> signUp(@RequestBody LoginRequest loginRequest){
        User user = LoginRequest.toDomainObject(loginRequest);

        if (userService.signUp(user)){
            String token = JwtUtils.generateToken(user.getId());
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User with this login already exists");
        }
    }

    @PostMapping("/sign_in")
    public ResponseEntity<String> signIn(@RequestBody LoginRequest loginRequest){
        if (userService.existsByLogin(loginRequest.getLogin())){
            User user = userService.getByLogin(loginRequest.getLogin());

            if (PasswordUtils.verifyPassword(loginRequest.getPassword(), user.getPassword())){
                String token = JwtUtils.generateToken(user.getId());
                return ResponseEntity.ok(token);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect password");
            }
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User with this login does not exist");
        }
    }
}
