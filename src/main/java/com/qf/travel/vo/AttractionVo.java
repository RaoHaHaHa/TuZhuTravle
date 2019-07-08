package com.qf.travel.vo;

public class AttractionVo {
    private int product_id;
    private String  photo_src;
    private String  order_type;
    private String introduce;
    private int price;
    private int[] ids;
    private int currentPage;
    private int pageSize;

    public int[] getIds() {
        return ids;
    }

    public void setIds(int[] ids) {
        this.ids = ids;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getPhoto_src() {
        return photo_src;
    }

    public void setPhoto_src(String photo_src) {
        this.photo_src = photo_src;
    }

    public String getOrder_type() {
        return order_type;
    }

    public void setOrder_type(String order_type) {
        this.order_type = order_type;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "AttractionVo{" +
                "product_id=" + product_id +
                ", photo_src='" + photo_src + '\'' +
                ", order_type='" + order_type + '\'' +
                ", introduce='" + introduce + '\'' +
                ", price=" + price +
                ", currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                '}';
    }
}
