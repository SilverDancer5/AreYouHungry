package com.example.ayh.ui.dashboard;

import java.util.Date;

public class OrderCardItem {

    private int shopImgId;
    private String shopName;
    private String orderTime;
    private String hasGet;
    private String goods;
    private String price;

    public OrderCardItem(int shopImgId, String shopName, String orderTime, String hasGet, String goods, String price) {
        this.shopImgId = shopImgId;
        this.shopName = shopName;
        this.orderTime = orderTime;
        this.hasGet = hasGet;
        this.goods = goods;
        this.price = price;
    }

    public int getShopImgId() {
        return shopImgId;
    }

    public void setShopImgId(int shopImgId) {
        this.shopImgId = shopImgId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getOrderTime() {
        return orderTime;
    }


    public String getHasGet() {
        return hasGet;
    }

    public void setHasGet(String hasGet) {
        this.hasGet = hasGet;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
