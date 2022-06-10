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
    ImageButton imgbtnHead;
    ImageButton imgbtnMenu, imgbtnArm , imgbtnAid, imgbtnLogin;
    Integer count = 0;

    public static Context context; //다른 액티비티에 변수 전달
    public static String body_num; //부위별 검색 코드
    TextView body_tv; //버튼클릭시 적용되는 부위 확인용으로 나중에 지워도됨

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);

        context=this;

        imgbtnLogin = findViewById(R.id.imgBtn_login);
        imgbtnArm = findViewById(R.id.btArm);
        imgbtnHead = findViewById(R.id.btHead);
        imgbtnMenu = findViewById(R.id.imgbtn_menu);
        imgbtnAid = findViewById(R.id.imgBtn_aid);
        flMenu = (FrameLayout) findViewById(R.id.FL_Menu) ;
        flPicture = (FrameLayout) findViewById(R.id.FL_Picture);
        flText = (FrameLayout) findViewById(R.id.FL_Text);

        body_tv = (TextView) findViewById(R.id.bodyTv);

        imgbtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainPageActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

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
                body_tv.setText("내과");
                body_num = "01";//해당하는 부위의 검색코드
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
