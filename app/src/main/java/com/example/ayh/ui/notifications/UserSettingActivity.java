package com.example.ayh.ui.notifications;


import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;

import com.example.ayh.R;

import java.util.ArrayList;
import java.util.List;

public class UserSettingActivity extends AppCompatActivity {
    private List<UserSettingList> infoList = new ArrayList<>();
    private List<UserSettingList> bindList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_setting);


        /**
         * 顶部栏
         */
        //顶部栏名称
        UserSettingActivity.this.setTitle("个人资料");
        //顶部返回键
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        int color = this.getResources().getColor(R.color.blue);
        ColorDrawable drawable = new ColorDrawable(color);
        actionBar.setBackgroundDrawable(drawable);

        this.getWindow().setStatusBarColor(getResources().getColor(R.color.blue));


        /**
         * 列表
         */
        //列表初始化
        initUserSetting(1);
        UserSettingAdapter adapter = new UserSettingAdapter(UserSettingActivity.this, R.layout.usersetting_item, infoList);
        ListView infoListView = findViewById(R.id.info_ListView);
        TextView tv1 = new TextView(UserSettingActivity.this);
        tv1.setText("  基础信息");
        tv1.setTextColor(Color.parseColor("#909090"));
        tv1.setPadding(50, 2, 0, 2);
        infoListView.addHeaderView(tv1);
        infoListView.setAdapter(adapter);

        //列表初始化
        initUserSetting(2);
        adapter = new UserSettingAdapter(UserSettingActivity.this, R.layout.usersetting_item, bindList);
        ListView bindListView = findViewById(R.id.bind_ListView);
        TextView tv2 = new TextView(UserSettingActivity.this);
        tv2.setText("  账号绑定");
        tv2.setTextColor(Color.parseColor("#909090"));
        tv2.setPadding(50, 2, 0, 2);
        bindListView.addHeaderView(tv2);
        bindListView.setAdapter(adapter);





    }


    private void initUserSetting(int listID) {

        if(listID == 1) {
            RoundedBitmapDrawable roundedBitmapDrawable1 = RoundedBitmapDrawableFactory.create(getResources(), BitmapFactory.decodeResource(getResources(), R.drawable.tx));
            roundedBitmapDrawable1.setCircular(true);

            Log.i("User.curHeadImgID", User.curHeadImgID +"");
            UserSettingList usl1 = new UserSettingList("头像", ">", User.curHeadImgID);
            if(User.curHeadImgID == 0) {
                usl1= new UserSettingList("头像", ">", R.drawable.tx);
            } else {
                Log.i("headImg", User.curHeadImgID+"");
            }

            UserSettingList usl2 = new UserSettingList("用户名", User.curUserName);
            UserSettingList usl3 = new UserSettingList("收获地址", "江苏省 >");
            infoList.add(usl1);
            infoList.add(usl2);
            infoList.add(usl3);
        } else {
            UserSettingList usl1 = new UserSettingList("手机", R.drawable.sj,User.curUserPhone);
            UserSettingList usl2 = new UserSettingList("淘宝", R.drawable.tb,"未绑定 >");
            UserSettingList usl3 = new UserSettingList("支付宝", R.drawable.zfb, "未绑定 >");
            UserSettingList usl4 = new UserSettingList("微博", R.drawable.wb, "未绑定 >");
            UserSettingList usl5 = new UserSettingList("微信", R.drawable.wx, "未绑定 >");
            UserSettingList usl6 = new UserSettingList("QQ", R.drawable.qq, "未绑定 >");
            bindList.add(usl1);
            bindList.add(usl2);
            bindList.add(usl3);
            bindList.add(usl4);
            bindList.add(usl5);
            bindList.add(usl6);
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
