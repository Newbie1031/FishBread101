package com.fishbread101.service;

import com.fishbread101.entity.Apply;
import com.fishbread101.entity.Enrolment;
import com.fishbread101.entity.Lecture;
import com.fishbread101.entity.User;
import com.fishbread101.repository.ApplyRepository;
import com.fishbread101.repository.EnrolmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ApplyServiceImpl implements ApplyService {

    private final ApplyRepository applyRepository;
    private final EnrolmentRepository enrolmentRepository;

    @Transactional
    public void allowApply(Long id) {
        Apply apply = applyRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("없는 신청"));
        Lecture lecture = apply.getLecture();
        User tutee = apply.getTutee();
        Enrolment enrolment = new Enrolment(tutee, lecture);
        enrolmentRepository.save(enrolment);
    }

    @Transactional
    public void refuseApply(Long applyId) {
        Apply apply = applyRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("없는 신청"));
        applyRepository.delete(apply);
    }

}
