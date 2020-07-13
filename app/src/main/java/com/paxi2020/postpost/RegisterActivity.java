package com.paxi2020.postpost;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

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
import retrofit2.Retrofit;

public class RegisterActivity extends AppCompatActivity {

    EditText et_userid, et_pw, et_name, et_email;
    Button btn_regi;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        et_userid = findViewById(R.id.et_id);
        et_pw = findViewById(R.id.et_password);
        et_name = findViewById(R.id.et_name);
        et_email = findViewById(R.id.et_email);

        btn_regi = findViewById(R.id.btn_register);
        btn_regi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //서버에 전송할 회원정보 데이터들
                String userID = et_userid.getText().toString();
                String userPassword = et_pw.getText().toString();
                String userName = et_name.getText().toString();
                String userEmail = et_email.getText().toString();

                Response.Listener<String> reponseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if (success) {
                                Toast.makeText(getApplicationContext(), "회원등록성공", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                startActivity(intent);

                            } else {
                                Toast.makeText(getApplicationContext(), "회원등록실패", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };

                Response.ErrorListener errorListener= new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(RegisterActivity.this, "에러 발생", Toast.LENGTH_SHORT).show();
                        return;
                    }
                };
                RegisterRequest registerRequest = new RegisterRequest(userID, userPassword, userName, userEmail, reponseListener);
                registerRequest.setShouldCache(false);
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                queue.add(registerRequest);
            }
        });
    }
}
//    public void clickRegister(View view) {
//
//        //서버에 전송할 회원정보 데이터들
//        String userID= et_userid.getText().toString();
//        String userPassword= et_pw.getText().toString();
//        String userName= et_name.getText().toString();
//        String userEmail= et_email.getText().toString();
//
//        Response.Listener<String> reponseListener = new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                try {
//                    JSONObject jsonObject= new JSONObject(response);
//                    boolean success = jsonObject.getBoolean("success");
//                    if (success) {
//                        Toast.makeText(getApplicationContext(),"회원등록성공",Toast.LENGTH_SHORT).show();
//                        Intent intent= new Intent(RegisterActivity.this, LoginActivity.class);
//                        startActivity(intent);
//
//                    }else {
//                        Toast.makeText(getApplicationContext(),"회원등록실패",Toast.LENGTH_SHORT).show();
//                        return;
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        };

