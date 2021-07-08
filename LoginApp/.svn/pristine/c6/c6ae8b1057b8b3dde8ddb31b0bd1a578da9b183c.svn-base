package com.example.loginapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.loginapp.dto.LoginResponseDTO;
import com.example.loginapp.dto.UserListDTO;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;

public class UserListActivity extends AppCompatActivity {

    private TableLayout tableLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlist);

        Intent intent= getIntent();
        ArrayList<UserListDTO> userList = (ArrayList<UserListDTO>) intent.getSerializableExtra("userList");

        tableLayout = (TableLayout) findViewById(R.id.table_layout);



        for(int i = 0; i < userList.size(); i++) {
            TableRow tableRow = new TableRow(this);
            tableRow.setLayoutParams(new TableRow.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
                final TextView text1 = new TextView(this);
                final TextView text2 = new TextView(this);
                final TextView text3 = new TextView(this);
                final TextView text4 = new TextView(this);
                final TextView text5 = new TextView(this);
                final TextView text6 = new TextView(this);

            text1.setText(String.valueOf(userList.get(i).getId()));
            text1.setPadding(10,50,10,50);

            text2.setText(String.valueOf(userList.get(i).getName()));
            text2.setPadding(10,50,10,50);

            text3.setText(String.valueOf(userList.get(i).getEmail()));
            text3.setPadding(10,50,10,50);

            text4.setText(String.valueOf(userList.get(i).getPosition()));
            text4.setPadding(10,50,10,50);

            text5.setText(String.valueOf(userList.get(i).getAge()));
            text5.setPadding(10,50,10,50);

            text6.setText(String.valueOf(userList.get(i).getPhoneNumber()));
            text6.setPadding(10,50,10,50);


            tableRow.addView(text1);
            tableRow.addView(text2);

            tableRow.addView(text3);
            tableRow.addView(text4);

            tableRow.addView(text5);
            tableRow.addView(text6);


            tableLayout.addView(tableRow);


        }
    }
}
