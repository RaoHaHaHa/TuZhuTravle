package com.qf.travel.pojo.ext;

import com.qf.travel.pojo.IndexInfo;

public class Address extends IndexInfo {
    private int id;
    private String merchant;
    private int phone;
    private String address;


    public Address(int id, String merchant, int phone, String address) {
        this.id = id;
        this.merchant = merchant;
        this.phone = phone;
        this.address = address;
    }
    public Address(){

    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", merchant='" + merchant + '\'' +
                ", phone=" + phone +
                ", address='" + address + '\'' +
                '}';
    }
}
