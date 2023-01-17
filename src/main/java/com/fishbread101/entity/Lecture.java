package com.fishbread101.entity;

import com.fishbread101.dto.LectureModifyRequestDto;
import com.fishbread101.dto.LectureRequestDto;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
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
    private List<Enrolment> enrolmentList = new ArrayList<>();

    @OneToMany(mappedBy = "lecture", cascade = CascadeType.REMOVE)
    private List<Apply> applyList = new ArrayList<>();

    public Lecture(LectureRequestDto lectureRequestDto, User user) {
        this.tutor = user;
        this.description = lectureRequestDto.getDescription();
        this.image = lectureRequestDto.getImage();
        this.capacity = lectureRequestDto.getCapacity();
    }

    public void changeLectureStatus(LectureModifyRequestDto lectureModifyRequestDto) {
        this.description = lectureModifyRequestDto.getDescription();
    }
}
