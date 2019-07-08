package com.qf.travel.controller;

import com.qf.travel.entity.BackStageUser;
import com.qf.travel.service.BackStageUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
@Controller
public class BackStageLogin {
    @Resource
    BackStageUserInfoService backStageUserInfoService;

    @RequestMapping(value = "BackStageLogin",method = RequestMethod.POST)
    @ResponseBody
    public Object Login(@RequestBody BackStageUser backStageUser, HttpServletRequest request){
        System.out.println(backStageUser.getUsername());
        HttpSession session = request.getSession();
        System.out.println(session);
        BackStageUser backStageUserReturn = backStageUserInfoService.loginCheck(backStageUser);
        session.setAttribute("backStageUserReturn",backStageUserReturn);
        System.out.println(backStageUserReturn.toString()+"==============");
        if(backStageUserReturn != null){
            return "true";
        }
        return "false";

    }
}
