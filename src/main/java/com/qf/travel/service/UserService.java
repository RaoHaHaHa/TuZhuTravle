package com.qf.travel.service;

import com.qf.travel.controller.vo.ServerResponse;
import com.qf.travel.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 用户Service层业务处理接口
 */
public interface UserService {

    /**
     * @Description: 获取邮箱验证码
     * @Author: Qian
     **/
    ServerResponse getEmailCode(HttpServletRequest request, String registEemail);


    /**
     * @Description: 验证邮箱验证码
     * @Author: Qian
     **/
    ServerResponse verifyEmailCode(HttpServletRequest request, String registEemail, String code);

    /**
     * @Description: 根据邮箱注册
     * @Author: Qian
     **/
    ServerResponse registerByEmail(String username, String registEemail, String password);

    /**
     * @Description: 获取手机验证码
     * @Author: Qian
     **/
    ServerResponse getPhoneCode(HttpServletRequest request, String registPhone);


    /**
     * @Description: 验证手机验证码
     * @Author: Qian
     **/
    ServerResponse verifyPhoneCode(HttpServletRequest request, String registPhone, String code);

    /**
     * @Description: 根据手机注册
     * @Author: Qian
     **/
    ServerResponse registerByPhone(String username, String registPhone, String password);

    /**
     * @Description: 用户登录
     * @Author: Qian
     **/
    ServerResponse userLogin(HttpServletRequest request, HttpSession session, String account, String password);

    /**
     * @Description: 通过传入的对象增加用户
     * @param： user传入的对象
     * @return： 返回受影响的行数
     */
    ServerResponse insertUser(User user);
    /**
     * 通过传入的id注销用户
     * @param id 要注销的用户id
     * @return 返回受影响的行数
     */
    ServerResponse logoutUser(Long id);

    /**
     * @Description: 用户通过传入的对象修改用户信息
     * @param user
     * @return
     */
    ServerResponse updateUser(User user);

    /**
     * @Description: 系统自动修改用户信息
     * @param user
     * @return
     */
    ServerResponse<User> autoUpdateUser(User user);

    /**
     * @Description: 通过id查询用户信息
     * @param id 要查询的id
     * @return 返回一个对象
     */
    ServerResponse<User> selectUserById(Long id);

    /**
     * @Description: 根据邮箱查询一个用户
     * @Author: Qian
     **/
    ServerResponse<User> selectUserByEmail(String email);

    /**
     * @Description: 根据手机号查询一个用户
     * @Author: Qian
     **/
    ServerResponse<User> selectUserByPhone(String phone);

    /**
     * @Description: 根据用户名查询一个用户
     * @Author: Qian
     **/
    ServerResponse<User> selectUserByUserName(String userName);

    /**
     * 用户退出
     * @param request
     * @return 返回受影响的行数
     */
    ServerResponse outUser(HttpServletRequest request, HttpServletResponse response);
    /**
     * 获取登陆用户
     * @param request
     * @return
     */
    ServerResponse findOne(HttpServletRequest request, HttpServletResponse response);
}
