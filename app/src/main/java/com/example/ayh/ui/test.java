package com.example.ayh.ui;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ayh.R;

public class test extends AppCompatActivity {
    TextView test1;
    TextView test2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        test1 = findViewById(R.id.test_one);
        test2 = findViewById(R.id.test_two);


    }
}
