package com.paxi2020.postpost;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

public class PostFragment2 extends Fragment {

    Spinner spinner;

    ArrayAdapter adapter;

    Button button;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.activity_post_fragment2,container,false);

        spinner= view.findViewById(R.id.spinner);

        //대량의 데이터들을 뷰들로 만들어주는 객체생성
        adapter= ArrayAdapter.createFromResource(getActivity(),R.array.arrays,R.layout.dropdown_selected);
        spinner.setAdapter(adapter);

        // TExtview의 디자인 변경
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        Button button= view.findViewById(R.id.btn_search);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(),MainActivity.class);
            }
        });

        return view;


    }

}
