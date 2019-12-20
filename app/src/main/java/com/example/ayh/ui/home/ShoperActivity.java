package com.example.ayh.ui.home;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.ayh.R;

import java.util.ArrayList;
import java.util.List;

public class ShoperActivity extends AppCompatActivity implements View.OnClickListener {
    public ListView listView;
    public RelativeLayout relativelayout;
    public LinearLayout layout_shoppingCart;
    public TextView tv_totleMoney, tv_allGoods, tv_background, tv_clear;
    public static MymenuAdapyer mymenuAdapyer;
    public static List<MyMenu> myMenuList, myMenuList2;
    public static ImageView iv_pay;
    public static String startSendPrice;
    public static TextView tv_needMoney, tv_sendPrice, tv_pay, tv_title_needSendMoney, tv_needSendMoney;

    private Database database;
    private MyListView mylistview1, mylistview2;
    private ShoperAdapter shoperAdapter;
    private ShoppingCartAdapter shoppingCartAdapter;
    ContentValues contentValues;
    private List<Shoper> shoperList;
    private static String[] key = {"", "", "", ""};

    private TextView tv_shopName, tv_collect, tv_remark, tv_sellNumber, tv_time;
    private TextView tv_shoper_label1, tv_shoper_label2, tv_shoper_label3, tv_shoper_label4, tv_shoper_label5;
    public ImageView iv_collect, iv_shopIcon, iv_clear;
    public int ifCollected = -1, ifOpenTheCart = -1;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoper);
        Intent intent = getIntent();
        String shopName = intent.getStringExtra("shopName");
        database = new Database(ShoperActivity.this, "SHOP.DB", null, 1);
        mylistview1 = findViewById(R.id.listview);
        mylistview2 = findViewById(R.id.mylistview);
        shoperList = database.select("SHOP", shopName, key);

        ShoperActivity.this.setTitle(shoperList.get(0).getShopName());
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        int color = this.getResources().getColor(R.color.buttoncolor4);
        ColorDrawable drawable = new ColorDrawable(color);
        actionBar.setBackgroundDrawable(drawable);

        this.getWindow().setStatusBarColor(getResources().getColor(R.color.buttoncolor4));

        tv_totleMoney = findViewById(R.id.tv_totleMoney);
        tv_allGoods = findViewById(R.id.tv_allGoods);
        relativelayout = findViewById(R.id.relativelayout);
        tv_shopName = findViewById(R.id.tv_shopName);
        tv_collect = findViewById(R.id.tv_collect);
        iv_collect = findViewById(R.id.iv_collect);
        iv_shopIcon = findViewById(R.id.iv_shopIcon);
        iv_clear = findViewById(R.id.iv_clear);
        tv_remark = findViewById(R.id.tv_remark);
        tv_sellNumber = findViewById(R.id.tv_sellNumber);
        tv_time = findViewById(R.id.tv_time);
        tv_background = findViewById(R.id.tv_background);
        tv_clear = findViewById(R.id.tv_clear);
        tv_shoper_label1 = findViewById(R.id.tv_shoper_label1);
        tv_shoper_label2 = findViewById(R.id.tv_shoper_label2);
        tv_shoper_label3 = findViewById(R.id.tv_shoper_label3);
        tv_shoper_label4 = findViewById(R.id.tv_shoper_label4);
        tv_shoper_label5 = findViewById(R.id.tv_shoper_label5);
        layout_shoppingCart = findViewById(R.id.layout_shoppingCart);
        tv_shopName.setText(shoperList.get(0).getShopName());
        tv_remark.setText(shoperList.get(0).getRemark());
        tv_sellNumber.setText(shoperList.get(0).getSellNumber());
        tv_time.setText(shoperList.get(0).getNeedTime());
        tv_shoper_label1.setText(shoperList.get(0).getLabel1());
        tv_shoper_label2.setText(shoperList.get(0).getLabel2());
        tv_shoper_label3.setText(shoperList.get(0).getLabel3());
        tv_shoper_label4.setText(shoperList.get(0).getLabel4());
        tv_shoper_label5.setText(shoperList.get(0).getLabel5());
        iv_shopIcon.setImageResource(shoperList.get(0).getImage());
        ifCollected = shoperList.get(0).getIfCollected();
        if (ifCollected == 1) {
            iv_collect.setImageDrawable(getResources().getDrawable(R.drawable.icon_collect));
            tv_collect.setTextColor(ContextCompat.getColor(ShoperActivity.this, R.color.textcolor6));
            tv_collect.setText("已收藏");
        }

        tv_totleMoney.setOnClickListener(this);
        tv_allGoods.setOnClickListener(this);
        relativelayout.setOnClickListener(this);
        tv_collect.setOnClickListener(this);
        iv_collect.setOnClickListener(this);
        tv_background.setOnClickListener(this);
        layout_shoppingCart.setOnClickListener(this);
        tv_clear.setOnClickListener(this);
        iv_pay = findViewById(R.id.iv_shopState);
        tv_needMoney = findViewById(R.id.tv_needMoney);
        tv_sendPrice = findViewById(R.id.tv_needSendMoney);
        tv_pay = findViewById(R.id.tv_totleMoney);
        tv_title_needSendMoney = findViewById(R.id.tv_title_needSendMoney);
        tv_needSendMoney = findViewById(R.id.tv_needSendMoney);
        tv_needMoney.setText("未选购商品");
        tv_sendPrice.setText(shoperList.get(0).getSendPrice());
        tv_pay.setText("¥" + shoperList.get(0).getStartSendPrice() + "起送");
        startSendPrice = shoperList.get(0).getStartSendPrice();

        listView = findViewById(R.id.listview);
        myMenuList = new ArrayList<>();
        myMenuList.add(database.selectMenuItem(shoperList.get(0).getFood1()));
        myMenuList.add(database.selectMenuItem(shoperList.get(0).getFood2()));
        myMenuList.add(database.selectMenuItem(shoperList.get(0).getFood3()));
        myMenuList.add(database.selectMenuItem(shoperList.get(0).getFood4()));
        myMenuList.add(database.selectMenuItem(shoperList.get(0).getFood5()));
        myMenuList2 = new ArrayList<>();
        mymenuAdapyer = new MymenuAdapyer(myMenuList, this);
        listView.setAdapter(mymenuAdapyer);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_totleMoney:
                contentValues = new ContentValues();
                List<Bill> billList = database.selectBill();
                contentValues.put("ID", billList.size());
                contentValues.put("userID", shoperList.get(0).getId());
                contentValues.put("shopID", shoperList.get(0).getId());
                contentValues.put("foodNumber1", myMenuList.get(0).getNumber());
                contentValues.put("foodNumber2", myMenuList.get(1).getNumber());
                contentValues.put("foodNumber3", myMenuList.get(2).getNumber());
                contentValues.put("foodNumber4", myMenuList.get(3).getNumber());
                contentValues.put("foodNumber5", myMenuList.get(4).getNumber());
                String str = tv_needMoney.getText().toString();
                if (!str.equals("未选购商品") && Float.parseFloat(str.substring(1, str.length())) >= Float.parseFloat(startSendPrice)) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                    builder.setTitle("提示").setMessage("总共¥" + Float.parseFloat(str.substring(1, str.length())) + ", 是否确认支付？");
                    builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            database.insertBill("BILL", contentValues);
                            Toast.makeText(ShoperActivity.this, "生成新账单!", Toast.LENGTH_SHORT).show();
                            Log.i("AAA",database.selectBill().size()+"");
                            dialog.dismiss();
                        }
                    });
                    builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    builder.create().show();
                }
                break;
            case R.id.tv_clear:
                //初始化各数据
                for (MyMenu item : myMenuList) {
                    item.setNumber("0");
                    item.setIfNeedSubtract(0);
                }
                tv_needMoney.setText("未选购商品");
                tv_needMoney.setBackground(v.getResources().getDrawable(R.drawable.background11));
                iv_pay.setImageDrawable(v.getResources().getDrawable(R.drawable.icon_unshop));
                tv_pay.setText("¥" + ShoperActivity.startSendPrice + "起送");
                tv_pay.setBackground(v.getResources().getDrawable(R.drawable.background18));
                tv_pay.setTextColor(ContextCompat.getColor(v.getContext(), R.color.textcolor5));
                tv_title_needSendMoney.setBackground(v.getResources().getDrawable(R.drawable.background11));
                tv_needSendMoney.setBackground(v.getResources().getDrawable(R.drawable.background11));
                mymenuAdapyer.notifyDataSetChanged();
                updataTheShoppingCart();
                break;
            case R.id.layout_shoppingCart:
                break;
            case R.id.tv_background:
                layout_shoppingCart.setVisibility(View.INVISIBLE);
                tv_background.setVisibility(View.INVISIBLE);
                break;
            case R.id.tv_allGoods:
                updataTheShoppingCart();
                if (ifOpenTheCart == -1) {
                    layout_shoppingCart.setVisibility(View.VISIBLE);
                    tv_background.setVisibility(View.VISIBLE);
                } else {
                    layout_shoppingCart.setVisibility(View.INVISIBLE);
                    tv_background.setVisibility(View.INVISIBLE);
                }
                ifOpenTheCart = -ifOpenTheCart;
                break;
            case R.id.tv_collect:
            case R.id.iv_collect:
                ifCollected = changeCollectState(ifCollected);
                break;
            case R.id.relativelayout:
                break;
            case R.id.iv_add:
                break;
            case R.id.iv_subtract:
                finish();
                break;
        }
    }

    public int changeCollectState(int flag) {
        if (flag == -1) {
            iv_collect.setImageDrawable(getResources().getDrawable(R.drawable.icon_collect));
            tv_collect.setTextColor(ContextCompat.getColor(ShoperActivity.this, R.color.textcolor6));
            tv_collect.setText("已收藏");
            Toast.makeText(ShoperActivity.this, "已收藏店铺：" + tv_shopName.getText().toString(), Toast.LENGTH_SHORT).show();
        } else {
            iv_collect.setImageDrawable(getResources().getDrawable(R.drawable.icon_uncollect));
            tv_collect.setTextColor(ContextCompat.getColor(ShoperActivity.this, R.color.textcolor5));
            tv_collect.setText("收藏");
            Toast.makeText(ShoperActivity.this, "取消收藏", Toast.LENGTH_SHORT).show();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("ifCollected", -flag);
        database.update("SHOP", contentValues, shoperList.get(0).getId());
        return -flag;
    }

    //更新购物车
    public void updataTheShoppingCart() {
        myMenuList2.clear();
        for (MyMenu item : myMenuList) {
            if (Integer.parseInt(item.getNumber()) != 0) {
                myMenuList2.add(item);
            }
        }
        shoppingCartAdapter = new ShoppingCartAdapter(myMenuList2, ShoperActivity.this);
        mylistview2.setAdapter(shoppingCartAdapter);
        shoppingCartAdapter.notifyDataSetChanged();
    }

}
