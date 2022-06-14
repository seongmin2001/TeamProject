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

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


public class reservation_main extends AppCompatActivity {

    private TextView autoCompleteTextView;
    private DatePickerDialog.OnDateSetListener callbackMethod;
    private Context mContext;
    private Button parcingBtn, btnMain;
    private EditText name;
    private EditText phonecall;
    RadioButton id;
    String t2, pp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_main);

        btnMain = findViewById(R.id.btn_Main);
        name =(EditText)findViewById(R.id.editText);
        phonecall=(EditText)findViewById(R.id.editText2);
        mContext = this;
        parcingBtn = (Button) findViewById(R.id.btn_Parching);
//        boolean boo = com.example.test.PreferenceManager.getBoolean(mContext,"check");
//        if (boo){
//            name.setText(PreferenceManager.getString(mContext,"nm"));
//            phonecall.setText(PreferenceManager.getString(mContext,"pc"));
//
//        }

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

                String CusName = name.getText().toString();
                String CusNum = phonecall.getText().toString();
                String CusGen = pp;
                String CusBirth = t2;
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if (success) { // 회원등록에 성공한 경우
                                Toast.makeText(getApplicationContext(), "회원등록 성공", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(reservation_main.this, reservation_complete_infomation.class);
                                startActivity(intent);
                            } else { // 회원등록에 실패한 경우
                                Toast.makeText(getApplicationContext(), "회원등록 실패", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                // 서버로 Volley를 이용해 요청
                CustomerRequest customerRequest = new CustomerRequest(CusName, CusNum, CusGen, CusBirth, responseListener);
                RequestQueue queue = Volley.newRequestQueue(reservation_main.this);
                queue.add(customerRequest);
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
                    pp = id.getText().toString();
                }

                if(checkid == R.id.radioButton2)
                {
                    Toast.makeText(reservation_main.this, "여성입니다",Toast.LENGTH_SHORT).show();
                    pp = id.getText().toString();
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

                if(month < 9 && day < 10){
                    autoCompleteTextView.setText(year+""+0+(month+1)+""+0+day+"");
                }
                else if(month < 9 && day > 9){
                    autoCompleteTextView.setText(year+""+0+(month+1)+""+day+"");
                }
                else if(month > 9 && day < 10){
                    autoCompleteTextView.setText(year+""+(month+1)+""+0+day+"");
                }
                else if(month > 9 && day > 9){
                    autoCompleteTextView.setText(year+""+(month+1)+""+day+"");
                }
                else if(month == 9 && day > 9){
                    autoCompleteTextView.setText(year+""+(month+1)+""+day+"");
                }
                else if(month == 9 && day < 10){
                    autoCompleteTextView.setText(year+""+(month+1)+""+0+day+"");
                }
                t2 = autoCompleteTextView.getText().toString();
                Toast.makeText(reservation_main.this, t2,Toast.LENGTH_SHORT).show();

            }
        };

    }
    public void OnClickHandler(View view)
    {
        DatePickerDialog dialog = new DatePickerDialog(this, callbackMethod, 2020, 5, 24);

        dialog.show();
    }
}