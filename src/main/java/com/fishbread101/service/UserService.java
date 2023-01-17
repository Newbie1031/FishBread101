package com.fishbread101.service;

import com.fishbread101.dto.*;
import com.fishbread101.entity.User;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface UserService {

    UserResponseDto signUp(SignUpRequestDto signupRequestDto);

    UserResponseDto signIn(SignInRequestDto signInRequestDto, HttpServletResponse response);

    void signOut(User user);

    ProfileResponseDto getProfile(User user);

    ProfileResponseDto modifyProfile(ProfileModifyRequestDto profileModifyRequestDto, User user);

    List<UserResponseDto> getTuteeList();

    List<UserResponseDto> getAllTutors();

    List<UserResponseDto> getTutorApplyList();

    void applyTutor(User user);

    void allowTutorApply(Long userId);

    void refuseTutorApply(Long userId);

    UserResponseDto getTutorProfile(Long tutorId);

}
