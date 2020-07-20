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


    }
}