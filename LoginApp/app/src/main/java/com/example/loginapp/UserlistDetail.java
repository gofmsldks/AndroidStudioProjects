package com.example.loginapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class UserlistDetail extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userlist_detail);

        TextView email = (TextView)findViewById(R.id.Email);
        TextView phoneNumber = (TextView)findViewById(R.id.PhoneNumber);
        TextView age = (TextView)findViewById(R.id.Age);

        Intent intent = getIntent(); // 보내온 Intent를 얻는다
        Log.d("이메일 아이디", "*********: " + intent.getStringExtra("email"));
        Log.d("전화 번호", "*********: " + intent.getStringExtra("phoneNumber"));
        Log.d("나이", "*********: " + intent.getStringExtra("age"));

        email.setText(intent.getStringExtra("email"));
        phoneNumber.setText(intent.getStringExtra("phoneNumber"));
        age.setText(intent.getStringExtra("age"));

    } // end of onCreate
} // end of class

