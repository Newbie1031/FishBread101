package com.fishbread101.dto;

import com.fishbread101.entity.Lecture;
import com.fishbread101.entity.User;

import lombok.Getter;

@Getter
public class LectureResponseDto {
    private String tutorName;
    private String image;
    private String description;
    private int capacity;
    public LectureResponseDto(String tutorName, String image, String description, int capacity) {
        this.tutorName = tutorName;
        this.image = image;
        this.description = description;
        this.capacity = capacity;
    }
}
