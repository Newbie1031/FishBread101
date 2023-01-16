package com.fishbread101.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tutor")
public class TutorController {
    private final UserService userService;
    private final LectureService lectureService;
    private final EnrolmentService enrolmentService;
    private final ApplyService applyService;
    @PostMapping("/profile")    // 1.프로필 설정
    public UserResponseDto createProfile(@RequestBody UserRequestDto userRequestDto) {
        return userService.createProfile(userRequestDto);
    }

    @GetMapping("/profile")     // 2.프로필 조회
    public UserResponseDto readProfile() {
        return userService.readProfile();
    }

    @GetMapping("/lectures")    // 3.등록한 강의 조회
    public list<LectureResponseDto> readLecture() {
        return lectureService.readLecture();
    }

    @GetMapping("/enrolments")   // 4.신청 목록 조회
    public list<EnrolmentResponseDto> readEnrolment() {
        return enrolmentService.readEnrolment();
    }

    @PostMapping("/lectures")    // 5.강의 등록
    public LectureResponseDto createLecture(@RequestBody LectureRequestDto lectureRequestDto) {
        return lectureService.createLecture(lectureRequestDto);
    }

    @PatchMapping("/lectures/{id}")// 6.강의 수정
    public LectureResponseDto updateLecture(@PathVariable Long id, @RequestBody LectureRequestDto lectureRequestDto) {
        return lectureService.updateLecture(id, lectureRequestDto);
    }

    @DeleteMapping("/lectures/{id}")// 7.강의 삭제
    public void deleteLecture(@PathVariable Long id) {
        lectureService.delete(id);
    }

    @PostMapping("/apply/{id}")     // 8.수강 신청 승인
    public EnrolmentResponseDto createEnrolment(@PathVariable Long id) {
        return applyService.create(id);
    }

    @DeleteMapping("/apply/{id}")   // 9.수강 신청 거절
    public void deleteEnrolment(@PathVariable Long id) {
        applyService.delete(id);
    }
}
