package com.qf.travel.mapper;

import com.qf.travel.dto.UserInfoDto;
import com.qf.travel.vo.UserInfoVo;

import java.util.List;

public interface UserInfoMapper {

    /* 显示所有用户(包括超级管理员) */
    List<UserInfoDto> listAllUserInfo();

    /* 删除用户 */
    int delUserInfo(UserInfoVo userInfoVo);

    /*  批量删除用户 */
    int delUserInfos(UserInfoVo userInfoVo);

    /* 增加用户 */
    int addUserInfo(UserInfoVo userInfoVo);

    /*修改用户信息*/
    int updateUserInfo(UserInfoVo userInfoVo);

    /*  个人信息回显 */
    UserInfoVo myInformation(UserInfoVo userInfoVo);
}
