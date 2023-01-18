package com.fishbread101.service;

import com.fishbread101.common.security.UserDetailsImpl;
import com.fishbread101.dto.LectureModifyRequestDto;
import com.fishbread101.dto.LectureRequestDto;
import com.fishbread101.dto.LectureResponseDto;
import com.fishbread101.entity.Lecture;
import com.fishbread101.entity.User;
import com.fishbread101.repository.LectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LectureServiceImpl implements LectureService {

    private final LectureRepository lectureRepository;

    //모든 강의 조회
    @Transactional(readOnly = true)
    @Override
    public List<LectureResponseDto> getAllLectures() {
        List<LectureResponseDto> lectureResponseDtoList = new ArrayList<>();
        List<Lecture> lectures = lectureRepository.findAll();

        for (Lecture lecture: lectures) {
            lectureResponseDtoList.add(new LectureResponseDto(lecture));
        }
        return lectureResponseDtoList;
    }

    @Override
    public LectureResponseDto createLecture(LectureRequestDto lectureRequestDto, User user) {
        return null;
    }

    @Override
    public LectureResponseDto updateLecture(Long lectureId, LectureModifyRequestDto lectureRequestDto, User user) {
        return null;
    }

    @Override
    public void delete(Long lectureId, UserDetailsImpl userDetails) {

    }

    @Override
    public List<LectureResponseDto> getMyLectures(User user) {
        return null;
    }
}
