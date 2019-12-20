package com.example.ayh.ui.dashboard;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.ayh.R;
import com.example.ayh.ui.notifications.Card;

import java.util.ArrayList;
import java.util.List;

public class OneMoreOrderActivity extends AppCompatActivity {


    String shopName;
    String goodsName;
    String totalPrice;

    TextView textView;
    ScrollView scrollView;
    ActionBar actionBar;


    private List<KeyValue_item> keyValueList = new ArrayList<>();
    private List<KeyValue_item> deliverList = new ArrayList<>();
    private List<KeyValue_item> orderList = new ArrayList<>();
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_more_order);


        Intent intent = getIntent();
        shopName = intent.getStringExtra("shopName");
        goodsName = intent.getStringExtra("goodsName");
        totalPrice = intent.getStringExtra("totalPrice");




        /**
         * 顶部栏
         */
        OneMoreOrderActivity.this.setTitle("");
        //顶部返回键
        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        int color = Color.parseColor("#00A5FF");
        ColorDrawable drawable = new ColorDrawable(color);
        actionBar.setBackgroundDrawable(drawable);
        actionBar.setElevation(0);
        this.getWindow().setStatusBarColor(Color.parseColor("#00A5FF"));


        /**
         * RecyleView
         */


        initKeyValueList(1);
        RecyclerView keyValueRecyleView = findViewById(R.id.orderInfo_ListView);

        KeyValueRecyleViewAdapter keyValueRecyleViewAdapter = new KeyValueRecyleViewAdapter(OneMoreOrderActivity.this, R.layout.keyvalue_item, keyValueList);
        //TODO 头部尾部
        keyValueRecyleView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        keyValueRecyleView.setAdapter(keyValueRecyleViewAdapter);



        initKeyValueList(2);
        RecyclerView deliverRecyleView = findViewById(R.id.deliver_ListView);
        KeyValue2Adapter deliverAdapter = new KeyValue2Adapter(this, R.layout.keyvalue2_item, deliverList);
        deliverRecyleView.setLayoutManager(new LinearLayoutManager(this));
        deliverRecyleView.setAdapter(deliverAdapter);

        initKeyValueList(3);
        RecyclerView orderRecycleView = findViewById(R.id.order_ListView);
        KeyValue2Adapter orderAdapter = new KeyValue2Adapter(this, R.layout.keyvalue2_item, orderList);
        orderRecycleView.setLayoutManager(new LinearLayoutManager(this));
        orderRecycleView.setAdapter(orderAdapter);


        textView = findViewById(R.id.title_Text);
        scrollView = findViewById(R.id.scrollView);

        scrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if(textView.getBottom() <= 0) {
                    actionBar.setTitle("21");
                } else {
                    actionBar.setTitle("订单已经送达");

                }
            }
        });




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

    public void initKeyValueList(int listID) {

        switch (listID) {
            case 1:




                Order orderForGoods = new Order(goodsName+"",
                                                "餐盒",
                                                "蜂鸟跑腿",
                                                "首次光顾立减",
                                                "红枣枸杞银耳汤",
                                                "店铺满减优惠",
                                                "店铺红包");
                KeyValue_item kvi1 = new KeyValue_item(R.drawable.ndcai, orderForGoods.getGoods()+"","x1", totalPrice+"");
                KeyValue_item kvi2 = new KeyValue_item(R.drawable.bzf, orderForGoods.getBox()+"", "","￥1");
                KeyValue_item kvi3 = new KeyValue_item(R.drawable.psf, orderForGoods.getDeliver()+"","","￥3");
                KeyValue_item kvi4 = new KeyValue_item(R.drawable.xk, orderForGoods.getNewCustomer() +"", " ","-￥1");
                KeyValue_item kvi5 = new KeyValue_item(R.drawable.mz, orderForGoods.getGiveaway()+"","x1", "￥0");
                KeyValue_item kvi6 = new KeyValue_item(R.drawable.mj, orderForGoods.getDiscount()+"", " ","-￥15");
                KeyValue_item kvi7 = new KeyValue_item(R.drawable.hb, orderForGoods.getRedPacket()+"", "","-￥7");

                keyValueList.add(kvi1);
                keyValueList.add(kvi2);
                keyValueList.add(kvi3);
                keyValueList.add(kvi4);
                keyValueList.add(kvi5);
                keyValueList.add(kvi6);
                keyValueList.add(kvi7);

                break;
            case 2:

                KeyValue_item kvi2_1 = new KeyValue_item("配送信息", " ");
                KeyValue_item kvi2_2 = new KeyValue_item("送达时间", "尽快送达");
                KeyValue_item kvi2_3 = new KeyValue_item("收货地址", "金陵科技学院");
                KeyValue_item kvi2_4 = new KeyValue_item("配送方式", "蜂鸟跑腿");

                deliverList.add(kvi2_1);
                deliverList.add(kvi2_2);
                deliverList.add(kvi2_3);
                deliverList.add(kvi2_4);

                break;
            case 3:

                Order orderForOrderInfo = new Order(20191219, "在线支付", "2019-12-19");

                KeyValue_item kvi3_1 = new KeyValue_item("订单信息", "");
                KeyValue_item kvi3_2 = new KeyValue_item("订单号", orderForOrderInfo.getOrderID()+"");
                KeyValue_item kvi3_3 = new KeyValue_item("祝福方式", orderForOrderInfo.getPayType()+"");
                KeyValue_item kvi3_4 = new KeyValue_item("下单时间", orderForOrderInfo.getDate()+"");

                orderList.add(kvi3_1);
                orderList.add(kvi3_2);
                orderList.add(kvi3_3);
                orderList.add(kvi3_4);
                break;
            default:
                break;
        }

        Log.i("listSize", ""+keyValueList.size());
    }


}
