package com.qf.travel.mapper;

import com.qf.travel.dto.UserInfoDto;
import com.qf.travel.vo.UserInfoVo;

import java.util.List;

public interface PemissionMapper {

    /* 显示所有管理员 */
    List<UserInfoDto> listAllAdmin(UserInfoVo userInfoVo);

    /* 删除管理员权限 */
    int delAdmin(UserInfoVo userInfoVo);

    /* 增加一个管理员 */
    int addAdmin( UserInfoVo userInfoVo);

    /* 修改管理员 */
    int updateAdmin(UserInfoVo userInfoVo);

}
