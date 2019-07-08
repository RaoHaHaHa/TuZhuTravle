package com.qf.travel.mapper;

import com.qf.travel.entity.User;

/**
 * 用户数据操作接口
 * author:tomcat
 */
public interface UserMapper {

    /**
     * 通过传入的对象增加用户
     * @param user 传入的对象
     * @return 返回受影响的行数
     */
    Integer insertUser(User user);
    /**
     * 通过传入的id注销用户
     * @param id 要注销的用户id
     * @return 返回受影响的行数
     */
    Integer logoutUser(Long id);

    /**
     * 用户通过传入的对象修改用户信息
     * @param user
     * @return
     */
    Integer updateUser(User user);

    /**
     * 系统自动修改用户信息
     * @param user
     * @return
     */
    Integer autoUpdateUser(User user);

    /**
     * 系统管理员修改用户信息
     * @param user
     * @return
     */
    Integer adminUpdateUser(User user);

    /**
     * 通过id查询用户信息
     * @param id 要查询的id
     * @return 返回一个对象
     */
    User selectUserById(Long id);

    /**
     * 通过邮箱查询用户 返回user对象
     * @param registEmail
     * @return
     */
    User selectUserByEmail(String registEmail);
    /**
     * 通过手机号查询用户 返回user对象
     * @param registPhone
     * @return
     */
    User selectUserByPhone(String registPhone);
    /**
     * 通过用户名查询用户 返回user对象
     * @param username
     * @return
     */
    User selectUserByUsername(String username);
}
