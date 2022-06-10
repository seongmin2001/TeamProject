
/*
package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    private EditText et_name, et_num, et_aname, et_anum;
    private Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_only_signing);

        //아이디 값 찾기
        et_name = findViewById(R.id.et_name);
        et_num = findViewById(R.id.et_num);
        et_aname = findViewById(R.id.et_aname);
        et_anum = findViewById(R.id.et_anum);

        //회원가입 버튼 클릭시 수행
        btn_register = findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // EditText에 입력되어있는것을 가져온다.
                String HosName = et_name.getText().toString();
                String HosaName = et_aname.getText().toString();
                String HosaNum = et_anum.getText().toString();
                int HosNum = Integer.parseInt(et_num.getText().toString());

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if (success) { // 회원등록에 성공한 경우
                                Toast.makeText(getApplicationContext(), "회원등록 성공", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(RegisterActivity.this, doctor_only_signing_complete.class);
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
                RegisterRequest registerRequest = new RegisterRequest(HosName, HosaName, HosaNum, HosNum, responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerRequest);

            }
        });

    }
}*/
