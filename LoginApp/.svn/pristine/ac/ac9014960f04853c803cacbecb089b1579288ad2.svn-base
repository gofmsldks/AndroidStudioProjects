package com.example.loginapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.loginapp.dto.LoginRequestDTO;
import com.example.loginapp.dto.LoginResponseDTO;
import com.example.loginapp.dto.UserListDTO;
import com.example.loginapp.dto.UserListResponseDTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    ImageButton imageButton;
    ImageButton imageButton2;

    private RetrofitClient retrofitClient;
    private initMyApi initMyApi;
    private String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Intent intent= getIntent();
        str = intent.getStringExtra("userId");
        TextView user_text = (TextView)findViewById(R.id.textView2);
        user_text.setText(str + "님");

        imageButton = (ImageButton)findViewById(R.id.imageButton);
        imageButton2 = (ImageButton)findViewById(R.id.imageButton2);

        imageButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                userListResponse();
            }
        });

        imageButton2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                userListResponse2();
            }
        });
    }



    public void userListResponse(){
        //retrofit 생성
        retrofitClient = RetrofitClient.getInstance();
        initMyApi = RetrofitClient.getRetrofitInterface();

        LoginRequestDTO userListRequset = new LoginRequestDTO();
        userListRequset.setId(str);
        userListRequset.setPw("CONFIRM"); // 비밀번호는 임의로 설정(로그인을 하는것이 아니라 아이디 확인용 이므로)

        initMyApi.getUserListResponse(userListRequset).enqueue(new Callback<UserListResponseDTO>() {

            @Override
            public void onResponse(Call<UserListResponseDTO> call, Response<UserListResponseDTO> response) {
                Log.d("retrofit", "Data fetch success");

                //통신 성공
                if (response.isSuccessful() && response.body() != null) {

                    //response.body()를 result에 저장
                    UserListResponseDTO result = response.body();

                    //받은 코드 저장
                    String resultCode = result.getMsg();
                    ArrayList<UserListDTO> userList = (ArrayList<UserListDTO>)result.getUserList();
                    Log.d( "RESPONSE","onResponse: ");
                    String success = "UserListReadSUCCESS"; //읽어오기 성공
                    String error = "UserListReadFAIL"; //읽어오기 실패


                    if (resultCode.equals(success)) {

                        Toast.makeText(LoginActivity.this, " 회원리스트 ", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(LoginActivity.this, UserListActivity.class);
                        intent.putExtra("userList", userList);
                        startActivity(intent);
                        LoginActivity.this.finish();

                    } else if(resultCode.equals(error)){

                        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                        builder.setTitle("알림")
                                .setMessage("예기치 못한 오류가 발생하였습니다.")
                                .setPositiveButton("확인", null)
                                .create()
                                .show();



                    }
                }
            }

            @Override
            public void onFailure(Call<UserListResponseDTO> call, Throwable t) {


                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                builder.setTitle("알림")
                        .setMessage("예기치 못한 오류가 발생하였습니다.")
                        .setPositiveButton("확인", null)
                        .create()
                        .show();


            }



        });


    }


    public void userListResponse2(){
        //retrofit 생성
        retrofitClient = RetrofitClient.getInstance();
        initMyApi = RetrofitClient.getRetrofitInterface();

        LoginRequestDTO userListRequset = new LoginRequestDTO();
        userListRequset.setId(str);
        userListRequset.setPw("CONFIRM"); // 비밀번호는 임의로 설정(로그인을 하는것이 아니라 아이디 확인용 이므로)

        initMyApi.getUserListResponse(userListRequset).enqueue(new Callback<UserListResponseDTO>() {

            @Override
            public void onResponse(Call<UserListResponseDTO> call, Response<UserListResponseDTO> response) {
                Log.d("retrofit", "Data fetch success");

                //통신 성공
                if (response.isSuccessful() && response.body() != null) {

                    //response.body()를 result에 저장
                    UserListResponseDTO result = response.body();

                    //받은 코드 저장
                    String resultCode = result.getMsg();
                    ArrayList<UserListDTO> userList = (ArrayList<UserListDTO>)result.getUserList();
                    Log.d( "RESPONSE","onResponse: ");
                    String success = "UserListReadSUCCESS"; //읽어오기 성공
                    String error = "UserListReadFAIL"; //읽어오기 실패


                    if (resultCode.equals(success)) {

                        Toast.makeText(LoginActivity.this, " 회원리스트 ", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(LoginActivity.this, UserListActivity2.class);
                        intent.putExtra("userList", userList);
                        startActivity(intent);
                        LoginActivity.this.finish();

                    } else if(resultCode.equals(error)){

                        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                        builder.setTitle("알림")
                                .setMessage("예기치 못한 오류가 발생하였습니다.")
                                .setPositiveButton("확인", null)
                                .create()
                                .show();



                    }
                }
            }

            @Override
            public void onFailure(Call<UserListResponseDTO> call, Throwable t) {


                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                builder.setTitle("알림")
                        .setMessage("예기치 못한 오류가 발생하였습니다.")
                        .setPositiveButton("확인", null)
                        .create()
                        .show();


            }



        });


    }

}
