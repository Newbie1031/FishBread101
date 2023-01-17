package com.fishbread101.controller;


import com.fishbread101.common.security.UserDetailsImpl;
import com.fishbread101.dto.LectureResponseDto;
import com.fishbread101.dto.ProfileModifyRequestDto;
import com.fishbread101.dto.ProfileResponseDto;
import com.fishbread101.dto.UserResponseDto;
import com.fishbread101.service.ApplyService;
import com.fishbread101.service.LectureService;
import com.fishbread101.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tutee")
@RequiredArgsConstructor
public class TuteeController {

    private final UserService userService;
    private final LectureService lectureService;
    private final ApplyService applyService;

    //학생 프로필 설정
    @PostMapping("/profile")
    public void modifyProfile(
            @RequestBody ProfileModifyRequestDto profileModifyRequestDto,
            @AuthenticationPrincipal UserDetailsImpl userDetails
    ) {
        userService.modifyProfile(profileModifyRequestDto, userDetails.getUser());
    }

    //학생 프로필 조회
    @GetMapping("/profile")
    public ProfileResponseDto getProfile(
            @AuthenticationPrincipal UserDetailsImpl userDetails
    ) {
        return userService.getProfile(userDetails.getUser());
    }

    //전체 강의 목록 조회
    @GetMapping("/lectures")
    public List<LectureResponseDto> getAllLectures() {
        return lectureService.getAllLectures();
    }

    //전체 튜터 목록 조회
    @GetMapping("/tutors")
    public List<UserResponseDto> getAllTutors() {
        return userService.getAllTutors();
    }

    //튜터 정보 조회
    @GetMapping("/tutors/{tutorId}")
    public UserResponseDto getUserByUserId(
            @PathVariable Long tutorId
    ) {
        return userService.getTutorProfile(tutorId);
    }

    //수강 신청
    @PostMapping("/lectures/{id}")
    public void applyLecture(
        @PathVariable Long id,
        @AuthenticationPrincipal UserDetailsImpl userDetails
    ) {
        applyService.applyLecture(id, userDetails.getUser());
    }

    //튜터 권한 요청
    @PostMapping("/promotion")
    public void applyPromotion(
            @AuthenticationPrincipal UserDetailsImpl userDetails
    ) {
        userService.applyTutor(userDetails.getUser());
    }

}
