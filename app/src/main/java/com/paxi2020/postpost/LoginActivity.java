package com.paxi2020.postpost;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    EditText id, pw;
    Button btn_lg, btn_regi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        id=findViewById(R.id.et_id);
        pw=findViewById(R.id.et_password);

        btn_lg=findViewById(R.id.btn_login);
        btn_regi=findViewById(R.id.btn_register);

    }


    public void clickLogin(View view) {
        String et_id= id.getText().toString();
        String password= pw.getText().toString();

        Intent intent=new Intent(LoginActivity.this,MainActivity.class);
        startActivity(intent);



    }

    public void clickRegister(View view) {
        Intent intent= new Intent(LoginActivity.this,RegisterActivity.class);
        startActivity(intent);
    }
}
