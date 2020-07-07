package com.paxi2020.postpost;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    EditText etId, etPw;
    String sid, spw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etId=findViewById(R.id.et);
        etPw=findViewById(R.id.et2);

    }

    public void clickJoin(View view) {

        sid=etId.getText().toString();
        spw=etPw.getText().toString();


    }
}
