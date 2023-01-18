package com.fishbread101.service;

import com.fishbread101.entity.Apply;
import com.fishbread101.entity.Lecture;
import com.fishbread101.entity.User;
import com.fishbread101.repository.ApplyRepository;
import com.fishbread101.repository.LectureRepository;
import com.fishbread101.dto.ApplyResponseDto;
import com.fishbread101.entity.Enrolment;
import com.fishbread101.repository.EnrolmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ApplyServiceImpl implements ApplyService {

    private final LectureRepository lectureRepository;
    private final ApplyRepository applyRepository;
    private final EnrolmentRepository enrolmentRepository;

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
    
    @Transactional
    public void allowApply(Long id) {
        Apply apply = applyRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 신청 내용입니다.")
        );
        Lecture lecture = apply.getLecture();
        User tutee = apply.getTutee();
        Enrolment enrolment = new Enrolment(tutee, lecture);
        enrolmentRepository.save(enrolment);
    }

    @Transactional
    public void refuseApply(Long applyId) {
        Apply apply = applyRepository.findById(applyId).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 신청 내용입니다.")
        );
        applyRepository.delete(apply);
    }

}
