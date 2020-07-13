package com.paxi2020.postpost;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


//    BottomNavigationView btnav;
//
//    FragmentManager fragmentManager;
//
//
//    Fragment[] fragments= new Fragment[4];

    private TextView id, pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id= findViewById(R.id.tv_id);
        pw= findViewById(R.id.tv_pw);


        Intent intent= getIntent();
        String userID=  intent.getStringExtra("userID");
        String userPassword= intent.getStringExtra("userPassword");

        id.setText(userID);
        pw.setText(userPassword);
//        fragmentManager= getSupportFragmentManager();
//
//        fragments[0]= new PostFragment1();
//        fragments[1]= new PostFragment2();
//        fragments[2]= new PostFragment3();
//        fragments[3]= new PostFragment4();
//
//        FragmentTransaction tran= fragmentManager.beginTransaction();
//        tran.add(R.id.container, fragments[0]);
//        tran.commit();
//
//        btnav=findViewById(R.id.bottom_nav);
//        btnav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//                //프레그먼트 작업 트랜잭션 시작
//                FragmentTransaction tran = fragmentManager.beginTransaction();
//
//                switch (menuItem.getItemId()) {
//                    case R.id.menu_lookpost:
//                        tran.replace(R.id.container, fragments[0]);
//                        break;
//                    case R.id.menu_shopping:
//                        tran.replace(R.id.container, fragments[1]);
//                        break;
//                    case R.id.menu_searchpost:
//                        tran.replace(R.id.container, fragments[2]);
//                        break;
//                    case R.id.menu_booking:
//                        tran.replace(R.id.container, fragments[3]);
//                        break;
//
//                }
//                //트랜잭션 작업 종료
//                tran.commit();
//
//                //return true가 아니면 선택은되지만 선택효과가 되지않음
//                return true;
//            }
//        });

    }
}
