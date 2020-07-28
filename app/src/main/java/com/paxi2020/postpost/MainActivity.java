package com.paxi2020.postpost;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
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

    NavigationView navi;

    BottomNavigationView bnv;

    FragmentManager fragmentManager;
    Fragment[] fragments = new Fragment[4];

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        fragments[0] = new PostFragment1();
        fragments[1] = new PostFragment2();
        fragments[2] = new PostFragment3();
        fragments[3] = new PostFragment4();



        FragmentTransaction tran = fragmentManager.beginTransaction();
        tran.add(R.id.rela_container, fragments[0]);
        tran.commit();

        bnv = findViewById(R.id.bottom_nav);
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                //프레그먼트 작업 트랜잭션 시작
                FragmentTransaction tran = fragmentManager.beginTransaction();

                switch (menuItem.getItemId()) {
                    case R.id.menu_post1:
                        tran.replace(R.id.rela_container, fragments[0]);
                        break;
                    case R.id.menu_post2:
                        tran.replace(R.id.rela_container, fragments[1]);
                        break;
                    case R.id.menu_post3:
                        tran.replace(R.id.rela_container, fragments[2]);
                        break;
                    case R.id.menu_post4:
                        tran.replace(R.id.rela_container, fragments[3]);
                        break;


                }

                //트랜잭션 작업 완료
                tran.commit();

                //return true가 아니면 ㅇ선택은 되지만 선택효과가 이동하지 않음
                return true;
            }
        });

        navi=findViewById(R.id.nav);
        navi.setItemIconTintList(null);

//        Toolbar toolbar= findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//
//        switch (item.getItemId()){
//            case android.R.id.home:{
//                finish();
//                return true;
//            }
//        }
//
//        return super.onOptionsItemSelected(item);
//
//
//    }
}


