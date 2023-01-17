package com.fishbread101.service;

import com.fishbread101.entity.Apply;
import com.fishbread101.repository.ApplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ApplyServiceImpl implements ApplyService {
    private final ApplyRepository applyRepository;

    @Transactional
    public void allowApply(Long id) {
        Apply apply = new Apply();
        applyRepository.save(apply);
    }

    @Transactional
    public void refuseApply(Long applyId) {

    }
}
