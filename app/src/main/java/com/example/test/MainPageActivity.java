package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainPageActivity extends AppCompatActivity {

    FrameLayout flMenu, flPicture, flText;
    ImageButton imgbtnHead, imgbtnOther, imgbtnBok, imgbtnGol, imgbtnBody, imgbtnMok, imgbtnArm;
    ImageButton imgbtnMenu, imgbtnAid;
    Integer count = 0;

    public static Context context; //다른 액티비티에 변수 전달
    public static String body_num; //부위별 검색 코드
    TextView body_tv; //버튼클릭시 적용되는 부위 확인용으로 나중에 지워도됨

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);

        context=this;

        imgbtnArm = findViewById(R.id.btArm);
        imgbtnHead = findViewById(R.id.btHead);
        imgbtnOther = findViewById(R.id.btOther);
        imgbtnBok = findViewById(R.id.btBok);
        imgbtnGol = findViewById(R.id.btGol);
        imgbtnBody = findViewById(R.id.btBody);
        imgbtnMok = findViewById(R.id.btMok);


        imgbtnMenu = findViewById(R.id.imgbtn_menu);
        imgbtnAid = findViewById(R.id.imgBtn_aid);
        flMenu = (FrameLayout) findViewById(R.id.FL_Menu) ;
        flPicture = (FrameLayout) findViewById(R.id.FL_Picture);
        flText = (FrameLayout) findViewById(R.id.FL_Text);

        body_tv = (TextView) findViewById(R.id.bodyTv);

        imgbtnAid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainPageActivity.this,firstaidActivity.class);
                startActivity(intent);
            }
        });
        //팔 버튼 클릭
        imgbtnArm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                body_tv.setText("외과");
                body_num = "04";//해당하는 부위의 검색코드
            }
        });
        //기타
        imgbtnOther.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                body_tv.setText("응급의학과");
                body_num = "24";//해당하는 부위의 검색코드
            }
        });
        //복부
        imgbtnBok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                body_tv.setText("내과");
                body_num = "01";//해당하는 부위의 검색코드
            }
        });
        //골반
        imgbtnGol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                body_tv.setText("비뇨의학과");
                body_num = "15";//해당하는 부위의 검색코드
            }
        });
        //전신
        imgbtnBody.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                body_tv.setText("한방내과");
                body_num = "80";//해당하는 부위의 검색코드
            }
        });
        //목
        imgbtnMok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                body_tv.setText("흉부외과");
                body_num = "07";//해당하는 부위의 검색코드
            }
        });
        //머리
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

        //검색버튼으로 클릭시 메인액티비티로 전환
        Button bt_search = (Button) findViewById(R.id.btSearch);
        bt_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ParsingActivity.class);
                startActivity(intent);
            }
        });
    }
}
