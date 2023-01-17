package com.fishbread101.service;

import com.fishbread101.dto.LectureResponseDto;
import com.fishbread101.dto.ProfileModifyRequestDto;
import com.fishbread101.dto.ProfileResponseDto;
import com.fishbread101.entity.Lecture;
import com.fishbread101.entity.User;
import com.fishbread101.repository.LectureRepository;
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

    @Transactional
    @Override
    public void modifyProfile (ProfileModifyRequestDto profileModifyRequestDto, User user){
//        User profile = userRepository.findByProfileId();
         // 여기 안에 어떤 유저가 정보 변경 요청을 원했는지 나와있습니다.
//        if (profile.getLoginId().equals(user.getLoginId())) {
//            profile.modify(profileModifyRequestDto);
//        } else {
//            throw new IllegalAccessException("게시물을 삭제할 수 없습니다.");
//        }
        // 패스워드나 그런 검증을 할 필요가 없습니다. 왜냐하면 - 이미 토큰을 바탕으로 어떤 유저가 정보를 요청했는지 알고있어서
        // 그 요청을 한 유저의 정보를 바꿔주기만 하면 돼요.
        user.modify(profileModifyRequestDto);
        userRepository.save(user);
        // Postman => 200 OK 싸인 -> 정상종료가 되지않으면 500error , 400 error
    }

    @Transactional
    @Override
    public ProfileResponseDto getProfile(User user) {
        ProfileResponseDto result = new ProfileResponseDto(user.getNickname(), user.getImage(), user.getDescription());
        return result;
    }

    @Transactional(readOnly = true)
    public List<LectureResponseDto> getAllLectures() {
        List<LectureResponseDto> lectureResponseDtoList = new ArrayList<>();
        List<Lecture> lectures = lectureRepository.findAllByLecturesId();

        for (Lecture lecture: lectures) {
            lectureResponseDtoList.add(new LectureResponseDto(lecture));
        }
        return lectureResponseDtoList;

    }



}
