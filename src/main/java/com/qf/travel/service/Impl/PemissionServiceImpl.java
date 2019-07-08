package com.qf.travel.service.Impl;

import com.qf.travel.dto.UserInfoDto;
import com.qf.travel.mapper.PemissionMapper;
import com.qf.travel.service.PemissionService;
import com.qf.travel.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PemissionServiceImpl implements PemissionService {

    @Autowired
    PemissionMapper pemissionMapper;

    @Override
    public List<UserInfoDto> listAllAdmin(UserInfoVo userInfoVo) {
        List<UserInfoDto> userInfoVos = pemissionMapper.listAllAdmin(userInfoVo);
        System.out.println(userInfoVos);
        return userInfoVos;
    }

    @Override
    @Transactional
    public boolean delAdmin(UserInfoVo userInfoVo) {
        int count = pemissionMapper.delAdmin(userInfoVo);
        boolean flag;
        if(count > 0) {
            flag = true;
        }
            flag = false;
        return flag;
    }

    @Override
    @Transactional
    public boolean addAdmin(UserInfoVo userInfoVo) {
        int count = pemissionMapper.addAdmin(userInfoVo);
        boolean flag = false;
        if(count > 0) {
            flag = true;
        }
        return flag;
    }

    @Override
    @Transactional
    public boolean updateAdmin(UserInfoVo userInfoVo) {
        int count = pemissionMapper.updateAdmin(userInfoVo);
        boolean flag = false;
        if(count > 0) {
            flag = true;
        }
        return flag;
    }
}
