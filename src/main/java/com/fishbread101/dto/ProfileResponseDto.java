package com.fishbread101.dto;

import lombok.Getter;

@Getter
public class ProfileResponseDto {

    private Long id;
    private String LoginId;
    private String nickname;

    public ProfileResponseDto(Long id, String loginId, String nickname) {
        this.id = id;
        LoginId = loginId;
        this.nickname = nickname;
    }
}
