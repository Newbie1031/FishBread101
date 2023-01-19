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
public class LectureServiceImpl implements LectureService {

    private final LectureRepository lectureRepository;

    //모든 강의 조회
    @Transactional(readOnly = true)
    @Override
    public List<LectureResponseDto> getAllLectures() {
        List<LectureResponseDto> lectureResponseDtoList = new ArrayList<>();
        List<Lecture> lectures = lectureRepository.findAll();

        for (Lecture lecture: lectures) {
            lectureResponseDtoList.add(new LectureResponseDto(lecture.getTutor().getNickname(), lecture.getImage(), lecture.getDescription(), lecture.getCapacity()));
        }
        return lectureResponseDtoList;
    }


    @Override
    @Transactional // 200 OK
    public void createLecture(LectureRequestDto lectureRequestDto, User user) {
        Lecture lecture = new Lecture(lectureRequestDto, user);
        lectureRepository.save(lecture);
    }

    @Override
    @Transactional
    public void updateLecture(Long lectureId, LectureModifyRequestDto lectureModifyRequestDto, User user) {
        Lecture lecture = lectureRepository.findById(lectureId).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 강의입니다.")
        );

        if(lecture.getTutor().equals(user)) {
            // 정상 로직
            lecture.changeLectureStatus(lectureModifyRequestDto);
            lectureRepository.save(lecture);
        } else {
            // 당신이 만든 강의가 아닙니다 exception
            throw new IllegalArgumentException("수정할 수 없는 강의입니다.");
        }

    }

    // 튜터 나 자신이 만든 모든 강의를 가져오기.
    @Override
    @Transactional
    public List<LectureResponseDto> getMyLectures(User user, int page, int size, String sortBy, boolean isAsc) {  // 메소드명 수정
        // 페이징 처리
        Sort.Direction direction = isAsc ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sort = Sort.by(direction, sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);

        Page<Lecture> lectureList = lectureRepository.findAllByTutor(user, pageable); // 이 프로젝트내에 있는 내가 만든 강의 다 긁어옴
        List<LectureResponseDto> result = new ArrayList<>();

        for (Lecture lecture : lectureList) {
            LectureResponseDto dto = new LectureResponseDto(lecture.getTutor().getNickname(), lecture.getImage(), lecture.getDescription(), lecture.getCapacity());
            result.add(dto);
        }

        return result;
    }
    // 페이징 처리 전 코드
//    public List<LectureResponseDto> getMyLectures(User user) {  // 메소드명 수정
//        List<Lecture> lectureList = lectureRepository.findAllByTutor(user); // 이 프로젝트내에 있는 내가 만든 강의 다 긁어옴
//        List<LectureResponseDto> result = new ArrayList<>();
//
//        for (Lecture lecture : lectureList) {
//            LectureResponseDto dto = new LectureResponseDto(lecture.getTutor().getNickname(), lecture.getImage(), lecture.getDescription(), lecture.getCapacity());
//            result.add(dto);
//        }
//
//        return result;
//    }

    @Override
    @Transactional
    public void deleteLecture(Long lectureId, User user) {   // 메소드명 수정
        Lecture lecture = lectureRepository.findById(lectureId).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 강의입니다.")
        );
        if(lecture.getTutor().equals(user)) {
            // 정상 로직
            lectureRepository.delete(lecture);
        } else {
            throw new IllegalArgumentException("삭제할 수 없는 강의입니다.");
            // 당신이 만든 강의가 아닙니다 exception
        }
    }

}
