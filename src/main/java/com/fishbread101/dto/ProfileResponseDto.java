package com.fishbread101.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProfileResponseDto {
    private String nickname;
    private String image;
    private String description;
}
