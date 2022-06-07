package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MainPageActivity extends AppCompatActivity {

    FrameLayout flMenu, flPicture, flText;
    ImageButton imgbtnHead;
    ImageButton imgbtnMenu, imgbtnAid;
    Integer count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);

        imgbtnHead = findViewById(R.id.imgbtn_head);
        imgbtnMenu = findViewById(R.id.imgbtn_menu);
        imgbtnAid = findViewById(R.id.imgBtn_aid);
        flMenu = (FrameLayout) findViewById(R.id.FL_Menu) ;
        flPicture = (FrameLayout) findViewById(R.id.FL_Picture);
        flText = (FrameLayout) findViewById(R.id.FL_Text);

        imgbtnAid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainPageActivity.this,firstaidActivity.class);
                startActivity(intent);
            }
        });

        imgbtnHead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainPageActivity.this,detailpageActivity.class);
                startActivity(intent);
            }
        });

        imgbtnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count == 0){
                    flMenu.setVisibility(View.VISIBLE);
                    flPicture.setVisibility(View.VISIBLE);
                    flText.setVisibility(View.VISIBLE);
                    count = 1;
                }
                else if(count == 1){
                    flMenu.setVisibility(View.INVISIBLE);
                    flPicture.setVisibility(View.VISIBLE);
                    flText.setVisibility(View.VISIBLE);
                    count = 0;
                }
            }
        });
    }
}