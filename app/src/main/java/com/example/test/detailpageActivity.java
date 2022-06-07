package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class detailpageActivity extends AppCompatActivity {

    ImageButton imgbtnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailpage);

        imgbtnBack = findViewById(R.id.imgbtn_Back);

        imgbtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(detailpageActivity.this, MainPageActivity.class);
                startActivity(intent);
            }
        });
    }
}