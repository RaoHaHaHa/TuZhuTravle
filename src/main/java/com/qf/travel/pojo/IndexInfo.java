package com.qf.travel.pojo;

public class IndexInfo {
    private int id;
    private String introduce;
    private String order_type;
    private String photo_src;
    private int price;
    private int product_id;

    public IndexInfo() {
    }

    public IndexInfo(int id, String introduce, String order_type, String photo_src, int price, int product_id) {
        this.id = id;
        this.introduce = introduce;
        this.order_type = order_type;
        this.photo_src = photo_src;
        this.price = price;
        this.product_id = product_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getOrder_type() {
        return order_type;
    }

    public void setOrder_type(String order_type) {
        this.order_type = order_type;
    }

    public String getPhoto_src() {
        return photo_src;
    }

    public void setPhoto_src(String photo_src) {
        this.photo_src = photo_src;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    @Override
    public String toString() {
        return "IndexInfo{" +
                "id=" + id +
                ", introduce='" + introduce + '\'' +
                ", order_type='" + order_type + '\'' +
                ", photo_src='" + photo_src + '\'' +
                ", price=" + price +
                ", product_id=" + product_id +
                '}';
    }
}
