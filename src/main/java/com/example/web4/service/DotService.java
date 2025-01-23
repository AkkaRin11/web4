package com.example.web4.service;

import com.example.web4.domain.Dot;

import java.util.List;

public interface DotService {
    List<Dot> getLastDots();
    void addDot(Dot dot);
}
