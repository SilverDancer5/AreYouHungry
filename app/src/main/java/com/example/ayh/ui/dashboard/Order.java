package com.example.ayh.ui.dashboard;

public class Order {


    /**
     * 商品信息
     */
    private int orderID;
    private String payType;
    private String Date;

    /**
     * 配送信息
     */

    private String sendTime;
    private String address;
    /**
     * 订单信息
     */
    private String goods;
    private String box;
    private String deliver;
    private String newCustomer;
    private String giveaway;
    private String discount;
    private String redPacket;

    /**
     *
     */


    public Order(int orderID, String payType, String date) {
        this.orderID = orderID;
        this.payType = payType;
        Date = date;
    }


    public Order(String sendTime, String address, String deliver) {
        this.sendTime = sendTime;
        this.address = address;
        this.deliver = deliver;
    }


    public Order(String goods, String box, String deliver, String newCustomer, String giveaway, String discount, String redPacket) {
        this.goods = goods;
        this.box = box;
        this.deliver = deliver;
        this.newCustomer = newCustomer;
        this.giveaway = giveaway;
        this.discount = discount;
        this.redPacket = redPacket;
    }


    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public String getBox() {
        return box;
    }

    public void setBox(String box) {
        this.box = box;
    }

    public String getDeliver() {
        return deliver;
    }

    public void setDeliver(String deliver) {
        this.deliver = deliver;
    }

    public String getNewCustomer() {
        return newCustomer;
    }

    public void setNewCustomer(String newCustomer) {
        this.newCustomer = newCustomer;
    }

    public String getGiveaway() {
        return giveaway;
    }

    public void setGiveaway(String giveaway) {
        this.giveaway = giveaway;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getRedPacket() {
        return redPacket;
    }

    public void setRedPacket(String redPacket) {
        this.redPacket = redPacket;
    }
}
