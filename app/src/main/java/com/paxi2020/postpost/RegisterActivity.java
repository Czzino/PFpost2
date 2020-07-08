package com.paxi2020.postpost;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    EditText et_id, et_password, et_pwcheck, et_name, et_age;
    Button btnJoin, btnCheck;
    AlertDialog.Builder dialog;
    boolean validate=false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        et_id=findViewById(R.id.et_id);
        et_password=findViewById(R.id.et_password);
        et_pwcheck=findViewById(R.id.et_pwcheck);
        et_name=findViewById(R.id.et_name);
        et_age=findViewById(R.id.et_age);

        btnCheck=findViewById(R.id.btn_validate);
        btnJoin=findViewById(R.id.btn_register);

        btnCheck.setOnClickListener(new View.OnClickListener() { //중복체크
            @Override
            public void onClick(View v) {
                //아이디 입력을 듣는 리스너 입력된값이  중복체크
                String id= et_id.getText().toString();
                //중복이 안됐을때
                if(validate){
                    return;
                }
                //빈칸일 떄
                if(id.equals("")){
                    AlertDialog.Builder builder= new AlertDialog.Builder(RegisterActivity.this);
                    builder.setMessage("아이디는 빈칸일수 없습니다").setPositiveButton("확인",null).create().show();
                    return;
                }else {
                    AlertDialog.Builder builder=new AlertDialog.Builder(RegisterActivity.this);
                    builder.setMessage("사용가능합니다").setPositiveButton("확인",null).create().show();

                }

                //Volley에 등록된 Reponse 리스너 이용
                Response.Listener<String> responseListener= new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonResponse= new JSONObject(response);
                            //인터넷 연결작업은 거의 try catch 상황
                            boolean success= jsonResponse.getBoolean("success");
                            if(success){
                                AlertDialog.Builder builder= new AlertDialog.Builder(RegisterActivity.this);
                                builder.setMessage("아이디를 사용하실수 있습니다").setPositiveButton("확인",null).create().show();
                                et_id.setEnabled(false);
                                validate=true;
                                btnCheck.setText("확인");
                            }else{
                                AlertDialog.Builder builder= new AlertDialog.Builder(RegisterActivity.this);
                                builder.setMessage("사용할수 없는 아이디 입니다").setPositiveButton("확인",null).create().show();


                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };

                UserCheckRequest userCheckRequest= new UserCheckRequest(id,responseListener);
                RequestQueue queue= Volley.newRequestQueue(RegisterActivity.this);
                queue.add(userCheckRequest);
            }
        });

        //회원가입을 눌렀을때 발동하는 리스너
       btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //editText에 입력되어있는 값을 get(가져온다)해온다
                String id=et_id.getText().toString();
                final String password=et_password.getText().toString();
                String name=et_name.getText().toString();
                int age=Integer.parseInt(et_age.getText().toString());

                final String pwcheck=et_pwcheck.getText().toString();

                Response.Listener<String> responseListener=new Response.Listener<String>() {//volley
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jasonObject=new JSONObject(response);//Register2 php에 response
                            boolean success=jasonObject.getBoolean("success");//Register2 php에 sucess
                            if(password.equals(pwcheck)) {
                                if (success) {//회원등록 성공한 경우
                                    Toast.makeText(getApplicationContext(), "회원 등록 성공", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                    startActivity(intent);
                                }
                            }
                            else{//회원등록 실패한 경우
                                Toast.makeText(getApplicationContext(),"회원 등록 실패",Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                //서버로 volley를 이용해서 요청을 함
                UserJoinRequest registerRequest=new UserJoinRequest(id,password, name, age,responseListener);
                RequestQueue queue= Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerRequest);

    }

       });
    }

}
