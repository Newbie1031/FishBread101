package com.fishbread101.service;

import com.fishbread101.dto.EnrolmentResponseDto;

import java.util.List;

public interface EnrolmentService {
    List<EnrolmentResponseDto> getMyLecturesEnrolment(Long lectureId, int page, int size, String sortBy, boolean isAsc);
}
