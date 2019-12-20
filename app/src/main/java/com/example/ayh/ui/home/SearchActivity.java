package com.example.ayh.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ayh.R;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView iv_back, iv_search, iv_clear;
    private TextView tv_1, tv_2, tv_3, tv_4, tv_5, tv_6, tv_7, tv_8, tv_9, tv_10;
    private EditText ed_search;
    private FlowLayout flowLayout;
    public static List<String> historyList = new ArrayList<>();
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        getSupportActionBar().hide();

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
//        int color = this.getResources().getColor(R.color.buttoncolor3);
//        ColorDrawable drawable = new ColorDrawable(color);
//        actionBar.setBackgroundDrawable(drawable);

        this.getWindow().setStatusBarColor(getResources().getColor(R.color.textcolor4));

        iv_back = findViewById(R.id.iv_backToTackout);
        iv_search = findViewById(R.id.iv_search);
        iv_clear = findViewById(R.id.iv_clear);
        ed_search = findViewById(R.id.ed_search);
        flowLayout = findViewById(R.id.folwLayout);
        tv_1 = findViewById(R.id.tv_1);
        tv_2 = findViewById(R.id.tv_2);
        tv_3 = findViewById(R.id.tv_3);
        tv_4 = findViewById(R.id.tv_4);
        tv_5 = findViewById(R.id.tv_5);
        tv_6 = findViewById(R.id.tv_6);
        tv_7 = findViewById(R.id.tv_7);
        tv_8 = findViewById(R.id.tv_8);
        tv_9 = findViewById(R.id.tv_9);
        tv_10 = findViewById(R.id.tv_10);
        iv_back.setOnClickListener(this);
        iv_search.setOnClickListener(this);
        iv_clear.setOnClickListener(this);
        ed_search.setOnClickListener(this);
        tv_1.setOnClickListener(this);
        tv_2.setOnClickListener(this);
        tv_3.setOnClickListener(this);
        tv_4.setOnClickListener(this);
        tv_5.setOnClickListener(this);
        tv_6.setOnClickListener(this);
        tv_7.setOnClickListener(this);
        tv_8.setOnClickListener(this);
        tv_9.setOnClickListener(this);
        tv_10.setOnClickListener(this);
        updataHistoryList();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_backToTackout:
                finish();
                break;
            case R.id.iv_search:
                int i = 0;
                if ((ed_search.getText().toString()).equals("")) {
                    text = "麦当劳";
                } else {
                    text = ed_search.getText().toString();
                }
                for (i = 0; i < historyList.size(); i++) {
                    if (text.equals(historyList.get(i))) {
                        break;
                    }
                }
                Intent intent1 = new Intent(SearchActivity.this, SearchResultActivity.class);
                intent1.putExtra("key", text);
                finish();
                startActivity(intent1);
                ed_search.setText("");
                if (i == historyList.size()) {
                    historyList.add(text);
                    updataHistoryList();
                }
                break;
            case R.id.iv_clear:
                historyList.clear();
                updataHistoryList();
                break;
            case R.id.ed_search:
                break;
            case R.id.tv_1:
                intentByTextview(tv_1);
                break;
            case R.id.tv_2:
                intentByTextview(tv_2);
                break;
            case R.id.tv_3:
                intentByTextview(tv_3);
                break;
            case R.id.tv_4:
                intentByTextview(tv_4);
                break;
            case R.id.tv_5:
                intentByTextview(tv_5);
                break;
            case R.id.tv_6:
                intentByTextview(tv_6);
                break;
            case R.id.tv_7:
                intentByTextview(tv_7);
                break;
            case R.id.tv_8:
                intentByTextview(tv_8);
                break;
            case R.id.tv_9:
                intentByTextview(tv_9);
                break;
            case R.id.tv_10:
                intentByTextview(tv_10);
                break;
        }
    }

    public void updataHistoryList() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(10, 5, 10, 5);
        if (flowLayout != null) {
            flowLayout.removeAllViews();
        }
        for (int i = 0; i < historyList.size(); i++) {
            TextView tv = new TextView(SearchActivity.this);
            tv.setPadding(10, 10, 10, 10);
            tv.setText(historyList.get(i));
            tv.setMaxEms(10);
            tv.setTextSize(18);
            tv.setSingleLine();
            tv.setBackgroundResource(R.drawable.background6);
            tv.setLayoutParams(layoutParams);
            flowLayout.addView(tv, layoutParams);
        }
    }

    public void intentByTextview(TextView tv) {
        text = tv.getText().toString();
        Intent intent = new Intent(SearchActivity.this, SearchResultActivity.class);
        intent.putExtra("key", text);
        startActivity(intent);
        finish();
        int i;
        for (i = 0; i < historyList.size(); i++) {
            if (text.equals(historyList.get(i))) {
                break;
            }
        }
        if (i == historyList.size()) {
            historyList.add(text);
            updataHistoryList();
        }
    }
}
