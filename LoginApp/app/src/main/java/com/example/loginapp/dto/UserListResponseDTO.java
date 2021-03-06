package com.example.loginapp.dto;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
//t
public class UserListResponseDTO implements Serializable {

    @SerializedName("userList")
    ArrayList<UserListDTO> userList;

    @SerializedName("msg")
    String msg;

    public ArrayList<UserListDTO> getUserList() {
        return userList;
    }

    public String getMsg() {
        return msg;
    }

    public void setUserList(ArrayList<UserListDTO> userList) {
        this.userList = userList;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
