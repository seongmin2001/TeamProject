
/*
package com.example.test;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class body extends AppCompatActivity {

    public static Context context; //다른 액티비티에 변수 전달
    public static String body_num; //부위별 검색 코드
    TextView body_tv; //버튼클릭시 적용되는 부위 확인용으로 나중에 지워도됨

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);

        context=this; //다른 액티비티 변수 전달시 필요코드

        //body_tv = (TextView) findViewById(R.id.bodyTv); //bodyTv의 변수

        //머리 버튼 클릭
        ImageButton bt_head =  findViewById(R.id.btHead);
        bt_head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                body_tv.setText("머리>이비인후과");
                body_num = "13";//해당하는 부위의 검색코드
            }
        });

        //팔 버튼 클릭
        ImageButton bt_arm =  findViewById(R.id.btArm);
        bt_arm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                body_tv.setText("내과");
                body_num = "01";//해당하는 부위의 검색코드
            }
        });

        //검색버튼으로 클릭시 메인액티비티로 전환
        Button bt_search = (Button) findViewById(R.id.btSearch);
        bt_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainPageActivity.class);
                startActivity(intent);
            }
        });

    }
}*/
