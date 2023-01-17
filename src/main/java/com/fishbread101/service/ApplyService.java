package com.fishbread101.service;

import com.fishbread101.entity.User;

public interface ApplyService {

    void refuseApply(Long applyId);

    void acceptApply(Long id);

    void applyLecture(Long id, User user);

}
