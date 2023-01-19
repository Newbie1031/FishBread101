package com.fishbread101.service;

import com.fishbread101.common.security.UserDetailsImpl;
import com.fishbread101.dto.LectureModifyRequestDto;
import com.fishbread101.dto.LectureRequestDto;
import com.fishbread101.dto.LectureResponseDto;
import com.fishbread101.entity.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface LectureService {

    List<LectureResponseDto> getAllLectures();

    void createLecture(LectureRequestDto lectureRequestDto, User user);

    void updateLecture(Long lectureId, LectureModifyRequestDto lectureRequestDto, User user);

    void deleteLecture(Long lectureId, User user);

    List<LectureResponseDto> getMyLectures(User user);

    Page<LectureResponseDto> getAllLectures(int i, int size, String sortBy, boolean isAsc);
}
