package com.fishbread101.controller;

import com.fishbread101.common.security.UserDetailsImpl;
import com.fishbread101.dto.SignInRequestDto;
import com.fishbread101.dto.SignUpRequestDto;
import com.fishbread101.dto.UserResponseDto;
import com.fishbread101.service.AuthService;
import com.fishbread101.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    // 회원가입
    @PostMapping("/sign-up")
    public void signup(@RequestBody @Valid SignUpRequestDto signUpRequestDto) {
        authService.signUp(signUpRequestDto);
    }

    // 로그인
    @PostMapping("/sign-in")
    public UserResponseDto signIn(
            @RequestBody SignInRequestDto signInRequestDto,
            HttpServletResponse response
    ) {
        return authService.signIn(signInRequestDto, response);
    }

    // 로그아웃
    @PostMapping("/sign-out")
    public void signOut(
            @AuthenticationPrincipal UserDetailsImpl userDetails
    ) {
        authService.signOut(userDetails.getUser());
    }

}
