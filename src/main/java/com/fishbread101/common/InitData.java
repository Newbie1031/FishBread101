package com.fishbread101.common;

import com.fishbread101.entity.*;
import com.fishbread101.repository.ApplyRepository;
import com.fishbread101.repository.EnrolmentRepository;
import com.fishbread101.repository.LectureRepository;
import com.fishbread101.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class InitData implements ApplicationRunner {

    private final UserRepository userRepository;
    private final ApplyRepository applyRepository;
    private final EnrolmentRepository enrolmentRepository;
    private final LectureRepository lectureRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        User admin = new User("sparta", passwordEncoder.encode("sparta"), "sparta", "sparta.jpg", "안녕하세요 운영자 스파르타입니다.", UserRole.ADMIN, false);
        User tutee1 = new User("sangwook", passwordEncoder.encode("sangwook"), "sangwook", "sangwook.jpg", "안녕하세요 박상욱입니다.", UserRole.TUTEE, false);
        User tutor1 = new User("siwon", passwordEncoder.encode("siwon"), "siwon", "siwon.jpg", "안녕하세요 튜터 김시원입니다.", UserRole.TUTOR, false);
        User tutor2 = new User("yeonjoo", passwordEncoder.encode("yeonjoo"), "yeonjoo", "yeonjoo.jpg", "안녕하세요 튜터 박연주입니다.", UserRole.TUTOR, false);
        User tutee2 = new User("boa", passwordEncoder.encode("boa"), "boa", "boa.jpg", "안녕하세요 김보아입니다.", UserRole.TUTEE, true);
        User tutee3 = new User("hakyoon", passwordEncoder.encode("hakyoon"), "hakyoon", "hakyoon.jpg", "안녕하세요 김학윤입니다.", UserRole.TUTEE, false);
        User tutee4 = new User("gwanho", passwordEncoder.encode("gwanho"), "gwanho", "gwanho.jpg", "안녕하세요 김관호입니다.", UserRole.TUTEE, false);

        userRepository.saveAll(List.of(admin, tutee1, tutor1, tutor2, tutee2, tutee3, tutee4));

        Lecture lecture1 = new Lecture(tutor1, "붕어빵101 스프링 강의입니다!", "FishBread101-Spring.jpg", 20);
        Lecture lecture2 = new Lecture(tutor2, "붕어빵101 JPA 강의입니다!", "FishBread101-JPA.jpg", 30);

        lectureRepository.saveAll(List.of(lecture1, lecture2));

        Enrolment enrolment1 = new Enrolment(tutee1, lecture1);
        Enrolment enrolment2 = new Enrolment(tutee2, lecture1);
        Enrolment enrolment3 = new Enrolment(tutee3, lecture2);
        Enrolment enrolment4 = new Enrolment(tutee4, lecture2);

        enrolmentRepository.saveAll(List.of(enrolment1, enrolment2, enrolment3, enrolment4));

        Apply apply1 = new Apply(tutee1, lecture2);
        Apply apply2 = new Apply(tutee2, lecture2);
        Apply apply3 = new Apply(tutee3, lecture1);
        Apply apply4 = new Apply(tutee4, lecture2);

        applyRepository.saveAll(List.of(apply1, apply2, apply3, apply4));

    }

}
