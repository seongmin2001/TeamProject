package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class agesInfoActivity extends AppCompatActivity {

    ImageButton imgbtnDown;

    Button btnTen, btnTwenty, btnThirty, btnForty;
    boolean i = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ages_info);

        imgbtnDown = findViewById(R.id.imgbtn_down);
        btnTen = findViewById(R.id.btn_ten);
        btnTwenty = findViewById(R.id.btn_twenty);
        btnThirty = findViewById(R.id.btn_thirty);
        btnForty = findViewById(R.id.btn_forty);

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

    }
}