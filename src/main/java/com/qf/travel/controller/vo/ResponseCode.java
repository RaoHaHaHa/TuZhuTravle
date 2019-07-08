package com.qf.travel.controller.vo;

/**
 * 定义响应码及响应消息
 * author:Qian
 * @CreateDate:2019-6-29 09:30
 * @Version:1.0.0
 */
public enum  ResponseCode {
    /* 成功*/
    SUCCESS(200, "success"),
    /* 服务器异常*/
    ERROR(500, "服务器繁忙"),
    /* 数据没找到*/
    NOT_FOUND(404, "没有可以显示的数据"),
    /* 请求错误*/
    REQUEST_ERROR(403, "请求错误"),
    /* 权限不足*/
    NO_PERMISSION(-1, "权限不足");

    /* 错误码*/
    private int code;
    /* 错误信息*/
    private String desc;

    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
