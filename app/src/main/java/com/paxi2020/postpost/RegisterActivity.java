package com.paxi2020.postpost;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RegisterActivity extends AppCompatActivity {

    EditText et_userid, et_pw, et_name, et_email;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        et_userid = findViewById(R.id.et_id);
        et_pw = findViewById(R.id.et_password);
        et_name = findViewById(R.id.et_name);
        et_email=findViewById(R.id.et_email);



    }


    public void clickRegister(View view) {

        //서버에 전송할 회원정보 데이터들
        String id= et_userid.getText().toString();
        String password= et_pw.getText().toString();
        String name= et_name.getText().toString();
        String eamil= et_email.getText().toString();

        //레트로핏 라이브러리로 라이브러리 전송
        Retrofit retrofit= LoginHelper.getInstance2(); //2는 scalrs
        RetrofitService retrofitService= retrofit.create(RetrofitService.class);

        //데이터들
        Map<String, String> datapart = new HashMap<>();
        datapart.put("id", id);
        datapart.put("password,", password);
        datapart.put("name", name);
        datapart.put("eamil", eamil);

        Call<String> call= retrofitService.postDataToBoard(datapart);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()){
                    String s= response.body();
                    Toast.makeText(RegisterActivity.this, ""+s, Toast.LENGTH_SHORT).show();

                    finish();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

        Intent intent= new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}