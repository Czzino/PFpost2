package com.paxi2020.postpost;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class PostFragment1 extends Fragment {

    TabLayout tabLayout;
    ViewPager pager;

    Toolbar toolbar;

    TabAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.activity_post_fragment1,container,false);

        toolbar=view.findViewById(R.id.toolbar);

        MainActivity main= (MainActivity) getActivity();
        main.setSupportActionBar(toolbar);

        tabLayout=view.findViewById(R.id.tab_layout);
        pager=view.findViewById(R.id.view_pager);

        //뷰패이저 어댑터 연결
        adapter= new TabAdapter(getChildFragmentManager());
        pager.setAdapter(adapter);

        // 탭레이아웃 탭이랑 뷰페이저연결 왼쪾오른쪽 미는기능
        tabLayout.setupWithViewPager(pager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        return view;

    }
}
