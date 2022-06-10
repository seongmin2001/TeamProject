package com.example.test;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {

    //서버 URL 설정(PHP 파일 연동)
    final static private String URL = "http://yaree0927.dothome.co.kr/HosRegister.php";
    private Map<String, String> map;

    public RegisterRequest(String HosName, String HosaName, String HosaNum, int HosNum, Response.Listener<String>listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("HosName",HosName);
        map.put("HosaName",HosaName);
        map.put("HosaNum",HosaNum);
        map.put("HosNum", HosNum +"");
    }

    @Nullable
    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
