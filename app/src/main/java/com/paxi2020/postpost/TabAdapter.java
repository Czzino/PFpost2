package com.paxi2020.postpost;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TabAdapter extends FragmentPagerAdapter {

    Fragment[] fragments= new Fragment[2];
    String[] tabTexts= new String[]{"예약택배","받는택배"};


    public TabAdapter(@NonNull FragmentManager fm) {

        super(fm);

        fragments[0]= new TabFragment1();
        fragments[1]= new TabFragment2();

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTexts[position];
    }
}
