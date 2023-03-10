package com.fishbread101.common.config;

import com.fishbread101.common.jwt.JwtAuthFilter;
import com.fishbread101.common.jwt.JwtUtil;
import com.fishbread101.common.security.JwtAccessDeniedHandler;
import com.fishbread101.common.security.JwtAuthenticationEntryPoint;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {

    private final JwtUtil jwtUtil;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.headers().frameOptions().disable(); // 해당 페이지를 <frame> 또는<iframe>, <object> 에서 렌더링할 수 있는지 여부

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); // 세션이 필요하면 생성하도록 셋팅

        http.exceptionHandling()
                .accessDeniedHandler(jwtAccessDeniedHandler)
                .authenticationEntryPoint(jwtAuthenticationEntryPoint);

        http.authorizeHttpRequests()
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/api/auth/**").permitAll()
                .anyRequest().permitAll()
//                .anyRequest().authenticated()
                .and().addFilterBefore(new JwtAuthFilter(jwtUtil), UsernamePasswordAuthenticationFilter.class); // JWT 인증/인가를 사용하기 위한 설정

        return http.build();
    }
}
