package com.fishbread101.service;

import com.fishbread101.common.security.UserDetailsImpl;
import com.fishbread101.dto.LectureModifyRequestDto;
import com.fishbread101.dto.LectureRequestDto;
import com.fishbread101.dto.LectureResponseDto;
import com.fishbread101.entity.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface LectureService {

    void createLecture(LectureRequestDto lectureRequestDto, User user);

    void updateLecture(Long lectureId, LectureModifyRequestDto lectureRequestDto, User user);

    void deleteLecture(Long lectureId, User user);

    List<LectureResponseDto> getMyLectures(User user, int page, int size, String sortBy, boolean isAsc);
    // 페이징 처리 전 코드
//    List<LectureResponseDto> getMyLectures(User user);

    List<LectureResponseDto> getAllLectures(int page, int size, String sortBy, boolean isAsc);
}
