package com.example.web4.controller;

import com.example.web4.domain.Dot;
import com.example.web4.domain.User;
import com.example.web4.dto.DotDTO;
import com.example.web4.service.DotService;
import com.example.web4.service.DotServiceImpl;
import com.example.web4.service.UserService;
import com.example.web4.service.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.web4.utils.JwtUtils.getIdFromToken;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class DataController {
    private final DotServiceImpl dotService;
    private final UserServiceImpl userService;

    @GetMapping("/dots")
    public ResponseEntity<List<Dot>> getDots(){
        return ResponseEntity.ok(dotService.getLastDots());
    }

    @PostMapping("/dot")
    public ResponseEntity<List<Dot>> putDot(HttpServletRequest request, @RequestBody DotDTO dotDTO){
        String authHeader = request.getHeader("Authorization");
        String token = authHeader.substring(7);
        User user = userService.getById(getIdFromToken(token));

        dotService.addDot(DotDTO.toDomainObject(dotDTO, user, System.currentTimeMillis()));
        return ResponseEntity.ok(dotService.getLastDots());
    }
}