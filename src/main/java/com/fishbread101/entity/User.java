package com.fishbread101.entity;

import com.fishbread101.common.TimeStamp;
import com.fishbread101.dto.ProfileModifyRequestDto;
import com.fishbread101.dto.SignUpRequestDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends TimeStamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String loginId;

    private String loginPw;

    private String nickname;

    private String image;

    private String description;

    private UserRole userRole;

    private Boolean appliedTutor;

    @OneToMany(mappedBy = "tutee", cascade = CascadeType.REMOVE)
    private List<Enrolment> enrolmentList = new ArrayList<>(); // 강의 수강 - 수강이 확정된 상태 - 튜터가 허락해줌

    @OneToMany(mappedBy = "tutee", cascade = CascadeType.REMOVE)
    private List<Apply> applyList = new ArrayList<>(); // 강의 신청 - 수강이 확정된 상태가 아님 - 튜터가 허락 해줘야함

    @OneToMany(mappedBy = "tutor", cascade = CascadeType.REMOVE)
    private List<Lecture> myLectures = new ArrayList<>(); // 튜터일때, 자신이 생성한 강의들

    public void modify(ProfileModifyRequestDto profileModifyRequestDto) {
        this.nickname = profileModifyRequestDto.getNickname();
        this.image = profileModifyRequestDto.getImage();
        this.description = profileModifyRequestDto.getDescription();
    }


    public User(String loginId, String encodedPw) {
        this.loginId = loginId;
        this.loginPw = encodedPw;
        this.nickname = "";
        this.image = "";
        this.description = "";
        this.userRole = UserRole.TUTEE;
        appliedTutor = false;
    }

    public void changeRole(UserRole role) {
        this.userRole = role;
    }

    public void changeApplyStatus(Boolean appliedTutor) {
        this.appliedTutor = appliedTutor;
    }

}
