package com.qf.travel.service;

import com.qf.travel.dto.UserInfoDto;
import com.qf.travel.vo.UserInfoVo;

import java.util.List;

public interface PemissionService {

    List<UserInfoDto> listAllAdmin(UserInfoVo userInfoVo);

    boolean delAdmin(UserInfoVo userInfoVo);

    boolean addAdmin( UserInfoVo userInfoVo);

    boolean updateAdmin(UserInfoVo userInfoVo);
}
