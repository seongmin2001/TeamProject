package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class agesInfoActivity extends AppCompatActivity {

    ImageButton imgbtnDown, imgbtnBack;

    Button btnTen, btnTwenty, btnThirty, btnForty;
    TextView tvTop, tvTop2, tvSub1, tvSub2, tvSub3, tvSub4;
    boolean i = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ages_info);

        imgbtnBack = findViewById(R.id.imgbtn_Back);
        imgbtnDown = findViewById(R.id.imgbtn_down);
        btnTen = findViewById(R.id.btn_ten);
        btnTwenty = findViewById(R.id.btn_twenty);
        btnThirty = findViewById(R.id.btn_thirty);
        btnForty = findViewById(R.id.btn_forty);
        tvSub1 = findViewById(R.id.tv_sub1);
        tvSub2 = findViewById(R.id.tv_sub2);
        tvSub3 = findViewById(R.id.tv_sub3);
        tvSub4 = findViewById(R.id.tv_sub4);

        imgbtnDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(i == true){
                    imgbtnDown.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_24);
                    btnTen.setVisibility(View.VISIBLE);
                    btnTwenty.setVisibility(View.VISIBLE);
                    btnThirty.setVisibility(View.VISIBLE);
                    btnForty.setVisibility(View.VISIBLE);
                    i = false;
                }
                else if(i == false){
                    imgbtnDown.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24);
                    btnTen.setVisibility(View.INVISIBLE);
                    btnTwenty.setVisibility(View.INVISIBLE);
                    btnThirty.setVisibility(View.INVISIBLE);
                    btnForty.setVisibility(View.INVISIBLE);
                    i = true;
                }
            }
        });

        imgbtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(agesInfoActivity.this, MainPageActivity.class);
                startActivity(intent);
            }
        });

        btnTwenty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvSub1.setText("위장염");
                tvSub2.setText("www.daum.net");
                tvSub3.setText("비타민B");
                tvSub4.setText("www.daum.net");
            }
        });
        btnTen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvSub1.setText("감기");
                tvSub2.setText("www.naver.com");
                tvSub3.setText("프로바이오틱스");
                tvSub4.setText("www.naver.com");
            }
        });
    }
}