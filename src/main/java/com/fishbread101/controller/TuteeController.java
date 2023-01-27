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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

import java.util.List;

import static com.fishbread101.entity.UserRole.TUTOR;

@RestController
@RequestMapping("/api/tutee")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ROLE_TUTEE')")
public class TuteeController {

    private final UserService userService;
    private final LectureService lectureService;
    private final ApplyService applyService;

    // gwanho1234 -> POST => http://localhost:8080/api/tutee/profile
    //학생 프로필 수정
    @PostMapping("/profile")
    public void modifyProfile(
            @RequestBody ProfileModifyRequestDto profileModifyRequestDto, // 유저가 어떤 정보 변경을 원하는지
            @AuthenticationPrincipal UserDetailsImpl userDetails // 어떤 유저가 요청을했는지
    ) {
        userService.modifyProfile(profileModifyRequestDto, userDetails.getUser()); // 변경 내용 + 어떤 유저가 요청
    }

    // gwanho1234 => GET => http://localhost:8080/api/tutee/profile
    //학생 프로필 조회
    @GetMapping("/profile")
    public ProfileResponseDto getProfile(
            @AuthenticationPrincipal UserDetailsImpl userDetails
    ) {
        return userService.getProfile(userDetails.getUser());
    }

    //전체 강의 목록 조회
    @GetMapping("/lectures")
    public List<LectureResponseDto> getAllLectures(@RequestParam("page") int page,
                                                   @RequestParam("size") int size,
                                                   @RequestParam("sortBy") String sortBy,
                                                   @RequestParam("isAsc") boolean isAsc) {
        return lectureService.getAllLectures(page-1, size, sortBy, isAsc);
    }

    //전체 튜터 목록 조회
    @GetMapping("/tutors")
    public List<UserResponseDto> getAllTutors(
        @RequestParam("page") int page,
        @RequestParam("size") int size,
        @RequestParam("sortBy") String sortBy,
        @RequestParam("isAsc") boolean isAsc
    ) {
        return userService.getAllTutors(TUTOR,page-1,size,sortBy,isAsc);
    }



    //튜터 정보 조회
    @GetMapping("/tutors/{tutorId}")
    public UserResponseDto getUserByUserId(
            @PathVariable Long tutorId
    ) {
        return userService.getTutorProfile(tutorId);
    }

    // gwanh1234 => POST => http://localhost:8080/api/tutee/lectures/1
    //수강 신청
    @PostMapping("/lectures/{id}")
    public void applyLecture(
        @PathVariable Long id,
        @AuthenticationPrincipal UserDetailsImpl userDetails
    ) {
        applyService.applyLecture(id, userDetails.getUser());
    }

    // http://localhost:8080/api/tutee/promotion => POST
    //튜터 권한 요청
    @PostMapping("/promotion")
    public void registerPromotion(
            @AuthenticationPrincipal UserDetailsImpl userDetails
    ) {
        userService.registerPromotion(userDetails.getUser());
    }

}
