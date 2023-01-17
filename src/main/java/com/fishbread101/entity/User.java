package com.fishbread101.entity;

import com.fishbread101.common.TimeStamp;
import com.fishbread101.dto.ProfileModifyRequestDto;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "users")
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

<<<<<<< HEAD
    public void modify(ProfileModifyRequestDto profileModifyRequestDto) {
        this.nickname = profileModifyRequestDto.getNickname();
        this.image = profileModifyRequestDto.getImage();
        this.description = profileModifyRequestDto.getDescription();
    }

=======
    public void changeRole(UserRole role) {
        this.userRole = role;
    }

    public void changeApplyStatus(Boolean appliedTutor) {
        this.appliedTutor = false;
    }
>>>>>>> c2ce1a3c2b839204bdc4df3e4b509acb21c0f300

}
