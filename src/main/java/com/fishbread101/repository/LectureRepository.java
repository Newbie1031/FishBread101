package com.fishbread101.repository;

import com.fishbread101.dto.LectureModifyRequestDto;
import com.fishbread101.entity.Lecture;
import com.fishbread101.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LectureRepository extends JpaRepository<Lecture, Long> {

    List<Lecture> findAllByTutor(User user);

}
