package com.paxi2020.postpost;


import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class UserCheckRequest extends StringRequest {
    //서버 url 설정(php파일과 연동)
    final static private String URL= "http://fvwlharu@dothome.co.kr/UserCheck.php";
    Map<String, String> map;

    public UserCheckRequest(String id, Response.Listener<String>listener){
        super(Request.Method.POST,URL,listener,null);

        map= new HashMap<>();
        map.put("id",id);

    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
