package com.fishbread101.service;

import com.fishbread101.dto.SignInRequestDto;
import com.fishbread101.dto.SignUpRequestDto;
import com.fishbread101.dto.UserResponseDto;
import com.fishbread101.entity.User;

import javax.servlet.http.HttpServletResponse;

public interface AuthService {

    UserResponseDto signUp(SignUpRequestDto signupRequestDto);

    UserResponseDto signIn(SignInRequestDto signInRequestDto, HttpServletResponse response);

    void signOut(User user);

}
