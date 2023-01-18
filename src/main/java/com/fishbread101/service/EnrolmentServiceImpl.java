package com.fishbread101.service;

import com.fishbread101.dto.EnrolmentResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnrolmentServiceImpl implements EnrolmentService {

    @Override
    public List<EnrolmentResponseDto> getMyLecturesEnrolment(Long lectureId) {
        return null;
    }
}
