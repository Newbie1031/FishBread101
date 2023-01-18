package com.fishbread101.service;

import com.fishbread101.dto.*;
import com.fishbread101.entity.User;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface UserService {

    ProfileResponseDto getProfile(User user);

    void modifyProfile(ProfileModifyRequestDto profileModifyRequestDto, User user);

    List<UserResponseDto> getTuteeList();

    List<UserResponseDto> getAllTutors();

    List<UserResponseDto> getPromotionList();

    void registerPromotion(User user);

    void allowPromotion(Long userId);

    void refusePromotion(Long userId);

    UserResponseDto getTutorProfile(Long tutorId);

}
