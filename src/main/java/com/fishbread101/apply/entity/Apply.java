package com.fishbread101.apply.entity;

import com.fishbread101.lecture.entity.Lecture;
import com.fishbread101.user.entity.User;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Apply {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tutee_id") // fk 값 컬럼 명 지정
    private User tutee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lecture_id") // fk값으로 변경될거고
    private Lecture lecture;
}
