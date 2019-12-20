package com.example.ayh.ui.dashboard;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.ayh.R;

public class MyHeaderView extends LinearLayout {

    TextView textView;
    Button btn;


    public MyHeaderView(Context context) {
        super(context);
    }

    public MyHeaderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyHeaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyHeaderView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.header, this, true);
        btn = findViewById(R.id.btn_header);
        textView = findViewById(R.id.text_header);

    }


    //设置标题文字的方法
    private void setMyText(String title) {
        if (!TextUtils.isEmpty(title)) {
            textView.setText(title);
        }
    }


    //对右边按钮设置事件的方法
    private void setRightListener(OnClickListener onClickListener) {
        btn.setOnClickListener(onClickListener);
    }
}
