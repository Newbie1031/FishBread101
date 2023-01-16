package com.fishbread101.user.entity;

import com.fishbread101.apply.entity.Apply;
import com.fishbread101.common.TimeStamp;
import com.fishbread101.enrolment.entity.Enrolment;
import com.fishbread101.lecture.entity.Lecture;
import lombok.Getter;

import javax.persistence.*;
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

    private boolean appliedTutor;

    @OneToMany(mappedBy = "tutee", cascade = CascadeType.REMOVE)
    private List<Enrolment> enrolmentList; // 강의 수강 - 수강이 확정된 상태 - 튜터가 허락해줌

    @OneToMany(mappedBy = "tutee", cascade = CascadeType.REMOVE)
    private List<Apply> applyList; // 강의 신청 - 수강이 확정된 상태가 아님 - 튜터가 허락 해줘야함

    @OneToMany(mappedBy = "tutor", cascade = CascadeType.REMOVE)
    private List<Lecture> myLectures; // 튜터일때, 자신이 생성한 강의들

}
