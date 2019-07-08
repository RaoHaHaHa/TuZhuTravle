package com.qf.travel.pojo;

import com.qf.travel.pojo.ext.Address;

public class FavoriteInfo extends Address {
    private int user_id;
    private int id;

    public FavoriteInfo() {
    }

    public FavoriteInfo(int user_id, int id) {
        this.user_id = user_id;
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "FavoriteInfo{" +
                "user_id=" + user_id +
                ", id=" + id +
                '}';
    }
}
