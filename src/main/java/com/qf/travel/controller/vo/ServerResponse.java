package com.qf.travel.controller.vo;

/**
 * 用于封装返回数据的类
 * @param <T>
 */
public class ServerResponse<T> {

    // 判断是否成功
    private boolean success;
    // 状态码
    private int statuCode;
    // 错误信息
    private String errorMsg;
    // 所携带的数据
    private T data;

    /**
     * 无参构造
     */
    public ServerResponse() {
    }
    /**
     * 全参构造
     */
    public ServerResponse(boolean success, int statuCode, String errorMsg, T data) {
        this.success = success;
        this.statuCode = statuCode;
        this.errorMsg = errorMsg;
        this.data = data;
    }
    /**
     * 有参构造
     * 用于返回操作失败错误提示
     */
    public ServerResponse(int statuCode, String errorMsg) {
        this.statuCode = statuCode;
        this.errorMsg = errorMsg;
    }
    /**
     * 有参构造
     * 用于返回操作失败错误提示并返回数据
     */
    public ServerResponse(int statuCode, String errorMsg, T data) {
        this.statuCode = statuCode;
        this.errorMsg = errorMsg;
        this.data = data;
    }
    /**
     * 有参构造
     * 用于返回操作成功返回数据
     */
    public ServerResponse(int statuCode, T data) {
        this.statuCode = statuCode;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getStatuCode() {
        return statuCode;
    }

    public void setStatuCode(int statuCode) {
        this.statuCode = statuCode;
    }

    public String getErrorMsg() {
        return errorMsg == null ? "" : errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    /**
     * 成功返回数据
     */
    public static <T> ServerResponse<T> createBySuccess(T data) {
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), data);
    }

    /**
     * 成功返回数据 自定义成功码
     */
    public static <T> ServerResponse<T> createBySuccess(Integer code, T data) {
        return new ServerResponse<T>(code, data);
    }

    /**
     * 失败返回错误信息
     */
    public static <T> ServerResponse<T> createByException(String errorMsg) {
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(), errorMsg);
    }

    /**
     * 失败返回错误信息 自定义错误码
     */
    public static <T> ServerResponse<T> createByException(Integer code, String errorMsg) {
        return new ServerResponse<T>(code, errorMsg);
    }
}
