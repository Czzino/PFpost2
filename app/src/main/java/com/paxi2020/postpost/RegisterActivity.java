package com.paxi2020.postpost;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class RegisterActivity extends AppCompatActivity {

    EditText et_id, et_pw, et_name, et_email;
    Button btn_regi;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        et_id=findViewById(R.id.et_id);
        et_pw =findViewById(R.id.et_password);
        et_name=findViewById(R.id.et_name);
        et_email=findViewById(R.id.et_email);

        btn_regi= findViewById(R.id.btn_register);

    }

    public void clickRegister(View view) {
        String id= et_id.getText().toString();
        String pass= et_pw.getText().toString();
        String name= et_name.getText().toString();
        String email= et_email.getText().toString();

        Retrofit retrofit = RegisterHelper.getInstance();
        RegisterService registerService= retrofit.create(RegisterService.class);

        Map<String,String> datapart= new HashMap<>();
        datapart.put("userId",id);
        datapart.put("userPassword", pass);
        datapart.put("userName",name);
        datapart.put("userEmail", email);

        Call<String> call= registerService.postRegister(datapart);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()){
                    String s= response.body();
                    Toast.makeText(RegisterActivity.this, "저장되었습니다", Toast.LENGTH_SHORT).show();

                    Intent intent= new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);

                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });

    }
}