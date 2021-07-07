package com.example.loginapp;

import com.example.loginapp.dto.LoginRequestDTO;
import com.example.loginapp.dto.LoginResponseDTO;
import com.example.loginapp.dto.UserListDTO;
import com.example.loginapp.dto.UserListResponseDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface initMyApi {
    //@통신 방식("통신 API명")
    @POST("/login")
    Call<LoginResponseDTO> getLoginResponse(@Body LoginRequestDTO loginRequest);

    @POST("/userList")
    Call<UserListResponseDTO> getUserListResponse(@Body LoginRequestDTO UserListRequset);
}
