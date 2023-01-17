package com.fishbread101.service;

import com.fishbread101.common.jwt.JwtUtil;

import com.fishbread101.dto.SignInRequestDto;
import com.fishbread101.dto.SignUpRequestDto;
import com.fishbread101.dto.UserResponseDto;
import com.fishbread101.entity.User;
import com.fishbread101.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    @Override
    public UserResponseDto signUp(SignUpRequestDto signupRequestDto) {
        return null;
    }

    @Override
    public UserResponseDto signIn(SignInRequestDto signInRequestDto, HttpServletResponse response) {
        return null;
    }

    @Override
    public void signOut(User user) {

    }
//    private static final String ADMIN_TOKEN = // 토큰값 어디서 찾는지


}
