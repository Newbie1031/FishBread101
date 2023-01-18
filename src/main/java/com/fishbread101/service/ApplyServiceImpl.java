package com.fishbread101.service;

import com.fishbread101.entity.Apply;
import com.fishbread101.entity.Lecture;
import com.fishbread101.entity.User;
import com.fishbread101.repository.ApplyRepository;
import com.fishbread101.repository.LectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ApplyServiceImpl implements ApplyService {

    private final LectureRepository lectureRepository;
    private final ApplyRepository applyRepository;

    @Override
    public void refuseApply(Long applyId) {

    }

    @Override
    public void acceptApply(Long id) {

    }

    //튜티 수강 신청
    @Transactional
    @Override
    public void applyLecture(Long lectureId, User user) {
        Lecture lecture = lectureRepository.findById(lectureId).orElseThrow(() -> new IllegalArgumentException("없는 강의입니다."));
        // lecture에다가 user를 등록시켜주는게아니라
        // Enrolment라는 객체 => 수강이 확정되었을(수강신청 요청을 튜터가 수락했을때)
        // Apply라는 객체 => 수강신청을 요청했을때
        Apply apply = new Apply(user, lecture);
        applyRepository.save(apply);
    }
}
