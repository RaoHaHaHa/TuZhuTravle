package com.qf.travel.service;

import com.qf.travel.dto.UserInfoDto;
import com.qf.travel.vo.UserInfoVo;

import java.util.List;

public interface UserInfoService {


    List<UserInfoDto> listAllUserInfo();

    boolean delUserInfo(UserInfoVo userInfoVo);

    boolean delUserInfos(UserInfoVo userInfoVo);

    boolean addUserInfo(UserInfoVo userInfoVo);

    boolean updateUserInfo(UserInfoVo userInfoVo);

    UserInfoVo myInformation(UserInfoVo userInfoVo);
}
