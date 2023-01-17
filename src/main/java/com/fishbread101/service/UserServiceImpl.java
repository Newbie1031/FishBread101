package com.fishbread101.service;

<<<<<<< HEAD
import com.fishbread101.dto.LectureResponseDto;
import com.fishbread101.dto.ProfileModifyRequestDto;
import com.fishbread101.dto.ProfileResponseDto;
import com.fishbread101.entity.Lecture;
import com.fishbread101.entity.User;
import com.fishbread101.repository.LectureRepository;
=======
import com.fishbread101.dto.ProfileModifyRequestDto;
import com.fishbread101.dto.ProfileResponseDto;
import com.fishbread101.dto.UserResponseDto;
import com.fishbread101.entity.User;
import com.fishbread101.entity.UserRole;
>>>>>>> c2ce1a3c2b839204bdc4df3e4b509acb21c0f300
import com.fishbread101.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final LectureRepository lectureRepository;

    //튜티 프로필 수정
    @Transactional
    @Override
    public void modifyProfile (ProfileModifyRequestDto profileModifyRequestDto, User user){
        user.modify(profileModifyRequestDto);
        userRepository.save(user);
    }

    //튜티 프로필 조회(개인 프로필)
    @Transactional
    @Override
    public ProfileResponseDto getProfile(User user) {
        ProfileResponseDto result = new ProfileResponseDto(user.getNickname(), user.getImage(), user.getDescription());
        return result;
    }

    //튜티가 신청한 모든 강의 조회
    @Transactional(readOnly = true)
    public List<LectureResponseDto> getAllLectures() {
        List<LectureResponseDto> lectureResponseDtoList = new ArrayList<>();
        List<Lecture> lectures = lectureRepository.findAllByLecturesId();

        for (Lecture lecture: lectures) {
            lectureResponseDtoList.add(new LectureResponseDto(lecture));
        }
        return lectureResponseDtoList;

    }

    
    // 전체 튜티 목록 조회
    @Override
    public List<UserResponseDto> getTuteeList() {
        List<User> list = userRepository.findByUserRole(UserRole.TUTEE);
        List<UserResponseDto> userResponseDtoList = new ArrayList<>();
        for (User user : list) {
            userResponseDtoList.add(new UserResponseDto(user));
        }
        return userResponseDtoList;
    }

//    전체 튜터 목록 조회
    @Override
    public List<UserResponseDto> getAllTutors() {
        List<User> list = userRepository.findByUserRole(UserRole.TUTOR);
        List<UserResponseDto> userResponseDtoList = new ArrayList<>();
        for (User user : list) {
            userResponseDtoList.add(new UserResponseDto(user));
        }
        return userResponseDtoList;
    }

//    전체 튜터 신청 목록 조회
    @Override
    public List<UserResponseDto> getPromotionList() {
        List<User> list = userRepository.findByAppliedTutor(true);
        List<UserResponseDto> userResponseDtoList = new ArrayList<>();
        for (User user : list) {
            userResponseDtoList.add(new UserResponseDto(user));
        }
        return userResponseDtoList;
    }

    @Override
    public void registerPromotion(User user) {
    }

//    튜터 신청 승인
    @Override
    @Transactional
    public void allowPromotion(Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        if (user.getAppliedTutor().equals(true)) {
            user.changeRole(UserRole.TUTOR);
            user.changeApplyStatus(false);
        } else {
            throw new IllegalArgumentException("신청되지 않은 사용자입니다.");
        }
    }

//    튜터 신청 거부
    @Override
    @Transactional
    public void refusePromotion(Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        if (user.getAppliedTutor().equals(true)) {
            user.changeApplyStatus(false);
        } else {
            throw new IllegalArgumentException("신청되지 않은 사용자입니다.");
        }
    }

    @Override
    public UserResponseDto getTutorProfile(Long tutorId) {
        return null;
    }
>>>>>>> c2ce1a3c2b839204bdc4df3e4b509acb21c0f300
}
