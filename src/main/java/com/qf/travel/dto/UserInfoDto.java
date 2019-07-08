package com.qf.travel.dto;

import java.util.Arrays;

public class UserInfoDto {

    private int id;
    private String username;
    private String regist_email;
    private String regist_phone;
    private String address;
    private String diy_name;
    private String sex;
    private int[] ids;
    private String login_time;

    int currentPage; //当前页
    int pageSize;//每页的条数


    public String getSex() {
        return sex;
    }

    public String getLogin_time() {
        return login_time;
    }

    public void setLogin_time(String login_time) {
        this.login_time = login_time;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRegist_email() {
        return regist_email;
    }

    public void setRegist_email(String regist_email) {
        this.regist_email = regist_email;
    }

    public String getRegist_phone() {
        return regist_phone;
    }

    public void setRegist_phone(String regist_phone) {
        this.regist_phone = regist_phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDiy_name() {
        return diy_name;
    }

    public void setDiy_name(String diy_name) {
        this.diy_name = diy_name;
    }

    public int[] getIds() {
        return ids;
    }

    public void setIds(int[] ids) {
        this.ids = ids;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }


    @Override
    public String toString() {
        return "UserInfoVo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", regist_email='" + regist_email + '\'' +
                ", regist_phone='" + regist_phone + '\'' +
                ", address='" + address + '\'' +
                ", diy_name='" + diy_name + '\'' +
                ", sex='" + sex + '\'' +
                ", ids=" + Arrays.toString(ids) +
                ", login_time='" + login_time + '\'' +
                ", currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                '}';
    }

}
