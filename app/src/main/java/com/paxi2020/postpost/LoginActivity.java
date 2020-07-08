package com.paxi2020.postpost;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    EditText et_id, et_pw;
    Button btn_lg, btn_regi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_id=findViewById(R.id.et_id);
        et_pw=findViewById(R.id.et_password);

        btn_lg=findViewById(R.id.btn_login);
        btn_regi=findViewById(R.id.btn_register);


        btn_regi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }


    public void clickLogin(View view) {
        String id= et_id.getText().toString();
        String password= et_pw.getText().toString();

        Response.Listener<String> responseListener= new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                JSONObject jsonObject= new JSONObject();
                try {
                    boolean success= jsonObject.getBoolean("success");
                    if (success) {
                        String id= jsonObject.getString("id");
                        String password= jsonObject.getString("password");

                        Toast.makeText(LoginActivity.this, "로그인 성공", Toast.LENGTH_SHORT).show();

                        Intent intent= new Intent(LoginActivity.this,MainActivity.class);
                        //값을 가지고 간다
                        intent.putExtra("log","login");
                        intent.putExtra("id","id");
                        startActivity(intent);

                    }else {
                        Toast.makeText(LoginActivity.this, "로그인 실패 다시 시도 해주세요", Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        };

        LoginRequest loginRequest= new LoginRequest(id,password,responseListener);
        RequestQueue queue= Volley.newRequestQueue(LoginActivity.this);
        queue.add(loginRequest);

    }
}
