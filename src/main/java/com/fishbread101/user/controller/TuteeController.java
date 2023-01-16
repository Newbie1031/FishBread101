package com.fishbread101.user.controller;


import com.fishbread101.lecture.entity.Lecture;
import com.fishbread101.user.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tutee")
public class TuteeController {

    private final UserService userService;
    private final LectureService lectureService;

    //학생 프로필 설정
    @PostMapping("/profile")
    public UserResponseDto createProfile(@RequestBody UserRequestDto userRequestDto) {
        return userService.createProfile(userRequestDto);
    }

    //수강 신청
    @PostMapping("/lectures/{id}")
    public applyLecture() {

    }


    //튜터 권한 요청
    @PostMapping("/promotion")
    public applyPromotion() {

    }

    //학생 프로필 조회
    @GetMapping("/profile")
    public UserResponseDto readProfile() {
        return userService.readProfile();;
    }

    //전체 강의 목록 조회
    @GetMapping("/lectures")
    public List<LectureResponseDto> readLectuers() {
        return lectureService.readLecture();;
    }

    //내가 수강하는 강의 튜터 목록 조회
    @GetMapping("/tutors")
    public List<UserResponseDto> getUsers() {
        return userService.getUserList();
    }


    //튜터 정보 조회
    @GetMapping("/tutors/{id}")
    public  UserResponseDto getUserByUserId(@PathVariable Long id) {
        UserResponseDto userResponseDto = userService.getUserByUserId(id);
    return service.getUser().getProfile();
    }

}
