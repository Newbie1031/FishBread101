package com.fishbread101.service;

import com.fishbread101.dto.ProfileModifyRequestDto;
import com.fishbread101.dto.ProfileResponseDto;
import com.fishbread101.entity.User;
import com.fishbread101.repository.ApplyRepository;
import com.fishbread101.repository.EnrolmentRepository;
import com.fishbread101.repository.LectureRepository;
import com.fishbread101.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Transactional
    public ProfileResponseDto modifyProfile(ProfileModifyRequestDto profileModifyRequestDto, User user) {
        User user = new User(profileModifyRequestDto);
        userRepository.save(user);
        return new ProfileResponseDto();
    }

    @Transactional
    public ProfileResponseDto getProfile(User user) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 사용자입니다.")
        );
        return new ProfileResponseDto();
    }
}
