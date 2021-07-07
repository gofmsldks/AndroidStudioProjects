package com.example.loginapp.dto;

import com.google.gson.annotations.SerializedName;

public class LoginRequestDTO {

    @SerializedName("id")
    private String id;

    @SerializedName("pw")
    private String pw;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
}
