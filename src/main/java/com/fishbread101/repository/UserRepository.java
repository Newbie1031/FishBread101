package com.fishbread101.repository;

import com.fishbread101.entity.User;
import com.fishbread101.entity.UserRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByAppliedTutor(boolean appliedTutor);
    Page<User> findByUserRole(UserRole userRole, Pageable pageable);
    Optional<User> findByLoginId(String loginId);

//    User findByProfileId();
}
