package com.example.ayh.ui.home;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.ayh.R;

import java.util.List;

public class FreeSendActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout linearLayout1, linearLayout2;
    private LinearLayout layout1, layout2, layout3, layout4, layout5, layout6;
    private MyListView myListView;
    private Database database;
    private ShoperAdapter shoperAdapter;
    private List<Shoper> shoperList;
    private String[] key = {"", "", "", "1"};

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
        setContentView(R.layout.activity_free_send);

        FreeSendActivity.this.setTitle("配送减免");
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        int color = this.getResources().getColor(R.color.buttoncolor4);
        ColorDrawable drawable = new ColorDrawable(color);
        actionBar.setBackgroundDrawable(drawable);

        this.getWindow().setStatusBarColor(getResources().getColor(R.color.buttoncolor4));


        linearLayout1 = findViewById(R.id.linearlaout1);
        linearLayout2 = findViewById(R.id.linearlaout2);
        layout1 = findViewById(R.id.layout1);
        layout2 = findViewById(R.id.layout2);
        layout3 = findViewById(R.id.layout3);
        layout4 = findViewById(R.id.layout4);
        layout5 = findViewById(R.id.layout5);
        layout6 = findViewById(R.id.layout6);
        layout1.setOnClickListener(this);
        layout2.setOnClickListener(this);
        layout3.setOnClickListener(this);
        layout4.setOnClickListener(this);
        layout5.setOnClickListener(this);
        layout6.setOnClickListener(this);
        linearLayout1.setOnClickListener(this);
        linearLayout2.setOnClickListener(this);
        linearLayout1.setBackgroundColor(ContextCompat.getColor(FreeSendActivity.this, R.color.textcolor1));
        myListView = findViewById(R.id.mylistview);
        database = new Database(FreeSendActivity.this, "SHOP.DB", null, 1);
        shoperList = database.select("SHOP", "", key);
        shoperAdapter = new ShoperAdapter(shoperList, FreeSendActivity.this);
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
            case R.id.layout1:
                Intent intent1 = new Intent(v.getContext(), ShoperActivity.class);
                intent1.putExtra("shopName", "巴哩巴哩");
                startActivity(intent1);
                break;
            case R.id.layout2:
                Intent intent2 = new Intent(v.getContext(), ShoperActivity.class);
                intent2.putExtra("shopName", "迪力堡现烤汉堡");
                startActivity(intent2);
                break;
            case R.id.layout3:
                Intent intent3 = new Intent(v.getContext(), ShoperActivity.class);
                intent3.putExtra("shopName", "霏霏煎饼粥铺");
                startActivity(intent3);
                break;
            case R.id.layout4:
                Intent intent4 = new Intent(v.getContext(), ShoperActivity.class);
                intent4.putExtra("shopName", "慕玛披萨");
                startActivity(intent4);
                break;
            case R.id.layout5:
                Intent intent5 = new Intent(v.getContext(), ShoperActivity.class);
                intent5.putExtra("shopName", "韩国哈尼炸鸡");
                startActivity(intent5);
                break;
            case R.id.layout6:
                Intent intent6 = new Intent(v.getContext(), ShoperActivity.class);
                intent6.putExtra("shopName", "果小乐");
                startActivity(intent6);
                break;
            case R.id.linearlaout1:
                key[2] = "";
                key[3] = "1";
                shoperList = database.select("SHOP", "", key);
                shoperAdapter = new ShoperAdapter(shoperList, FreeSendActivity.this);
                myListView.setAdapter(shoperAdapter);
                shoperAdapter.notifyDataSetChanged();
                linearLayout1.setBackgroundColor(ContextCompat.getColor(FreeSendActivity.this, R.color.textcolor1));
                linearLayout2.setBackgroundColor(ContextCompat.getColor(FreeSendActivity.this, R.color.textcolor8));
                break;
            case R.id.linearlaout2:
                key[2] = "1";
                key[3] = "";
                shoperList = database.select("SHOP", "", key);
                shoperAdapter = new ShoperAdapter(shoperList, FreeSendActivity.this);
                myListView.setAdapter(shoperAdapter);
                shoperAdapter.notifyDataSetChanged();
                linearLayout2.setBackgroundColor(ContextCompat.getColor(FreeSendActivity.this, R.color.textcolor1));
                linearLayout1.setBackgroundColor(ContextCompat.getColor(FreeSendActivity.this, R.color.textcolor8));
                break;

        }
    }
}
