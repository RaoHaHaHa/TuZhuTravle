package com.qf.travel.entity;

/**
 * 订单实体类
 */
public class Order {
    //id     user_id  order_id  product_id   price
    // num  order_type  generate_date        last_date  pay_type

    private int id;
    private int user_id;
    private int order_id;
    private int product_id;
    private int price;
    private int num;
    private String order_type;
    private String pay_type;
    private String generate_date;
    private String last_date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getOrder_type() {
        return order_type;
    }

    public void setOrder_type(String order_type) {
        this.order_type = order_type;
    }

    public String getPay_type() {
        return pay_type;
    }

    public void setPay_type(String pay_type) {
        this.pay_type = pay_type;
    }

    public String getGenerate_date() {
        return generate_date;
    }

    public void setGenerate_date(String generate_date) {
        this.generate_date = generate_date;
    }

    public String getLast_date() {
        return last_date;
    }

    public void setLast_date(String last_date) {
        this.last_date = last_date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", order_id=" + order_id +
                ", product_id=" + product_id +
                ", price=" + price +
                ", num=" + num +
                ", order_type='" + order_type + '\'' +
                ", pay_type='" + pay_type + '\'' +
                ", generate_date='" + generate_date + '\'' +
                ", last_date='" + last_date + '\'' +
                '}';
    }
}
