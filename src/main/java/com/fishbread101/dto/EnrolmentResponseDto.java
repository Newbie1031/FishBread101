package com.fishbread101.dto;

import com.fishbread101.entity.Enrolment;
import com.fishbread101.entity.User;
import lombok.Getter;

@Getter
public class EnrolmentResponseDto {
    private Long id;
    private String tuteeName;

    public EnrolmentResponseDto(Long id, String tuteeName) {
        this.id = id;
        this.tuteeName = tuteeName;
    }
}
