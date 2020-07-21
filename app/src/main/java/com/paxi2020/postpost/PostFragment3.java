package com.paxi2020.postpost;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PostFragment3 extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_post_fragment3,container,false);
        return view;


    }

    public void click11st(View view) {
        Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("http://11st.co.kr"));
        startActivity(intent);
    }

    public void clickHmall(View view) {
        Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("http://hyundaihmall.com"));
        startActivity(intent);
    }

    public void clickSmall(View view) {
        Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("http://shinsegaemall.ssg.com"));
        startActivity(intent);
    }

    public void clickLotte(View view) {
        Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("http://lotteimall.com"));
        startActivity(intent);
    }

    public void clickAuction(View view) {
        Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("http://auction.co.kr"));
        startActivity(intent);
    }

}
