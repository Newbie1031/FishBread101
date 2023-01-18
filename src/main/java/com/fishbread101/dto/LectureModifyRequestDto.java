package com.fishbread101.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LectureModifyRequestDto {
    private String nickname;
    private String image;
    private String description;
    private int capacity;

}
