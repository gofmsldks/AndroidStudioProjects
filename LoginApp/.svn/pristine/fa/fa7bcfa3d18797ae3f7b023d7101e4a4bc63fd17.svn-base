package com.example.loginapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.loginapp.dto.UserListDTO;

import java.util.ArrayList;

public class UserListActivity2 extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userlist_main);

        Intent intent= getIntent();
        ArrayList<UserListDTO> al = (ArrayList<UserListDTO>) intent.getSerializableExtra("userList");


        MyAdapter adapter = new MyAdapter(
                getApplicationContext(), // 현재화면의 제어권자
                R.layout.row,  // 리스트뷰의 한행의 레이아웃
                al);         // 데이터

        ListView lv = (ListView)findViewById(R.id.listView1);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // 상세정보 화면으로 이동하기(인텐트 날리기)
                // 1. 다음화면을 만든다
                // 2. AndroidManifest.xml 에 화면을 등록한다
                // 3. Intent 객체를 생성하여 날린다
                Intent intent = new Intent(
                        getApplicationContext(), // 현재화면의 제어권자
                        UserlistDetail.class); // 다음넘어갈 화면

                // intent 객체에 데이터를 실어서 보내기
                // 리스트뷰 클릭시 인텐트 (Intent) 생성하고 position 값을 이용하여 인텐트로 넘길값들을 넘긴다
                intent.putExtra("email", al.get(position).getEmail());
                intent.putExtra("age",  Integer.toString(al.get(position).getAge()));
                intent.putExtra("phoneNumber", al.get(position).getPhoneNumber());

                startActivity(intent);
            }
        });
    }


}


class MyAdapter extends BaseAdapter { // 리스트 뷰의 아답타
    Context context;
    int layout;
    ArrayList<UserListDTO> al;
    LayoutInflater inf;
    public MyAdapter(Context context, int layout, ArrayList<UserListDTO> al) {
        this.context = context;
        this.layout = layout;
        this.al = al;
        inf = (LayoutInflater)context.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return al.size();
    }

    @Override
    public Object getItem(int position) {
        return al.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null) {
            convertView = inf.inflate(layout, null);
        }
        TextView id = (TextView)convertView.findViewById(R.id.ID);
        TextView name = (TextView)convertView.findViewById(R.id.Name);
        TextView rank_position = (TextView)convertView.findViewById(R.id.Position);

        UserListDTO m = al.get(position);
        id.setText(m.getId());
        name.setText(m.getName());
        rank_position.setText(m.getPosition());

        return convertView;
    }
}