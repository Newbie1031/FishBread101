package com.fishbread101.service;

import com.fishbread101.dto.EnrolmentResponseDto;
import com.fishbread101.entity.Enrolment;
import com.fishbread101.entity.Lecture;
import com.fishbread101.repository.EnrolmentRepository;
import com.fishbread101.repository.LectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EnrolmentServiceImpl implements EnrolmentService {

    private final LectureRepository lectureRepository;
    private final EnrolmentRepository enrolmentRepository;

    @Transactional
    public List<EnrolmentResponseDto> getMyLecturesEnrolment(Long lectureId, int page, int size, String sortBy, boolean isAsc) {

        Sort.Direction direction = isAsc ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sort = Sort.by(direction, sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);

        Lecture lecture = lectureRepository.findById(lectureId).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 강의입니다.")
        );

        Page<Enrolment> enrolmentList = enrolmentRepository.findAllByLecture(lecture, pageable);
        // 페이징처리는 JPA에서 제공해주는 기능

//        List<Enrolment> enrolmentList = lecture.getEnrolmentList(); // 페이징 처리가 불가능하다.

        List<EnrolmentResponseDto> result = new ArrayList<>();
        for (Enrolment enrolment : enrolmentList) {
            EnrolmentResponseDto dto = new EnrolmentResponseDto(enrolment.getTutee().getId(), enrolment.getTutee().getNickname());
            result.add(dto);
        }
        return result;
    }

}
