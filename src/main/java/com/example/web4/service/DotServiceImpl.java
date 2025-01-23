package com.example.web4.service;

import com.example.web4.domain.Dot;
import com.example.web4.repository.DotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DotServiceImpl implements DotService {
    private final DotRepository dotRepository;

    @Override
    public List<Dot> getLastDots() {
        return dotRepository.findTop10ByOrderByTimeDesc();
    }

    @Override
    public void addDot(Dot dot) {
        dotRepository.save(dot);
    }
}
