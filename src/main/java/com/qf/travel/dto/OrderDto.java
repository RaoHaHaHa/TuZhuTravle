package com.qf.travel.dto;

import com.qf.travel.entity.Order;

/**
 * 订单扩展类
 */
public class OrderDto extends Order {

    private String introduce;
    private String photo_src;
    private String goto_time;
    private String goback_time;
    private String stat;

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getPhoto_src() {
        return photo_src;
    }

    public void setPhoto_src(String photo_src) {
        this.photo_src = photo_src;
    }

    public String getGoto_time() {
        return goto_time;
    }

    public void setGoto_time(String goto_time) {
        this.goto_time = goto_time;
    }

    public String getGoback_time() {
        return goback_time;
    }

    public void setGoback_time(String goback_time) {
        this.goback_time = goback_time;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "introduce='" + introduce + '\'' +
                ", photo_src='" + photo_src + '\'' +
                ", goto_time='" + goto_time + '\'' +
                ", goback_time='" + goback_time + '\'' +
                ", stat='" + stat + '\'' +
                '}';
    }
}
