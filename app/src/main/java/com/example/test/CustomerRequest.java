package com.example.test;



import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class CustomerRequest extends StringRequest {

    //서버 URL 설정(PHP 파일 연동)
    final static private String URL = "http://yaree0927.dothome.co.kr/HosRegister2.php";
    private Map<String, String> map;

    public CustomerRequest(String CusName, String CusBirth, String CusNum, String CusGen, Response.Listener<String>listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("CusName",CusName);
        map.put("CusBirth",CusBirth);
        map.put("CusNum",CusNum);
        map.put("CusGen", CusGen);
    }

    @Nullable
    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}