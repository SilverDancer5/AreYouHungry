package com.example.ayh.ui.notifications;

import android.media.Image;

public class UserSettingList {
    private String name;
    private int iconId;
    private String info;
    private int header;
    

    public UserSettingList(String name, int iconId) {
        this.name = name;
        this.iconId = iconId;
    }

    public UserSettingList(String name, String info) {
        this.name = name;
        this.info = info;
    }


    public UserSettingList(String name, int iconId, String info) {
        this.info = "未绑定";
        if(info != null) {
            this.info = info;
        }
        this.name = name;
        this.iconId = iconId;


    }

    public UserSettingList(String name, String info, int header) {
        this.name = name;
        this.info = info;
        this.header = header;
    }

    public int getHeader() {
        return header;
    }

    public void setHeader(int header) {
        this.header = header;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIconId() {
        return iconId;
    }



    public String getInfo() {
        return info;
    }


}
