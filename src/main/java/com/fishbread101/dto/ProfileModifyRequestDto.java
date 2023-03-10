package com.fishbread101.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProfileModifyRequestDto {
    @NotBlank(message = "닉네임을 입력하세요.")
    private String nickname;
    @NotBlank(message = "이미지를 추가하세요.")
    private String image;
    @NotBlank(message = "소개글을 입력하세요.")
    private String description;
}
