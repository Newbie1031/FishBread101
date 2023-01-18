package com.fishbread101.dto;

import lombok.Getter;

@Getter
public class ProfileResponseDto {

    private Long id;
    private String loginId;
    private String nickname;
    private String image;
    private String description;

    public ProfileResponseDto(String nickname, String image, String description) {
        this.nickname = nickname;
        this.image = image;
        this.description = description;
    }
}
