package com.fishbread101.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class LectureRequestDto {
    @NotBlank(message = "닉네임을 입력해주세요.")
    private String nickname;
    @NotBlank(message = "이미지를 추가해주세요.")
    private String image;
    @NotBlank(message = "소개글을 추가해주세요.")
    private String description;
    @NotBlank(message = "수강 정원을 추가해주세요.")
    private int capacity;
    private LocalDateTime createAt;
}
