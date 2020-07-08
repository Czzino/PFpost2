package com.paxi2020.postpost;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class UserJoinRequest extends StringRequest {

    final static private String URL="http://fvwlharu@dothome.co.kr/Join.php";
    Map<String, String> map;

    public UserJoinRequest(String id, String password, String name, int age,Response.Listener<String>listener) {
        super(Method.POST, URL,listener,null);
        //위 URL에 post방식으로 값을 전송

        map= new HashMap<>();
        map.put("id",id);
        map.put("password",password);
        map.put("name",name);
        map.put("age",age+""); //int형 이라 String으로 변환 ""

    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
