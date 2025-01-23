package com.example.web4.dto;

import com.example.web4.domain.Dot;
import com.example.web4.domain.User;
import com.example.web4.service.Validation;
import com.example.web4.utils.PasswordUtils;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class DotDTO {
    private final double x;
    private final double y;
    private final double r;

    public static DotDTO toDTO(Dot dot){
        return new DotDTO(
                dot.getX(),
                dot.getY(),
                dot.getR()
        );
    }

    public static Dot toDomainObject(DotDTO dotDTO, User user, Long time_start){
        return Dot.builder()
                .result(Validation.isHit(dotDTO.x, dotDTO.y, dotDTO.r))
                .x(dotDTO.getX())
                .y(dotDTO.getY())
                .r(dotDTO.getR())
                .time(new Timestamp(System.currentTimeMillis()))
                .workTime(String.valueOf(System.currentTimeMillis() - time_start))
                .userId(user)
                .build();
    }
}
