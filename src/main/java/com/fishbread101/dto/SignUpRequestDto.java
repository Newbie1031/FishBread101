package com.fishbread101.dto;

import com.fishbread101.entity.UserRole;
import lombok.Getter;

@Getter
public class SignUpRequestDto {
    private String loginId;
    private String loginPw;
}
