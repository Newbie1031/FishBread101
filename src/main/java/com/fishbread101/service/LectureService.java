package com.fishbread101.service;

import com.fishbread101.common.security.UserDetailsImpl;
import com.fishbread101.dto.LectureModifyRequestDto;
import com.fishbread101.dto.LectureRequestDto;
import com.fishbread101.dto.LectureResponseDto;
import com.fishbread101.entity.User;

import java.util.List;

public interface LectureService {

    List<LectureResponseDto> getAllLectures();

    LectureResponseDto createLecture(LectureRequestDto lectureRequestDto, User user);

    LectureResponseDto updateLecture(Long lectureId, LectureModifyRequestDto lectureRequestDto, User user);

    void delete(Long lectureId, UserDetailsImpl userDetails);

    List<LectureResponseDto> getMyLectures(User user);

}
