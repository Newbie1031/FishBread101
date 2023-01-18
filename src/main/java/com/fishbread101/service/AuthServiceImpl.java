package com.fishbread101.service;

import com.fishbread101.common.jwt.JwtUtil;

import com.fishbread101.dto.SignInRequestDto;
import com.fishbread101.dto.SignUpRequestDto;
import com.fishbread101.entity.User;
import com.fishbread101.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void signUp(SignUpRequestDto signupRequestDto) {
        String loginId = signupRequestDto.getLoginId();

        Optional<User> findUser = userRepository.findByLoginId(loginId);
        if(findUser.isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 회원 아이디입니다.");
        } else {
            String encodedPw = passwordEncoder.encode(signupRequestDto.getLoginPw());
            User user = new User(signupRequestDto.getLoginId(), encodedPw);
            userRepository.save(user); // HTTP STATUS - 200 OK
        }
    }

    @Override
    public String signIn(SignInRequestDto signInRequestDto, HttpServletResponse response) {
        String loginId = signInRequestDto.getLoginId();
        User user = userRepository.findByLoginId(loginId).orElseThrow(() -> new IllegalArgumentException("아이디 없음"));
        String userPw = user.getLoginPw(); // 유저 객체 PW
        String inputPw = signInRequestDto.getLoginPw(); // 사용자가 입력한(암호화 안된) PW

        if(passwordEncoder.matches(inputPw, userPw)) {
            // 맞다면 로그인을 해줘야겠고
            String token = jwtUtil.createToken(user.getLoginId(), user.getUserRole());
            response.addHeader("Authorization", token);
            return token;
        } else {
            // 아니라면은 exception 을 던져줘야겠죠?
            throw new IllegalArgumentException("비밀번호 불일치");
        }
    }
}
