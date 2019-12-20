package com.example.ayh.ui.home;

public class MyMenu {
    private int id;
    private int image;
    private String name;
    private String sellNumber;
    private String price;
    private String number;
    private int ifNeedSubtract;

    public MyMenu(int id, int image, String name, String sellNumber, String price, String number, int ifNeedSubtract) {
        this.image = image;
        this.name = name;
        this.sellNumber = sellNumber;
        this.price = price;
        this.number = number;
        this.ifNeedSubtract = ifNeedSubtract;
    }

    public MyMenu() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSellNumber() {
        return sellNumber;
    }

    public void setSellNumber(String sellNumber) {
        this.sellNumber = sellNumber;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getIfNeedSubtract() {
        return ifNeedSubtract;
    }

    public void setIfNeedSubtract(int ifNeedSubtract) {
        this.ifNeedSubtract = ifNeedSubtract;
    }
}
