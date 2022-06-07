package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class firstaidActivity extends AppCompatActivity {

    FrameLayout flParent, flChild, flParent2, flChild2, flParent3, flChild3;
    ImageButton imgbtnDown,imgbtnDown2,imgbtnDown3,imgbtnBack;
    TextView tvlink, tvComment;
    ImageView imgVRound;
    boolean i = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstaid);

        imgbtnDown = findViewById(R.id.imgbtn_down);
        imgbtnDown2 = findViewById(R.id.imgbtn_down2);
        imgbtnDown3 = findViewById(R.id.imgbtn_down3);
        imgbtnBack = findViewById(R.id.imgbtn_Back);
        tvlink = findViewById(R.id.tv_link);
        tvComment = findViewById(R.id.tv_comment);
        imgVRound = findViewById(R.id.imgV_round);
        flParent = (FrameLayout)findViewById(R.id.FL_Parent);
        flChild = (FrameLayout)findViewById(R.id.FL_child);
        flParent2 = (FrameLayout)findViewById(R.id.FL_Parent2);
        flChild2 = (FrameLayout)findViewById(R.id.FL_child2);
        flParent3 = (FrameLayout)findViewById(R.id.FL_Parent3);
        flChild3 = (FrameLayout)findViewById(R.id.FL_child3);

        imgbtnDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (i == true){
                    imgbtnDown.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_24);
                    flChild.setVisibility(View.VISIBLE);
                    i = false;
                }else {
                    imgbtnDown.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24);
                    flChild.setVisibility(View.GONE);
                    i = true;
                }
            }
        });

        imgbtnDown2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (i == true){
                    imgbtnDown2.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_24);
                    flChild2.setVisibility(View.VISIBLE);
                    i = false;
                }else {
                    imgbtnDown2.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24);
                    flChild2.setVisibility(View.GONE);
                    i = true;
                }
            }
        });

        imgbtnDown3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (i == true){
                    imgbtnDown3.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_24);
                    flChild3.setVisibility(View.VISIBLE);
                    i = false;
                }else {
                    imgbtnDown3.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24);
                    flChild3.setVisibility(View.GONE);
                    i = true;
                }
            }
        });



        imgbtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(firstaidActivity.this, MainPageActivity.class);
                startActivity(intent);
            }
        });


    }
}