package com.fishbread101.lecture.entity;

import com.fishbread101.apply.entity.Apply;
import com.fishbread101.enrolment.entity.Enrolment;
import com.fishbread101.user.entity.User;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Table(name = "lectures")
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tutor_id")
    private User tutor;

    private String description;

    private String image;

    private Integer capacity;

    @OneToMany(mappedBy = "lecture", cascade = CascadeType.REMOVE)
    private List<Enrolment> enrolmentList;

    @OneToMany(mappedBy = "lecture", cascade = CascadeType.REMOVE)
    private List<Apply> applyList;
}
