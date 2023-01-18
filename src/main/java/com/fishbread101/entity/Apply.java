package com.fishbread101.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    public Apply(User tutee, Lecture lecture) {
        this.tutee = tutee;
        this.lecture = lecture;
    }

}
