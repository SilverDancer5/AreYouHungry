package com.example.ayh.ui.dashboard;

public class KeyValue_item {
    private int imgId;
    private String key;
    private String num;
    private String value;


    public KeyValue_item(int imgId, String key, String num, String value) {
        this.imgId = imgId;
        this.key = key;
        this.num = num;
        this.value = value;
    }

    public KeyValue_item(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
