package com.fishbread101.repository;

import com.fishbread101.entity.Enrolment;
import com.fishbread101.entity.Lecture;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrolmentRepository extends JpaRepository<Enrolment, Long> {
    Page<Enrolment> findAllByLecture(Lecture lecture, Pageable pageable);
}
