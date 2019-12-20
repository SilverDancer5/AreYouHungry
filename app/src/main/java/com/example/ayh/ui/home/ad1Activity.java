package com.example.ayh.ui.home;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;

import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ayh.R;

import java.util.Random;

public class ad1Activity extends AppCompatActivity implements View.OnClickListener {
    ImageView imageView2, iv_left, iv_right, iv_center;
    int flag1 = 1, flag2 = 1, flag3 = 1, changes = 3;
    TextView textView, textView2;

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
        setContentView(R.layout.activity_ad1);

        ad1Activity.this.setTitle("双12狂欢");
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        int color = this.getResources().getColor(R.color.buttoncolor5);
        ColorDrawable drawable = new ColorDrawable(color);
        actionBar.setBackgroundDrawable(drawable);

        this.getWindow().setStatusBarColor(getResources().getColor(R.color.buttoncolor5));

        imageView2 = findViewById(R.id.iv_pic1);
        iv_left = findViewById(R.id.iv_left);
        iv_right = findViewById(R.id.iv_right);
        iv_center = findViewById(R.id.iv_center);
        textView = findViewById(R.id.tv_text);
        textView2 = findViewById(R.id.tv_chance);
        imageView2.setOnClickListener(this);
        textView.setOnClickListener(this);
        textView2.setOnClickListener(this);
        iv_left.setOnClickListener(this);
        iv_right.setOnClickListener(this);
        iv_center.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_text:
                Intent intent1 = new Intent();
                intent1.setAction(Intent.ACTION_VIEW);
                Uri data = Uri.parse("https://h5.ele.me/supervip/?acm=lb-zebra-588001-7615349.1003.4.7028356&scm=1003.4.lb-zebra-588001-7615349.OTHER_15711927021641_7028356&svip_purchase=supervipday1201&spm=a2ogi.13750856.click-share.1#/purchase/?svip_purchase=supervipday1201&type=qq");
                intent1.setData(data);
                startActivity(intent1);
                break;
            case R.id.iv_left:
                flag1 = changeCheers(iv_left, flag1);
                break;
            case R.id.iv_center:
                flag2 = changeCheers(iv_center, flag2);
                break;
            case R.id.iv_right:
                flag3 = changeCheers(iv_right, flag3);
                break;
        }
    }

    public int changeCheers(ImageView iv, int flag) {
        Random random = new Random();
        int i = random.nextInt(100);
        if (changes > 0) {
            if (flag == 1) {
                if (i > 75) {
                    iv.setImageDrawable(getResources().getDrawable(R.drawable.picture21));
                } else {
                    iv.setImageDrawable(getResources().getDrawable(R.drawable.picture22));
                }
                changes--;
            } else {
                Toast.makeText(ad1Activity.this, "本卡片已经翻阅过了！", Toast.LENGTH_SHORT).show();
            }
            textView2.setText("本次还有" + changes + "次翻牌机会");
        } else {
            Toast.makeText(ad1Activity.this, "本次翻牌机会已用完，请下次再来！", Toast.LENGTH_SHORT).show();
        }
        return 0;
    }
}