package com.example.web4.service;

import com.example.web4.domain.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    boolean signUp(User user);
    List<User> getAll();
    User getById(UUID id);
    void deleteById(UUID id);
    boolean existsByLogin(String login);
    User getByLogin(String login);
}
