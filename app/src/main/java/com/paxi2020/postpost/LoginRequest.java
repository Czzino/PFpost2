package com.paxi2020.postpost;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest extends StringRequest {

    final static String URL="http://fvwlharu@dothome.co.kr/Login.php";

    Map<String, String> map;

    public LoginRequest(String id, String password, Response.Listener<String>listener) {
        super(Method.POST,URL,listener,null);

        map=new HashMap<>();
        map.put("id",id);
        map.put("password",password);

    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
