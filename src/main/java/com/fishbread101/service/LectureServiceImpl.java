package com.fishbread101.service;

import com.fishbread101.common.security.UserDetailsImpl;
import com.fishbread101.dto.LectureModifyRequestDto;
import com.fishbread101.dto.LectureRequestDto;
import com.fishbread101.dto.LectureResponseDto;
import com.fishbread101.entity.Lecture;
import com.fishbread101.entity.User;
import com.fishbread101.repository.ApplyRepository;
import com.fishbread101.repository.EnrolmentRepository;
import com.fishbread101.repository.LectureRepository;
import com.fishbread101.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LectureServiceImpl implements LectureService {
    private final LectureRepository lectureRepository;

    @Transactional
    public LectureResponseDto createLecture(LectureRequestDto lectureRequestDto, User user) {
        Lecture lecture = new Lecture(lectureRequestDto, user);
        lectureRepository.save(lecture);
        return new LectureResponseDto();
    }

    @Transactional
    public LectureResponseDto updateLecture(Long lectureId, LectureModifyRequestDto lectureModifyRequestDto, User user) {
        Lecture lecture = lectureRepository.findById(lectureId).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 강의입니다.")
        );

        if(lecture.getTutor().equals(user)) {
            // 정상 로직
        } else {
            // 당신이 만든 강의가 아닙니다 exception
        }

        lecture.changeLectureStatus(lectureModifyRequestDto);

        lectureRepository.update(lectureModifyRequestDto);

        return new LectureResponseDto();
    }

    @Transactional
    public List<LectureResponseDto> getMyLectures(User user) {  // 메소드명 수정
        List<Lecture> lectureList = lectureRepository.findAllByTutor(user); // 이 프로젝트내에 있는 모든 강의가 가져와짐
        for (Lecture lecture : lectureList) {
            lecture => lectureResponseDto
            list.add(lectureResponseDto);
        }
//        List<LectureResponseDto> lectureResponseDtoList = lectureList
        return list;
    }

    @Transactional
    public void deleteLecture(Long lectureId, User user) {   // 메소드명 수정
        Lecture lecture = lectureRepository.findById(lectureId).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 강의입니다.")
        );
        if(lecture.getTutor().equals(user)) {
            // 정상 로직
            lectureRepository.delete(lecture);
        } else {
            // 당신이 만든 강의가 아닙니다 exception
        }
    }

}
