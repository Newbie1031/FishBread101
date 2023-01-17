package com.fishbread101.controller;

import com.fishbread101.dto.UserResponseDto;
import com.fishbread101.service.ApplyService;
import com.fishbread101.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class AdminController {

    private final UserService userService;
    private final ApplyService applyService;
    
    // 튜티 목록 조회
    @GetMapping("/tutees")
    public List<UserResponseDto> getTuteeList() {
        return userService.getTuteeList();
    }

    // 튜터 목록 조회
    @GetMapping("/tutors")
    public List<UserResponseDto> getTutorList() {
        return userService.getAllTutors();
    }

    // 튜터 신청 목록 조회
    @GetMapping("/promotion")
    public List<UserResponseDto> getApplyList(){
        return userService.getTutorApplyList();
    }

    // 튜터 신청 승인
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PatchMapping("/promotion/{id}")
    public void allowTutorApply(@PathVariable Long userId){
        userService.allowTutorApply(userId);
    }

    // 튜터 신청 거부
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/promotion/{id}")
    public void refuseTutorApply(@PathVariable Long userId){
        userService.refuseTutorApply(userId);
    }

}
