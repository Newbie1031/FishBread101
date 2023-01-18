package com.fishbread101.dto;

import com.fishbread101.entity.User;
import lombok.Getter;

@Getter
public class LectureResponseDto {
    private User tutor;
    private String image;
    private String description;
    private int capacity;

    public LectureResponseDto(User tutor, String image, String description, int capacity) {
        this.tutor = tutor;
        this.image = image;
        this.description = description;
        this.capacity = capacity;
    }
}
