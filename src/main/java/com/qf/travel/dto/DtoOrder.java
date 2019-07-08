package com.qf.travel.dto;

/**
 * @version 1.0.0
 * @auther Snake
 * @date 2019/7/5 10:01
 */

public class DtoOrder {
    private String orderName;
    private String totalMoney;

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(String totalMoney) {
        this.totalMoney = totalMoney;
    }
}
