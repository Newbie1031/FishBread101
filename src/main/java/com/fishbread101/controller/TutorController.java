package com.fishbread101.controller;

import com.fishbread101.common.security.UserDetailsImpl;
import com.fishbread101.dto.*;
import com.fishbread101.service.ApplyService;
import com.fishbread101.service.EnrolmentService;
import com.fishbread101.service.LectureService;
import com.fishbread101.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tutor")
public class TutorController {

    private final UserService userService;
    private final LectureService lectureService;
    private final EnrolmentService enrolmentService;
    private final ApplyService applyService;

    // 1.프로필 설정
    @PostMapping("/profile")
    public ProfileResponseDto modifyProfile(
            @RequestBody ProfileModifyRequestDto profileModifyRequestDto,
            @AuthenticationPrincipal UserDetailsImpl userDetails
    ) {
        return userService.modifyProfile(profileModifyRequestDto, userDetails.getUser());
    }

    // 2.프로필 조회
    @GetMapping("/profile")
    public ProfileResponseDto getProfile(
            @AuthenticationPrincipal UserDetailsImpl userDetails
    ) {
        return userService.getProfile(userDetails.getUser());
    }

    // 5. 강의 등록
    @PostMapping("/lectures")
    public LectureResponseDto createLecture(
            @RequestBody LectureRequestDto lectureRequestDto,
            @AuthenticationPrincipal UserDetailsImpl userDetails
    ) {
        return lectureService.createLecture(lectureRequestDto, userDetails.getUser());
    }

    // 6. 자신이 등록한 강의 수정
    @PatchMapping("/lectures/{lectureId}")
    public LectureResponseDto updateLecture(
            @PathVariable Long lectureId,
            @RequestBody LectureModifyRequestDto lectureModifyRequestDto,
            @AuthenticationPrincipal UserDetailsImpl userDetails
    ) {
        return lectureService.updateLecture(lectureId, lectureModifyRequestDto, userDetails.getUser());
    }

    // 3. 자신이 등록한 모든 강의 조회
    @GetMapping("/lectures")
    public List<LectureResponseDto> getLectures(
            @AuthenticationPrincipal UserDetailsImpl userDetails
    ) {
        return lectureService.getMyLectures(userDetails.getUser());
    }

    // 4. 자신이 등록한 강의에 신청한 튜티 조회
    @GetMapping("/enrolments/{lectureId}")
    public List<EnrolmentResponseDto> getMyLecturesEnrolment(
            @PathVariable Long lectureId
    ) {
        return enrolmentService.getMyLecturesEnrolment(lectureId);
    }

    // 7. 자신이 등록한 강의 삭제
    @DeleteMapping("/lectures/{lectureId}")
    public void deleteLecture(
            @PathVariable Long lectureId,
            @AuthenticationPrincipal UserDetailsImpl userDetails
    ) {
        lectureService.deleteLecture(lectureId, userDetails);
    }

    // 8. 수강 신청 승인
    @PostMapping("/apply/{applyId}")
    public void allowApply(
            @PathVariable Long applyId,
            @AuthenticationPrincipal UserDetailsImpl userDetails
    ) {
        applyService.allowApply(applyId);
    }

    // 9. 수강 신청 거절
    @DeleteMapping("/apply/{applyId}")
    public void refuseApply(
            @PathVariable Long applyId
    ) {
        applyService.refuseApply(applyId);
    }

}
