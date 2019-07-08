package com.qf.travel.common;

import org.springframework.util.DigestUtils;

/**
 * @Description: md5加密验证类
 * @author: tomcat
 *
 */
public class MD5 {
    public static String getMD5Simple(String password){
        String md5002= DigestUtils.md5DigestAsHex(password.getBytes());
        return md5002;
    }
    public static String getMD5(String password) {
        /* * 原密码加密一次  获取原密码加密后前8位字符   将8位字符与加密后的字符串拼接 再加密一次 */
        String md5001 = DigestUtils.md5DigestAsHex(password.getBytes());
        String temp = md5001.substring(0,8);
        String md5002 = DigestUtils.md5DigestAsHex((temp + md5001).getBytes());
        return md5002;
    }
}
