package com.fishbread101.repository;

import com.fishbread101.entity.User;
import com.fishbread101.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByAppliedTutor(boolean appliedTutor);
    List<User> findByUserRole(UserRole userRole);
    Optional<User> findByLoginId(String loginId);

//    User findByProfileId();
}
