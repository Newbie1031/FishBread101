package com.fishbread101.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    // 회원가입
    @PostMapping("/signup")
    public UserResponseDto signup(@RequestBody @Valid SignupRequestDto signupRequestDto) {
        return userService.signup(signupRequestDto);
    }

    // 로그인
    @PostMapping("/signin")
    public UserResponseDto signin(@RequestBody SigninRequestDto signinRequestDto, HttpServletResponse response) {
        return userService.sigin(signinRequestDto, response);
    }

    // 로그아웃
    @PostMapping("/signout")
    public UserResponseDto signout(...) {
        return userService.signout();
    }
}
