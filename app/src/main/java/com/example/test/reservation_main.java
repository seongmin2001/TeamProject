package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;


public class reservation_main extends AppCompatActivity {

    private TextView autoCompleteTextView;
    private DatePickerDialog.OnDateSetListener callbackMethod;
    private Context mContext;
    private Button parcingBtn, btnMain;
    private EditText name;
    private EditText phonecall;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_main);

        btnMain = findViewById(R.id.btn_Main);
        name =(EditText)findViewById(R.id.editText);
        phonecall=(EditText)findViewById(R.id.editText2);
        mContext = this;
        parcingBtn = (Button) findViewById(R.id.btn_Parching);
        boolean boo = com.example.test.PreferenceManager.getBoolean(mContext,"check");
        if (boo){
            name.setText(PreferenceManager.getString(mContext,"nm"));
            phonecall.setText(PreferenceManager.getString(mContext,"pc"));

        }

        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(reservation_main.this, MainPageActivity.class);
                startActivity(intent);
            }
        });


        parcingBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(reservation_main.this , reservation_complete_infomation.class);
                PreferenceManager.setString(mContext,"nm",name.getText().toString().trim());  //nm=name으로 저장
                PreferenceManager.setString(mContext,"pc",phonecall.getText().toString().trim()); // pc = phonecall로 저장

                String checkNM = PreferenceManager.getString(mContext,"id");
                String checkPC = PreferenceManager.getString(mContext,"pc");
                if (TextUtils.isEmpty(checkNM) ||  TextUtils.isEmpty(checkPC)){
                    Toast.makeText(reservation_main.this,"성함/전화번호를 확인해주세요",Toast.LENGTH_SHORT);
                } else {
                    intent.putExtra("nm",checkNM);
                    intent.putExtra("ph",checkPC);
                    Toast.makeText(reservation_main.this , "저장완료",Toast.LENGTH_SHORT);
                }
                startActivity(intent);
            }
        });

        this.IntializeView();
        this.IntializeListener();
        final RadioGroup rg = (RadioGroup)findViewById(R.id.radioGroup);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkid) {
                RadioButton id = (RadioButton)findViewById(checkid);

                if(checkid == R.id.radioButton)
                {
                    Toast.makeText(reservation_main.this, "남성입니다",Toast.LENGTH_SHORT).show();
                }

                if(checkid == R.id.radioButton2)
                {
                    Toast.makeText(reservation_main.this, "여성입니다",Toast.LENGTH_SHORT).show();
                }
                else
                {

                }
            }
        });

    }

    public void IntializeView(){

        autoCompleteTextView    =   (TextView)findViewById(R.id.autoCompleteTextView);
    }
    public void IntializeListener(){
        callbackMethod  =   new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                autoCompleteTextView.setText(year+"년"+month+"월"+day+"일");

            }
        };

    }
    public void OnClickHandler(View view)
    {
        DatePickerDialog dialog = new DatePickerDialog(this, callbackMethod, 2020, 5, 24);

        dialog.show();
    }
}