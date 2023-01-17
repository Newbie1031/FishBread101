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
//        User user = new User(profileModifyRequestDto);
        user.changeProfile(profileModifyRequestDto); // 등록될테고,
        userRepository.save(user); // 변경사항이 반영된다.
        return new ProfileResponseDto();
    }

    @Transactional
    public ProfileResponseDto getProfile(User user) {
        Long id = user.getId();
        String loginId = user.getLoginId();
        String nickname = user.getNickname();
        return new ProfileResponseDto(id, loginId, nickname);
    }
}
