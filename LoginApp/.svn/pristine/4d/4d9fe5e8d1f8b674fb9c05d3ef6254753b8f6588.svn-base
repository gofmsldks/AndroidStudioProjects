package com.example.loginapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginapp.dto.LoginRequestDTO;
import com.example.loginapp.dto.LoginResponseDTO;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private RetrofitClient retrofitClient;
    private initMyApi initMyApi;

    Button login_btn;
    Button register_btn;
    EditText id_edit;
    EditText pw_edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login_btn = (Button)findViewById(R.id.login_btn);
        register_btn = (Button)findViewById(R.id.register_btn);

        id_edit = (EditText)findViewById(R.id.id_edit);
        pw_edit = (EditText)findViewById(R.id.pw_edit);

        //로그인 버튼
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String id = id_edit.getText().toString();
                String pw = pw_edit.getText().toString();
                // 로그인 미입력시
                if (id.trim().length() == 0 || pw.trim().length() == 0 || id == null || pw == null) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("알림")
                            .setMessage("내용을 입력바랍니다.")
                            .setPositiveButton("확인", null)
                            .create()
                            .show();
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();

                }else{
                    // 로그인 통신 시작
                    LoginResponse();
                }
            }
        });

        // 회원가입 버튼 눌렀을 때 회원 가입 페이지로 연결
        register_btn.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View view) {

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://192.168.240.232:8080/register"));
            // intent.setPackage("com.android.chrome");   // 브라우저가 여러개 인 경우 콕 찍어서 크롬을 지정할 경우
            startActivity(intent);

            finish();  // 브라우저만 띄우고 종료

            }
        });

    }



    public void LoginResponse() {
        String userID = id_edit.getText().toString().trim();
        String userPassword = pw_edit.getText().toString().trim();

        //loginRequest에 사용자가 입력한 id와 pw를 저장
        LoginRequestDTO loginRequest = new LoginRequestDTO();
        loginRequest.setId(userID);
        loginRequest.setPw(userPassword);

        //retrofit 생성
        retrofitClient = RetrofitClient.getInstance();
        initMyApi = RetrofitClient.getRetrofitInterface();

        //loginRequest에 저장된 데이터와 함께 init에서 정의한 getLoginResponse 함수를 실행한 후 응답을 받음
        initMyApi.getLoginResponse(loginRequest).enqueue(new Callback<LoginResponseDTO>() {

            @Override
            public void onResponse(Call<LoginResponseDTO> call, Response<LoginResponseDTO> response) {

                Log.d("retrofit", "Data fetch success");

                //통신 성공
                if (response.isSuccessful() && response.body() != null) {

                    //response.body()를 result에 저장
                    LoginResponseDTO result = response.body();

                    //받은 코드 저장
                    String resultCode = result.getMsg();


                    String success = "SUCCESS"; //로그인 성공
                    String errorIdPw = "FAIL"; //아이디 또는 비밀번호 블일치x


                    if (resultCode.equals(success)) {
                        String userID = id_edit.getText().toString();
                        String userPassword = pw_edit.getText().toString();


                        Toast.makeText(MainActivity.this, userID + "님 환영합니다.", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                        intent.putExtra("userId", userID);
                        startActivity(intent);
                        MainActivity.this.finish();

                    } else if (resultCode.equals(errorIdPw)) {

                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setTitle("알림")
                                .setMessage("아이디 또는 비밀번호가 틀렸습니다.")
                                .setPositiveButton("확인", null)
                                .create()
                                .show();
                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();

                    } else {

                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setTitle("알림")
                                .setMessage("예기치 못한 오류가 발생하였습니다.")
                                .setPositiveButton("확인", null)
                                .create()
                                .show();

                    }
                }
            }

            //통신 실패
            @Override
            public void onFailure(Call<LoginResponseDTO> call, Throwable t) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("알림")
                        .setMessage("예기치 못한 오류가 발생하였습니다.")
                        .setPositiveButton("확인", null)
                        .create()
                        .show();
            }
        });
    }


}