package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;

public class MainPageActivity extends AppCompatActivity {

    FrameLayout flMenu, flPicture, flText;
    ImageButton imgbtnHead;
    ImageButton imgbtnMenu;
    Integer count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);

        imgbtnHead = findViewById(R.id.imgbtn_head);
        imgbtnMenu = findViewById(R.id.imgbtn_menu);
        flMenu = (FrameLayout) findViewById(R.id.FL_Menu) ;
        flPicture = (FrameLayout) findViewById(R.id.FL_Picture);
        flText = (FrameLayout) findViewById(R.id.FL_Text);

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

/*    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuBar:
                Toast.makeText(getApplicationContext(), "Search Action", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }*/

}