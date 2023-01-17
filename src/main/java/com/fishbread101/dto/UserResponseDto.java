package com.fishbread101.dto;

import com.fishbread101.entity.User;
import com.fishbread101.entity.UserRole;
import lombok.Getter;

@Getter
public class UserResponseDto {
    private Long id;
    private UserRole userRole;
    private String nickname;
    private Boolean appliedTutor;

    public UserResponseDto(User user) {
        this.id = user.getId();
        this.userRole = user.getUserRole();
        this.nickname = user.getNickname();
        this.appliedTutor = user.getAppliedTutor();
    }

}
