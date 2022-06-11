package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class detailpageActivity extends AppCompatActivity {

    ImageButton imgbtnBack;
    ImageButton imgbtnDetail_Head, imgbtnDetail_Eyes, imgbtnDetail_LeftEar, imgbtnDetail_RightEar, imgbtnDetail_Nose, imgbtnDetail_Mouth;
    TextView tvDetail;

    public static Context context; //다른 액티비티에 변수 전달
    public static String body_num; //부위별 검색 코드

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailpage);

        context=this;

        tvDetail = findViewById(R.id.Detail_Result);

        imgbtnBack = findViewById(R.id.imgbtn_Back);
        imgbtnDetail_Head = findViewById(R.id.btDetail_Head);
        imgbtnDetail_Eyes = findViewById(R.id.btDetail_Eyes);
        imgbtnDetail_LeftEar = findViewById(R.id.btDetail_LeftEar);
        imgbtnDetail_RightEar = findViewById(R.id.btDetail_RightEar);
        imgbtnDetail_Nose = findViewById(R.id.btDetail_Nose);
        imgbtnDetail_Mouth = findViewById(R.id.btDetail_Mouth);

        imgbtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(detailpageActivity.this, MainPageActivity.class);
                startActivity(intent);
            }
        });
        imgbtnDetail_Head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvDetail.setText("정신건강의학과");
                body_num = "03";//해당하는 부위의 검색코드
            }
        });
        imgbtnDetail_Eyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvDetail.setText("안과");
                body_num = "12";//해당하는 부위의 검색코드
            }
        });
        imgbtnDetail_LeftEar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvDetail.setText("이비인후과");
                body_num = "13";//해당하는 부위의 검색코드
            }
        });
        imgbtnDetail_RightEar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvDetail.setText("이비인후과");
                body_num = "13";//해당하는 부위의 검색코드
            }
        });
        imgbtnDetail_Nose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvDetail.setText("이비인후과");
                body_num = "13";//해당하는 부위의 검색코드
            }
        });
        imgbtnDetail_Mouth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvDetail.setText("통합치의학과");
                body_num = "61";//해당하는 부위의 검색코드
            }
        });
    }
}