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


        RetrofitService retrofitService= RetrofitHelper.getInstance().create(RetrofitService.class);
        RegisterItem registerItem= new RegisterItem("userId","userPassword","userName","userEmail");
        Call<RegisterItem> call = retrofitService.postRegister(registerItem);
        call.enqueue(new Callback<RegisterItem>() {
            @Override
            public void onResponse(Call<RegisterItem> call, Response<RegisterItem> response) {
                if(response.isSuccessful()){
                    RegisterItem item= response.body();

                    Toast.makeText(RegisterActivity.this, "회원가입 성공", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<RegisterItem> call, Throwable t) {

            }
        });
    }
}