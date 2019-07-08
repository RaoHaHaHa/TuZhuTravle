package com.qf.travel.controller;

import com.qf.travel.controller.vo.ServerResponse;
import com.qf.travel.entity.User;
import com.qf.travel.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 *用户功能模块
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    /**
     * 用户登陆
     * @param request
     * @param session
     * @param account
     * @param password
     * @return
     */
    @RequestMapping("/userlogin")
    @ResponseBody
    public ServerResponse userLogin(HttpServletRequest request, HttpSession session, String account, String password){
        ServerResponse response=userService.userLogin(request,session, account, password);
        return response;
    }
    /**
     * 验证手机验证码
     * @param request
     * @param registPhone
     * @param phoneCode
     * @return
     */
    @RequestMapping("/verifyphonecode")
    @ResponseBody
    public ServerResponse verifyPhoneCode(HttpServletRequest request, String registPhone, String phoneCode) {
        ServerResponse serverResponse = userService.verifyPhoneCode(request, registPhone, phoneCode);
        return serverResponse;
    }
    /**
     * 手机号注册用户
     * @param username
     * @param registPhone
     * @param password
     * @return
     */
    @RequestMapping("/registphone")
    @ResponseBody
    public ServerResponse phoneRegist(String username, String registPhone, String password){
        ServerResponse response = userService.registerByPhone(username,registPhone,password);
        return response;
    }

    /**
     * 验证邮箱验证码
     * @param request
     * @param registEmail
     * @param code
     * @return
     */
    @RequestMapping("/verifyemailcode")
    @ResponseBody
    public ServerResponse verifyEmailCode(HttpServletRequest request, String registEmail, String code) {

        ServerResponse serverResponse = userService.verifyEmailCode(request, registEmail, code);
        return serverResponse;
    }
    /**
     * 邮箱注册用户
     * @param username
     * @param registEmail
     * @param password
     * @return
     */
    @RequestMapping("/emailregist")
    @ResponseBody
    public ServerResponse emailRegist(String username, String registEmail, String password){
        ServerResponse response = userService.registerByEmail(username,registEmail,password);
        return response;
    }

    /**
     * 发送邮件验证码
     * @param request
     * @param registEmail
     * @return
     */
    @RequestMapping("/sendemailcode")
    @ResponseBody
    public ServerResponse sendEmailCode(HttpServletRequest request, String registEmail) {
        ServerResponse emailCode = userService.getEmailCode(request, registEmail);
        return emailCode;
    }

    /**
     * 发送手机验证码
     * @param request
     * @param registPhone
     * @return
     */
    @RequestMapping("/sendphonecode")
    @ResponseBody
    public ServerResponse sendPhoneCode(HttpServletRequest request, String registPhone) {
        ServerResponse phoneCode = userService.getPhoneCode(request, registPhone);
        return phoneCode;
    }

    /**
     * 用户退出登陆
     * @param request
     * @return
     */
    @RequestMapping("/userout")
    @ResponseBody
    public void outUser(HttpServletRequest request, HttpServletResponse response) {
        userService.outUser(request, response);
        try {
            response.sendRedirect(request.getContextPath()+"/index.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 获取当前登陆用户
     * @param request
     * @return
     */
    @RequestMapping("/findOne")
    @ResponseBody
    public User findOne(HttpServletRequest request, HttpServletResponse response) {
        ServerResponse findUser = userService.findOne(request, response);
        User user = (User)findUser.getData();
        return user;
    }
}
