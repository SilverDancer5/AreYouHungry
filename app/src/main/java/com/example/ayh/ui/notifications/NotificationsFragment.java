package com.example.ayh.ui.notifications;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.ayh.R;

import java.util.ArrayList;
import java.util.List;

public class NotificationsFragment extends Fragment {
    Button vipBtn;
    Button btn_1;
    Button clockBtn;
    ImageView headerImg;

    private List<UserSettingList> usList = new ArrayList<>();

    private NotificationsViewModel notificationsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);


        final View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        final TextView textView = root.findViewById(R.id.text_notifications_UserName);



        notificationsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(User.curUserName);
            }
        });


        clockBtn = root.findViewById(R.id.clock_btn);
        clockBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(root.getContext(), "签到成功， 快去下单吧！", Toast.LENGTH_SHORT).show();
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(root.getContext(), UserSettingActivity.class);
                startActivity(intent);
            }
        });


       //圆形头像

        if(User.curHeadImgID == 0) {
            headerImg = root.findViewById(R.id.headerImg);
            RoundedBitmapDrawable roundedBitmapDrawable1 = RoundedBitmapDrawableFactory.create(getResources(), BitmapFactory.decodeResource(getResources(), R.drawable.tx));
            roundedBitmapDrawable1.setCircular(true);
            headerImg.setImageDrawable(roundedBitmapDrawable1);
        } else {
            headerImg = root.findViewById(R.id.headerImg);
            RoundedBitmapDrawable roundedBitmapDrawable2 = RoundedBitmapDrawableFactory.create(getResources(), BitmapFactory.decodeResource(getResources(), User.curHeadImgID));
            roundedBitmapDrawable2.setCircular(true);
            headerImg.setImageDrawable(roundedBitmapDrawable2);
        }


        //列表初始化
        initUserSetting();
        UserSettingAdapter adapter = new UserSettingAdapter(this.getActivity(), R.layout.usersetting_item, usList);
        ListView listView = root.findViewById(R.id.ListView);
        listView.setAdapter(adapter);


        //点击功能
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                UserSettingList usl = usList.get(position);
                switch (position) {
                    case 0:
                        Intent intent_0 = new Intent(view.getContext(), Collection.class);
                        startActivity(intent_0);
                        break;
                    case 1:
                        Intent intent_1 = new Intent(view.getContext(), Customer.class);
                        startActivity(intent_1);
                        break;
                    case 2:
                        Intent intent_2 = new Intent(view.getContext(), Recommend.class);
                        startActivity(intent_2);
                        break;
                    case 3:
                        Intent intent_3 = new Intent(view.getContext(), Cooperation.class);
                        startActivity(intent_3);
                        break;
                    case 4:
                        Intent intent_4 = new Intent(view.getContext(), Card.class);
                        startActivity(intent_4);
                        break;
                    case 5:
                        Intent intent_5 = new Intent(view.getContext(), Welfare.class);
                        startActivity(intent_5);
                        break;
                    default:
                        break;
                }


            }
        });


        /**
         * 富文本
         */
        //字体颜色
        SpannableString spannableString = new SpannableString("超级会员\r\r\r\r\r开通后，每月超过20元红包 >");
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(this.getResources().getColor(R.color.red));
        spannableString.setSpan(colorSpan, 17, 19, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        //字体大小
        RelativeSizeSpan sizeSpan01 = new RelativeSizeSpan(0.9f);
        RelativeSizeSpan sizeSpan02 = new RelativeSizeSpan(0.5f);
        spannableString.setSpan(sizeSpan01, 0, 6, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(sizeSpan02, 4, spannableString.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        vipBtn = root.findViewById(R.id.vip_Btn);
        vipBtn.setText(spannableString);


        SpannableString spannableString1 = new SpannableString("超级会员");
        ForegroundColorSpan colorSpan1 = new ForegroundColorSpan(this.getResources().getColor(R.color.red));
        spannableString1.setSpan(colorSpan1, 0, 2, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        btn_1 = root.findViewById(R.id.btn_1);
        btn_1.setText(spannableString1);



        return root;
    }


    private void initUserSetting() {
        UserSettingList usl1 = new UserSettingList("我的收藏", R.drawable.sc);
        UserSettingList usl2 = new UserSettingList("我的客服", R.drawable.kf);
        UserSettingList usl3 = new UserSettingList("推荐有奖", R.drawable.lw);
        UserSettingList usl4 = new UserSettingList("商务合作", R.drawable.gwb);
        UserSettingList usl5 = new UserSettingList("办卡有礼", R.drawable.kp);
        UserSettingList usl6 = new UserSettingList("3小时公益", R.drawable.gy);
        usList.add(usl1);
        usList.add(usl2);
        usList.add(usl3);
        usList.add(usl4);
        usList.add(usl5);
        usList.add(usl6);

    }




}