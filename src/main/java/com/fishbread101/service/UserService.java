package com.fishbread101.service;

import com.fishbread101.dto.*;
import com.fishbread101.entity.User;
import com.fishbread101.entity.UserRole;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    ProfileResponseDto getProfile(User user);

    void modifyProfile(ProfileModifyRequestDto profileModifyRequestDto, User user);

    List<UserResponseDto> getTuteeList(int page, int size, String sortBy, boolean isAsc);

    List<UserResponseDto> getAllTutors(UserRole userRole, int page, int size, String sortBy, boolean isAsc);

    List<UserResponseDto> getPromotionList();

    void registerPromotion(User user);

    void allowPromotion(Long userId);

    void refusePromotion(Long userId);

    UserResponseDto getTutorProfile(Long tutorId);

}
