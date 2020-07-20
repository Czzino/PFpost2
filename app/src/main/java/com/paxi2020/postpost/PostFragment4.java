package com.paxi2020.postpost;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import retrofit2.Retrofit;

public class PostFragment4 extends Fragment {

    EditText et_name1, et_phone, et_address1_1, et_address1_2, et_message;
    EditText et_name2, et_phone2, et_address2_1, et_address2_2, et_message2;

    Button btn_booking;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_post_fragment4,container,false);


        et_name1=view.findViewById(R.id.et_name);
        et_phone=view.findViewById(R.id.et_phoneNumber);
        et_address1_1=view.findViewById(R.id.et_address1_1);
        et_address1_2=view.findViewById(R.id.et_address1_2);
        et_message=view.findViewById(R.id.et_message);

        et_name2=view.findViewById(R.id.et_name2);
        et_phone2=view.findViewById(R.id.et_phoneNumber2);
        et_address2_1=view.findViewById(R.id.et_address2_1);
        et_address2_2=view.findViewById(R.id.et_address2_2);
        et_message2=view.findViewById(R.id.et_message2);


        btn_booking=view.findViewById(R.id.btn_booking);
        btn_booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=et_name1.getText().toString();
                String name2= et_name2.getText().toString();

                String phone= et_phone.getText().toString();
                String phone2= et_phone2.getText().toString();

                String address1_1=et_address1_1.getText().toString();
                String address1_2=et_address1_2.getText().toString();
                String address2_1=et_address2_1.getText().toString();
                String address2_2=et_address2_2.getText().toString();

                String message= et_message.getText().toString();
                String message2= et_message2.getText().toString();

                //레트로핏 라이브러리로 데이터를 전송
                Retrofit retrofit= RetrofitHelper.getInstance();//String 응답
                RetrofitService retrofitService = retrofit.create(RetrofitService.class);

            }
        });


        return view;

    }
}
