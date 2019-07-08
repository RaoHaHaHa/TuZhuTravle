package com.qf.travel.service;

import com.qf.travel.entity.BackStageUser;
import org.springframework.stereotype.Service;

@Service
public interface BackStageUserInfoService {
    BackStageUser loginCheck(BackStageUser backStageUser);
}
