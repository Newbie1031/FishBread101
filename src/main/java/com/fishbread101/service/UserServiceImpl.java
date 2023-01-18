package com.fishbread101.service;

import com.fishbread101.dto.LectureResponseDto;
import com.fishbread101.dto.ProfileModifyRequestDto;
import com.fishbread101.dto.ProfileResponseDto;
import com.fishbread101.entity.*;
import com.fishbread101.repository.ApplyRepository;
import com.fishbread101.repository.LectureRepository;
import com.fishbread101.dto.ProfileModifyRequestDto;
import com.fishbread101.dto.ProfileResponseDto;
import com.fishbread101.entity.User;
import com.fishbread101.repository.ApplyRepository;
import com.fishbread101.repository.EnrolmentRepository;
import com.fishbread101.repository.LectureRepository;
import com.fishbread101.dto.UserResponseDto;
import com.fishbread101.entity.User;
import com.fishbread101.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Transactional
    public ProfileResponseDto getProfile(User user) {
        String nickname = user.getNickname();
        String image = user.getImage();
        String description = user.getDescription();
        return new ProfileResponseDto(nickname, image, description);
    }

    @Override
    @Transactional
    public void modifyProfile (ProfileModifyRequestDto profileModifyRequestDto, User user){
        user.modify(profileModifyRequestDto);
        userRepository.save(user);
    }

    //튜터 정보 조회
    @Override
    @Transactional(readOnly = true)
    public UserResponseDto getTutorProfile(Long tutorId) {
        User user = userRepository.findById(tutorId).orElseThrow();
        return new UserResponseDto(user);
    }

    // 전체 튜티 목록 조회
    @Override
    @Transactional
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
    @Transactional
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
    @Transactional
    public List<UserResponseDto> getPromotionList() {
        List<User> list = userRepository.findByAppliedTutor(true);
        List<UserResponseDto> userResponseDtoList = new ArrayList<>();
        for (User user : list) {
            userResponseDtoList.add(new UserResponseDto(user));
        }
        return userResponseDtoList;
    }

    @Override
    @Transactional
    public void registerPromotion(User user) {
        user.changeApplyStatus(true);
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


}
