package com.fishbread101.dto;

import com.fishbread101.entity.User;
import lombok.Getter;

@Getter
public class EnrolmentResponseDto {
    private User tutor;
    private String image;
    private String description;
    private int capacity;
}
