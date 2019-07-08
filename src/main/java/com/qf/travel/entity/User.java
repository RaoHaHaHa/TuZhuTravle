package com.qf.travel.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * author:Qian
 * 用户实体类
 */
public class User implements Serializable {
    //用户id
    private Long id;
    //用户名
    private String username;
    //用户密码
    private String password;
    //注册邮箱
    private String registEmail;
    //注册电话
    private String registPhone;
    //注册时间
    private Timestamp registTime;
    //注册的用户类别
    private String registStatus;
    //用户状态
    private String userState;
    //用户生日
    private Date birth;
    //用户性别标识
    private String sex;
    //用户上次修改资料时间
    private Timestamp updateTime;
    //用户头像地址
    private String userHead;
    //用户上次登陆时间
    private Timestamp loginTime;
    //用户上次登陆ip
    private String lastIp;
    //用户别名
    private String diyName;
    //用户等级
    private String grade;
    //用户地址
    private String address;
    //用户联系电话
    private String phone;

    /**
     * author：Qian
     * 无参构造
     */
    public User() {
    }

    /**
     * 全参构造
     * author:Qian
     * @param id
     * @param username
     * @param password
     * @param registEmail
     * @param registPhone
     * @param registTime
     * @param registStatus
     * @param userState
     * @param birth
     * @param sex
     * @param updateTime
     * @param userHead
     * @param loginTime
     * @param lastIp
     * @param diyName
     * @param grade
     * @param address
     * @param phone
     */
    public User(Long id, String username, String password, String registEmail, String registPhone, Timestamp registTime, String registStatus, String userState, Date birth, String sex, Timestamp updateTime, String userHead, Timestamp loginTime, String lastIp, String diyName, String grade, String address, String phone) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.registEmail = registEmail;
        this.registPhone = registPhone;
        this.registTime = registTime;
        this.registStatus = registStatus;
        this.userState = userState;
        this.birth = birth;
        this.sex = sex;
        this.updateTime = updateTime;
        this.userHead = userHead;
        this.loginTime = loginTime;
        this.lastIp = lastIp;
        this.diyName = diyName;
        this.grade = grade;
        this.address = address;
        this.phone = phone;
    }

    /**
     * 用户注册构造
     * @param username
     * @param password
     * @param registEmail
     * @param registPhone
     * @param registTime
     * @param registStatus
     * @param userState
     */
    public User(String username, String password, String registEmail, String registPhone, Timestamp registTime, String registStatus, String userState) {
        this.username = username;
        this.password = password;
        this.registEmail = registEmail;
        this.registPhone = registPhone;
        this.registTime = registTime;
        this.registStatus = registStatus;
        this.userState = userState;
    }

    /**
     * a安全性更新构造
     * @param id
     * @param loginTime
     * @param lastIp
     */
    public User(Long id, Timestamp loginTime, String lastIp) {
        this.id = id;
        this.loginTime = loginTime;
        this.lastIp = lastIp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRegistEmail() {
        return registEmail;
    }

    public void setRegistEmail(String registEmail) {
        this.registEmail = registEmail;
    }

    public String getRegistPhone() {
        return registPhone;
    }

    public void setRegistPhone(String registPhone) {
        this.registPhone = registPhone;
    }

    public Timestamp getRegistTime() {
        return registTime;
    }

    public void setRegistTime(Timestamp registTime) {
        this.registTime = registTime;
    }

    public String getRegistStatus() {
        return registStatus;
    }

    public void setRegistStatus(String registStatus) {
        this.registStatus = registStatus;
    }

    public String getUserState() {
        return userState;
    }

    public void setUserState(String userState) {
        this.userState = userState;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public String getUserHead() {
        return userHead;
    }

    public void setUserHead(String userHead) {
        this.userHead = userHead;
    }

    public Timestamp getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Timestamp loginTime) {
        this.loginTime = loginTime;
    }

    public String getLastIp() {
        return lastIp;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    public String getDiyName() {
        return diyName;
    }

    public void setDiyName(String diyName) {
        this.diyName = diyName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", registEmail='" + registEmail + '\'' +
                ", registPhone='" + registPhone + '\'' +
                ", registTime=" + registTime +
                ", registStatus='" + registStatus + '\'' +
                ", registState='" + userState + '\'' +
                ", birth=" + birth +
                ", sex='" + sex + '\'' +
                ", updateTime=" + updateTime +
                ", userHead='" + userHead + '\'' +
                ", loginTime=" + loginTime +
                ", lastIp='" + lastIp + '\'' +
                ", diyName='" + diyName + '\'' +
                ", grade='" + grade + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
