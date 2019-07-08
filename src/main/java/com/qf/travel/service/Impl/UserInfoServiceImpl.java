package com.qf.travel.service.Impl;

import com.qf.travel.dto.UserInfoDto;
import com.qf.travel.mapper.UserInfoMapper;
import com.qf.travel.service.UserInfoService;
import com.qf.travel.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;

    /* 显示所有用户(包括超级管理员) */
    @Override
    public List<UserInfoDto> listAllUserInfo() {
        return userInfoMapper.listAllUserInfo();
    }

    /*  删除用户  */
    @Transactional
    @Override
    public boolean delUserInfo(UserInfoVo userInfoVo) {
        int count = userInfoMapper.delUserInfo(userInfoVo);
        boolean flag;
        if(count > 0) {
            flag = true;
        }else {
            flag = false;
        }
        return flag;
    }

    /*  批量删除用户  */
    @Transactional
    @Override
    public boolean delUserInfos(UserInfoVo userInfoVo) {
        int count = userInfoMapper.delUserInfos(userInfoVo);
        boolean flag = false;
        if(count > 0) {
            flag = true;
        }
        return flag;
    }

    /*  增加用户  */
    @Transactional
    @Override
    public boolean addUserInfo(UserInfoVo userInfoVo) {
        System.out.println("add add add");
        int count = userInfoMapper.addUserInfo(userInfoVo);
        System.out.println(count+"count");
        boolean flag = false;
        if(count > 0) {
            flag = true;
        }
        return flag;
    }

    /* 修改用户信息 */
    @Transactional
    @Override
    public boolean updateUserInfo(UserInfoVo userInfoVo) {
        int count = userInfoMapper.updateUserInfo(userInfoVo);
        System.out.println(count+"count");
        boolean flag = false;
        if(count > 0) {
            flag = true;
        }
        return flag;
    }

    /* 个人信息回显 */
    @Override
    public UserInfoVo myInformation(UserInfoVo userInfoVo) {
        UserInfoVo userInfoVo1 = userInfoMapper.myInformation(userInfoVo);
        return userInfoVo1;
    }
}
