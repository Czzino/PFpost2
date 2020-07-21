package com.paxi2020.postpost;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
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
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    DrawerLayout drawerLayout;
    TabAdapter adapter;

    NavigationView navi;

    ActionBarDrawerToggle drawerToggle;

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

        tabLayout=findViewById(R.id.tab_layout);
        viewPager=findViewById(R.id.view_pager);


        //뷰페이저 어댑터 연결
        adapter= new TabAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);

        //탭버튼 아이콘 설정
//        tabLayout.getTabAt(0).setIcon(R.drawable.ic_file_upload_white_24dp);

        //서브 제목 설정
        getSupportActionBar().setTitle("예약 택배");


        //탭이 변경되는것을 듣는 리스너 객체 추가
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                getSupportActionBar().setSubtitle( tab.getText());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {


            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        drawerLayout=findViewById(R.id.drawer_layout);
        drawerToggle= new ActionBarDrawerToggle(this,drawerLayout,toolbar, R.string.app_name,R.string.app_name);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
    }

    }


