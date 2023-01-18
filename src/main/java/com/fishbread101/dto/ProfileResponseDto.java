package com.fishbread101.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProfileResponseDto {

    private Long id;
    private String loginId;
    private String nickname;
    private String image;
    private String description;

}
