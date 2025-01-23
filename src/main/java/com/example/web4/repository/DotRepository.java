package com.example.web4.repository;

import com.example.web4.domain.Dot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface DotRepository extends JpaRepository<Dot, UUID> {
    List<Dot> findTop10ByOrderByTimeDesc();
    List<Dot> findTop10ByUserIdOrderByTimeDesc();
}
