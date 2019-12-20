package com.example.ayh.ui.notifications;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ayh.R;
import com.example.ayh.ui.MainActivity;

public class Card extends AppCompatActivity {
    Button btn_to;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        /**
         * 顶部栏
         */
        //顶部栏名称
        Card.this.setTitle("办卡有礼");
        //顶部返回键
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        int color = this.getResources().getColor(R.color.blue);
        ColorDrawable drawable = new ColorDrawable(color);
        actionBar.setBackgroundDrawable(drawable);

        //状态栏
        this.getWindow().setStatusBarColor(getResources().getColor(R.color.blue));



        btn_to = findViewById(R.id.btn_to);
        btn_to.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Card.this, MainActivity.class);
                startActivity(intent);
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