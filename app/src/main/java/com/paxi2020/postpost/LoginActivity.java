package com.paxi2020.postpost;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.google.android.material.navigation.NavigationView;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    EditText et_userid, et_pw;
    Button btn_login;
    ImageView iv;

    NavigationView navi;
    DrawerLayout drawerLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_userid = findViewById(R.id.et_id);
        et_pw = findViewById(R.id.et_password);

        iv=findViewById(R.id.iv);
        String imgUrl= "https://w7.pngwing.com/pngs/935/151/png-transparent-man-riding-motor-scooter-delivery-courier-express-by-bike-freight-transport-mode-of-transport-motorcycle-thumbnail.png";
        Glide.with(this).load(imgUrl).into(iv);

//        drawerLayout=findViewById(R.id.dr);

        Toolbar toolbar= (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("로 그 인");
        setSupportActionBar(toolbar);



        btn_login = findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
