package com.paxi2020.postpost;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PostFragment2 extends Fragment {

    Spinner spn;
    ArrayAdapter arrayAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        spn=getView().findViewById(R.id.spinner);


        View view = inflater.inflate(R.layout.activity_post_fragment2,container,false);
        return view;
    }

//    public void spinnerAdapter(){
//
//        arrayAdapter= ArrayAdapter.createFromResource(,R.array.arrays, android.R.layout.simple_spinner_dropdown_item);
//
//        spn.setAdapter(arrayAdapter);
//
//    }
}
