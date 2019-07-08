package com.qf.travel.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.travel.dto.UserInfoDto;
import com.qf.travel.entity.BackStageUser;
import com.qf.travel.service.UserInfoService;
import com.qf.travel.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;


/*  用户管理 */
@Controller
public class UserInfoController {

        @Autowired
        UserInfoService userInfoService;

        /* 显示所有用户(包括超级管理员)  */
        @RequestMapping(value = "listAllUserInfo",method = RequestMethod.POST)
        @ResponseBody
        public Object listAllUserInfo(@RequestBody(required = false) UserInfoVo userInfoVo){

            PageHelper.startPage(userInfoVo.getCurrentPage(), userInfoVo.getPageSize());

            List<UserInfoDto> userInfoDtos = userInfoService.listAllUserInfo();

            PageInfo<UserInfoDto> pageInfos = new PageInfo<>(userInfoDtos);
            System.out.println(pageInfos.toString()+"-----------------");
            return pageInfos;
        }

    /* 增加用户 */
    @RequestMapping(value = "addUserInfo",method = RequestMethod.POST)
    @ResponseBody
    public Object addUserInfo(@RequestBody(required = false) UserInfoVo userInfoVo){
        System.out.println(userInfoVo+"add");
        boolean flag = userInfoService.addUserInfo(userInfoVo);
        return flag;
    }


    /* 删除用户  */
    @RequestMapping(value = "delUserInfo",method = RequestMethod.POST)
    @ResponseBody
    public Object delUserInfo(@RequestBody(required = false) UserInfoVo userInfoVo){
        System.out.println(userInfoVo.getId());
        boolean flag ;
        flag = userInfoService.delUserInfo(userInfoVo);
        return flag;
    }

    /*  批量删除用户  */
    @RequestMapping(value = "delUserInfos",method = RequestMethod.POST)
    @ResponseBody
    public Object delUserInfos(@RequestBody(required = false) UserInfoVo userInfoVo){
        System.out.println(userInfoVo.getIds());
        boolean flag ;
        flag = userInfoService.delUserInfos(userInfoVo);
        return flag;
    }


    /* 修改用户信息 */
    @RequestMapping(value = "updateUserInfo",method = RequestMethod.POST)
    @ResponseBody
    public Object updateUserInfo(@RequestBody(required = false) UserInfoVo userInfoVo){
        System.out.println(userInfoVo);
        boolean flag = userInfoService.updateUserInfo(userInfoVo);
        return flag;
    }

    /* 个人信息回显 */
    @RequestMapping(value = "myInformation",method = RequestMethod.POST)
    @ResponseBody
    public Object myInformation(@RequestBody(required = false) UserInfoVo userInfoVo, HttpSession httpSession){
        BackStageUser userInfo = (BackStageUser)httpSession.getAttribute("backStageUserReturn");
        userInfoVo.setId(userInfo.getId());
        System.out.println(userInfo.getId()+"idididid啊");
        UserInfoVo userInfoVo1 = userInfoService.myInformation(userInfoVo);
        return  userInfoVo1;
    }


}
