package com.qf.travel.dto;

import org.springframework.stereotype.Component;

/**
 * @version 1.0.0
 * @auther Snake
 * @date 2019/7/5 9:43
 */
@Component
public class OrderPay {
    private String orderNo;
    private String totalMoney;
    private String orderName;
    private String orderDetail;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(String totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(String orderDetail) {
        this.orderDetail = orderDetail;
    }
}
