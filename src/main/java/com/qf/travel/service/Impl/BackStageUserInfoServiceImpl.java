package com.qf.travel.service.Impl;

import com.qf.travel.entity.BackStageUser;
import com.qf.travel.mapper.BackStageUserInfoMapper;
import com.qf.travel.service.BackStageUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BackStageUserInfoServiceImpl implements BackStageUserInfoService {
    @Autowired
    BackStageUserInfoMapper backStageUserInfoMapper;
    @Override
    public BackStageUser loginCheck(BackStageUser backStageUser) {
        System.out.println(backStageUserInfoMapper.loginCheck(backStageUser)+"-----------");
        return backStageUserInfoMapper.loginCheck(backStageUser);
    }
}
