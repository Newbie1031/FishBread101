package com.fishbread101.controller;

import com.fishbread101.dto.UserResponseDto;
import com.fishbread101.entity.UserRole;
import com.fishbread101.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminController {

    private final UserService userService;

    // 전체 튜티 목록 조회
    @GetMapping("/tutees")
    public List<UserResponseDto> getTuteeList(
            @RequestParam("page") int page,
            @RequestParam("size") int size,
            @RequestParam("sortBy") String sortBy,
            @RequestParam("isAsc") boolean isAsc
    ) {
        return userService.getTuteeList(page, size, sortBy, isAsc);
    }

    // 전체 튜터 목록 조회
    @GetMapping("/tutors")
    public List<UserResponseDto> getTutorList(
            @RequestParam("page") int page,
            @RequestParam("size") int size,
            @RequestParam("sortBy") String sortBy,
            @RequestParam("isAsc") boolean isAsc
    ) {
        return userService.getAllTutors(UserRole.TUTOR, page, size, sortBy, isAsc);
    }

    // 전체 튜터 신청 목록 조회
    @GetMapping("/promotion")
    public List<UserResponseDto> getPromotionList(){
        return userService.getPromotionList();
    }

    // 튜터 신청 승인
    @PatchMapping("/promotion/{userId}")
    public void allowPromotion(@PathVariable Long userId){
        userService.allowPromotion(userId);
    }

    // 튜터 신청 거부
    @DeleteMapping("/promotion/{userId}")
    public void refusePromotion(@PathVariable Long userId){
        userService.refusePromotion(userId);
    }

}
