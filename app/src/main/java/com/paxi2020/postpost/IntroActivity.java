package com.paxi2020.postpost;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class IntroActivity extends AppCompatActivity {

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        imageView=findViewById(R.id.iv);

        String imgUrl= "https://previews.123rf.com/images/maxxyustas/maxxyustas1506/maxxyustas150600018/41626314-stack-of-cardboard-delivery-boxes-or-parcels-warehouse-concept-background-3d.jpg";
        Glide.with(this).load(imgUrl).into(imageView);

        Handler handler= new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent= new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);

    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
