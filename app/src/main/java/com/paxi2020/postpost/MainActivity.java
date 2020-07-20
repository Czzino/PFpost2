package com.paxi2020.postpost;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {


//    BottomNavigationView btnav;
//
//    FragmentManager fragmentManager;
//
//
//    Fragment[] fragments= new Fragment[4];

    NavigationView navi;
    DrawerLayout drawerLayout;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navi=findViewById(R.id.nav);
        navi.setItemIconTintList(null);
        drawerLayout=findViewById(R.id.drawer_layout);

        Toolbar toolbar= (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("배송조회 페이지 입니다");
        setSupportActionBar(toolbar);

    }
}
