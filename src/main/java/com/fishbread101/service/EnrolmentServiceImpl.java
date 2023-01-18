package com.fishbread101.service;

import com.fishbread101.dto.EnrolmentResponseDto;
import com.fishbread101.entity.Enrolment;
import com.fishbread101.entity.Lecture;
import com.fishbread101.repository.EnrolmentRepository;
import com.fishbread101.repository.LectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnrolmentServiceImpl implements EnrolmentService {

    private final LectureRepository lectureRepository;
    private final EnrolmentRepository enrolmentRepository;

    @Transactional
    public List<EnrolmentResponseDto> getMyLecturesEnrolment(Long lectureId) {
//        List<Enrolment> enrolmentList = enrolmentRepository.findById(lectureId).orElseThrow(
//                () -> new IllegalArgumentException("존재하지 않는 강의입니다.")
//        )
        Lecture lecture = lectureRepository.findById(lectureId).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 강의입니다.")
        );
        List<Enrolment> enrolmentList = lecture.getEnrolmentList();
        List<EnrolmentResponseDto> result = new ArrayList<>();
        for (Enrolment enrolment : enrolmentList) {
            EnrolmentResponseDto dto = new EnrolmentResponseDto(enrolment.getTutee().getId(), enrolment.getTutee().getNickname());
            result.add(dto);
        }
//        List<Enrolment> enrolmentList = lecture.getEnrolmentList();
//        enrolmentList => enrlmentResponseDtoList 로 변환해서 return
//        return ();
        return result;
    }
}
