package com.example.ayh.ui.home;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;

import com.example.ayh.R;

import java.util.List;

public class FruitShopActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout layout1, layout2, layout3, layout4, layout5, layout6;
    private TextView tv_intoShop, tv_intoShop2;
    private ImageView pic1, pic2, pic3, pic4;
    private MyListView myListView;
    private Database database;
    private ShoperAdapter shoperAdapter;
    private List<Shoper> shoperList;
    private String[] key = {"", "", "", ""};

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
        setContentView(R.layout.activity_fruit_shop);

        FruitShopActivity.this.setTitle("空运车厘子");
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        int color = this.getResources().getColor(R.color.textcolor7);
        ColorDrawable drawable = new ColorDrawable(color);
        actionBar.setBackgroundDrawable(drawable);

        this.getWindow().setStatusBarColor(getResources().getColor(R.color.textcolor7));

        layout1 = findViewById(R.id.layout1);
        layout2 = findViewById(R.id.layout2);
        layout3 = findViewById(R.id.layout3);
        layout4 = findViewById(R.id.layout4);
        layout5 = findViewById(R.id.layout5);
        layout6 = findViewById(R.id.layout6);
        tv_intoShop = findViewById(R.id.tv_intoShop);
        tv_intoShop2 = findViewById(R.id.tv_intoShop2);
        layout1.setOnClickListener(this);
        layout2.setOnClickListener(this);
        layout3.setOnClickListener(this);
        layout4.setOnClickListener(this);
        layout5.setOnClickListener(this);
        layout6.setOnClickListener(this);
        tv_intoShop.setOnClickListener(this);
        tv_intoShop2.setOnClickListener(this);
        pic1 = findViewById(R.id.iv_shopIcon1);
        pic2 = findViewById(R.id.tv_shopFruit);
        pic3 = findViewById(R.id.iv_shopIcon2);
        pic4 = findViewById(R.id.tv_shopFruit2);
        setCirclePictures(pic1, R.drawable.shoperpicture23, 20);
        setCirclePictures(pic2, R.drawable.menupicture1, 20);
        setCirclePictures(pic3, R.drawable.shoperpicture22, 20);
        setCirclePictures(pic4, R.drawable.menupicture2, 20);

        myListView = findViewById(R.id.mylistview);
        database = new Database(FruitShopActivity.this, "SHOP.DB", null, 1);
        shoperList = database.select("SHOP", "果", key);
        shoperAdapter = new ShoperAdapter(shoperList, FruitShopActivity.this);
        myListView.setAdapter(shoperAdapter);
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(view.getContext(), ShoperActivity.class);
                intent.putExtra("shopName", shoperList.get(position).getShopName());
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_intoShop:
                Intent intent = new Intent(v.getContext(), ShoperActivity.class);
                intent.putExtra("shopName", "百果园");
                startActivity(intent);
                break;
            case R.id.tv_intoShop2:
                Intent intent0 = new Intent(v.getContext(), ShoperActivity.class);
                intent0.putExtra("shopName", "果小乐");
                startActivity(intent0);
                break;
            case R.id.layout1:
                Intent intent1 = new Intent(v.getContext(), ShoperActivity.class);
                intent1.putExtra("shopName", "果小乐");
                startActivity(intent1);
                break;
            case R.id.layout2:
                Intent intent2 = new Intent(v.getContext(), ShoperActivity.class);
                intent2.putExtra("shopName", "切切吧水果");
                startActivity(intent2);
                break;
            case R.id.layout3:
                Intent intent3 = new Intent(v.getContext(), ShoperActivity.class);
                intent3.putExtra("shopName", "百果园");
                startActivity(intent3);
                break;
            case R.id.layout4:
                Intent intent4 = new Intent(v.getContext(), ShoperActivity.class);
                intent4.putExtra("shopName", "切切吧水果");
                startActivity(intent4);
                break;
            case R.id.layout5:
                Intent intent5 = new Intent(v.getContext(), ShoperActivity.class);
                intent5.putExtra("shopName", "果乐慧水果店");
                startActivity(intent5);
                break;
            case R.id.layout6:
                Intent intent6 = new Intent(v.getContext(), ShoperActivity.class);
                intent6.putExtra("shopName", "每日优鲜");
                startActivity(intent6);
                break;

        }
    }

    //设置圆角图片
    public void setCirclePictures(ImageView iv, int id, int size) {
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(), BitmapFactory.decodeResource(getResources(), id));
        roundedBitmapDrawable.setCornerRadius(size);
        iv.setImageDrawable(roundedBitmapDrawable);
    }
}
