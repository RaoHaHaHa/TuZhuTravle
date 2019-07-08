package com.qf.travel.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.travel.dto.UserInfoDto;
import com.qf.travel.service.PemissionService;
import com.qf.travel.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*  权限管理 */
@RestController
public class PemissionController {

    @Autowired
    PemissionService pemissionService;

    /* 显示所有管理员 */
    @RequestMapping(value = "listAllAdmin",method = RequestMethod.POST)
    public Object listAllAdmin(@RequestBody(required = false) UserInfoVo userInfoVo){

        System.out.println(userInfoVo.getCurrentPage()+userInfoVo.getPageSize());
        PageHelper.startPage(userInfoVo.getCurrentPage(), userInfoVo.getPageSize());

        List<UserInfoDto> userInfoVos = pemissionService.listAllAdmin(userInfoVo);

        PageInfo<UserInfoDto> pageInfo = new PageInfo<>(userInfoVos);

        System.out.println(pageInfo);

        return pageInfo;
    }

    /* 删除用户  */
    @RequestMapping(value = "delAdmin",method = RequestMethod.POST)
    public Object delAdmin(@RequestBody(required = false) UserInfoVo userInfoVo){
        System.out.println(userInfoVo);
        boolean flag ;
        flag = pemissionService.delAdmin(userInfoVo);
        return flag;
    }

    /* 增加一个管理员 */
    @RequestMapping(value = "addAdmin",method = RequestMethod.POST)
    public Object addAdmin(@RequestBody(required = false) UserInfoVo userInfoVo){
        System.out.println(userInfoVo);
        boolean flag = pemissionService.addAdmin(userInfoVo);
        return flag;
    }

    /* 修改管理员 */
    @RequestMapping(value = "updateAdmin",method = RequestMethod.POST)
    public Object updateAdmin(@RequestBody(required = false) UserInfoVo userInfoVo){
        System.out.println(userInfoVo);
        boolean flag ;
        flag = pemissionService.updateAdmin(userInfoVo);
        return flag;
    }

}
