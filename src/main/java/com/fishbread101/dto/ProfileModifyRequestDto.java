package com.fishbread101.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProfileModifyRequestDto {

    private String nickname;
    private String image;
    private String description;

}
