package com.example.ayh.ui.notifications;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ayh.R;
import com.example.ayh.ui.MainActivity;
import com.example.ayh.ui.home.Database;
import com.example.ayh.ui.home.Shoper;
import com.example.ayh.ui.home.ShoperActivity;
import com.example.ayh.ui.home.ShoperAdapter;

import java.util.List;

public class Collection extends AppCompatActivity {

    Button btn_to;
    ListView collection_listview;
    List<Shoper> shoperList;
    ShoperAdapter shoperAdapter;
    ImageView collection_img;
    TextView collection_txt;
    Database database = new Database(Collection.this,"SHOP.DB", null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);
        /**
         * 顶部栏
         */
        //顶部栏名称
        Collection.this.setTitle("我的收藏");
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



        btn_to = findViewById(R.id.btn_to);
        btn_to.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Collection.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        collection_listview = findViewById(R.id.collection_listview);
        collection_img = findViewById(R.id.collection_img);
        collection_txt = findViewById(R.id.collection_txt);
        shoperList = database.selectByIfCollected(1);
        if(shoperList.size() == 0){
            collection_img.setVisibility(View.VISIBLE);
            collection_txt.setVisibility(View.VISIBLE);
            btn_to.setVisibility(View.VISIBLE);
        }

        shoperAdapter = new ShoperAdapter(shoperList,Collection.this);
        collection_listview.setAdapter(shoperAdapter);
        collection_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Collection.this, ShoperActivity.class);
                intent.putExtra("shopName",shoperList.get(position).getShopName());
                startActivityForResult(intent,111);
                finish();
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

}
