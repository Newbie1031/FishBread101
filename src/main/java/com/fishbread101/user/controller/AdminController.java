package com.fishbread101.user.controller;

import com.fishbread101.apply.entity.Apply;
import com.fishbread101.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class AdminController {

//    튜티 목록 조회
    @GetMapping("/tutees")
    public List<User> getUsers {
        return service.getUserList();
    }

//    튜터 목록 조회
    @GetMapping("/tutors")
    public List<User> getUsers {
        return service.getUserList();
    }

//    튜터 신청 목록 조회
    @GetMapping("/promotion")
    public List<Apply> getApplyList(){
        return service.getApplyList();
    }

//    튜터 신청 승인
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PatchMapping("/promotion/{id}")
    public void allowApply(@PathVariable Long userId){
        service.allowApply(userId);
    }

//    튜터 신청 거부
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/promotion/{id}")
    public void refuseApply(@PathVariable Long userId){
        service.refuseApply(userId);
    }

}
