package com.example.web4.repository;

import com.example.web4.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    boolean existsByLogin(String login);
    boolean existsByLoginAndPassword(String login, String password);
    User findByLogin(String login);
}
