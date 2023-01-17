package com.fishbread101.entity;

import com.fishbread101.common.TimeStamp;

import javax.persistence.*;

@Entity
public class Enrolment extends TimeStamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tutee_id") // fk 값 컬럼 명 지정
    private User tutee; // fk값으로 변환될 예정

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lecture_id") // fk값으로 변경될거고
    private Lecture lecture;

}
