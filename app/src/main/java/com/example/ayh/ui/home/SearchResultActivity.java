package com.example.ayh.ui.home;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.ayh.R;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SearchResultActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tv_remark, tv_sellNumber, tv_distance, tv_time, tv_startPrice, tv_sendPrice;
    private static int flag5 = 1, flag6 = 0, flag7 = 0, flag8 = 0, flag9 = 0, flag10 = 0;
    private MyListView myListView;
    private Database database;
    private ShoperAdapter shoperAdapter;
    private List<Shoper> shoperList;
    private ImageView iv_back, iv_search;
    private EditText ed_search;
    private String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

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


        database = new Database(SearchResultActivity.this, "SHOP.DB", null, 1);
        iv_back = findViewById(R.id.iv_backToSearch);
        iv_search = findViewById(R.id.iv_search);
        ed_search = findViewById(R.id.ed_search);
        tv_remark = findViewById(R.id.tv_remark);
        tv_remark.setTextColor(ContextCompat.getColor(SearchResultActivity.this, R.color.textcolor3));
        tv_sellNumber = findViewById(R.id.tv_sellNumber);
        tv_distance = findViewById(R.id.tv_distance);
        tv_time = findViewById(R.id.tv_time);
        tv_startPrice = findViewById(R.id.tv_startPrice);
        tv_sendPrice = findViewById(R.id.tv_sendPrice);

        iv_back.setOnClickListener(this);
        iv_search.setOnClickListener(this);
        ed_search.setOnClickListener(this);
        tv_remark.setOnClickListener(this);
        tv_sellNumber.setOnClickListener(this);
        tv_distance.setOnClickListener(this);
        tv_time.setOnClickListener(this);
        tv_startPrice.setOnClickListener(this);
        tv_sendPrice.setOnClickListener(this);

        database.delete();
        database.insert();
        myListView = findViewById(R.id.lv_shoperlist);
        Intent intent = getIntent();
        shoperList = database.select("SHOP", intent.getStringExtra("key"), null);
        shopSort();
        shoperAdapter = new ShoperAdapter(shoperList, SearchResultActivity.this);
        myListView.setAdapter(shoperAdapter);
    }

    public void shopSort() {
        if (flag5 == 1) {
            Collections.sort(shoperList, new Comparator<Shoper>() {
                public int compare(Shoper o1, Shoper o2) {
                    double judge = Double.parseDouble(o1.getRemark()) - Double.parseDouble(o2.getRemark());
                    if (judge > 0) {
                        return -1;
                    }
                    return 1;
                }
            });
        }
        if (flag6 == 1) {
            Collections.sort(shoperList, new Comparator<Shoper>() {
                public int compare(Shoper o1, Shoper o2) {
                    int i = Integer.parseInt(o1.getSellNumber()) - Integer.parseInt(o2.getSellNumber());
                    return -i;
                }
            });
        }
        if (flag7 == 1) {
            Collections.sort(shoperList, new Comparator<Shoper>() {
                public int compare(Shoper o1, Shoper o2) {
                    int i = Integer.parseInt(o1.getDistance()) - Integer.parseInt(o2.getDistance());
                    return i;
                }
            });
        }
        if (flag8 == 1) {
            Collections.sort(shoperList, new Comparator<Shoper>() {
                public int compare(Shoper o1, Shoper o2) {
                    int i = Integer.parseInt(o1.getNeedTime()) - Integer.parseInt(o2.getNeedTime());
                    return i;
                }
            });
        }
        if (flag9 == 1) {
            Collections.sort(shoperList, new Comparator<Shoper>() {
                public int compare(Shoper o1, Shoper o2) {
                    int i = Integer.parseInt(o1.getStartSendPrice()) - Integer.parseInt(o2.getStartSendPrice());
                    return i;
                }
            });
        }
        if (flag10 == 1) {
            Collections.sort(shoperList, new Comparator<Shoper>() {
                public int compare(Shoper o1, Shoper o2) {
                    float judge = Float.parseFloat(o1.getSendPrice()) - Float.parseFloat(o2.getSendPrice());
                    if (judge > 0) {
                        return 1;
                    }
                    return -1;
                }
            });
        }
        shoperAdapter = new ShoperAdapter(shoperList, SearchResultActivity.this);
        myListView.setAdapter(shoperAdapter);
        shoperAdapter.notifyDataSetChanged();
    }

    public int shopSortChange() {
        flag5 = 0;
        flag6 = 0;
        flag7 = 0;
        flag8 = 0;
        flag9 = 0;
        flag10 = 0;
        tv_remark.setTextColor(ContextCompat.getColor(SearchResultActivity.this, R.color.textcolor2));
        tv_sellNumber.setTextColor(ContextCompat.getColor(SearchResultActivity.this, R.color.textcolor2));
        tv_time.setTextColor(ContextCompat.getColor(SearchResultActivity.this, R.color.textcolor2));
        tv_distance.setTextColor(ContextCompat.getColor(SearchResultActivity.this, R.color.textcolor2));
        tv_sendPrice.setTextColor(ContextCompat.getColor(SearchResultActivity.this, R.color.textcolor2));
        tv_startPrice.setTextColor(ContextCompat.getColor(SearchResultActivity.this, R.color.textcolor2));
        return 1;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_backToSearch:
                finish();
                break;
            case R.id.iv_search:
                int i;
                if ((ed_search.getText().toString()).equals("")) {
                    text = "麦当劳";
                } else {
                    text = ed_search.getText().toString();
                }
                for (i = 0; i < SearchActivity.historyList.size(); i++) {
                    if (text.equals(SearchActivity.historyList.get(i))) {
                        break;
                    }
                }
                if (i == SearchActivity.historyList.size()) {
                    SearchActivity.historyList.add(text);
                }
                myListView = findViewById(R.id.lv_shoperlist);
                shoperList = database.select("SHOP", text, null);
                shopSortChange();
                flag5 = 1;
                tv_remark.setTextColor(ContextCompat.getColor(SearchResultActivity.this, R.color.textcolor3));
                shopSort();
                shoperAdapter = new ShoperAdapter(shoperList, SearchResultActivity.this);
                myListView.setAdapter(shoperAdapter);
                shoperAdapter.notifyDataSetChanged();
                ed_search.setText("");
                break;
            case R.id.ed_search:
                break;
            case R.id.tv_remark:
                flag5 = shopSortChange();
                shopSort();
                tv_remark.setTextColor(ContextCompat.getColor(v.getContext(), R.color.textcolor3));
                break;
            case R.id.tv_sellNumber:
                flag6 = shopSortChange();
                shopSort();
                tv_sellNumber.setTextColor(ContextCompat.getColor(v.getContext(), R.color.textcolor3));
                break;
            case R.id.tv_distance:
                flag7 = shopSortChange();
                shopSort();
                tv_distance.setTextColor(ContextCompat.getColor(v.getContext(), R.color.textcolor3));
                break;
            case R.id.tv_time:
                flag8 = shopSortChange();
                shopSort();
                tv_time.setTextColor(ContextCompat.getColor(v.getContext(), R.color.textcolor3));
                break;
            case R.id.tv_startPrice:
                flag9 = shopSortChange();
                shopSort();
                tv_startPrice.setTextColor(ContextCompat.getColor(v.getContext(), R.color.textcolor3));
                break;
            case R.id.tv_sendPrice:
                flag10 = shopSortChange();
                shopSort();
                tv_sendPrice.setTextColor(ContextCompat.getColor(v.getContext(), R.color.textcolor3));
                break;
        }
    }
}
