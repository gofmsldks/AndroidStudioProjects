package com.example.loginapp.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UserListDTO implements Serializable {

    @SerializedName("id")
    private String id;

    @SerializedName("pw")
    private String pw;

    @SerializedName("name")
    private String name;

    @SerializedName("email")
    private String email;

    @SerializedName("position")
    private String position;

    @SerializedName("age")
    private String age;

    @SerializedName("phoneNumber")
    private String phoneNumber;

    public void setId(String id) {
        this.id = id;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public String getPw() {
        return pw;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPosition() {
        return position;
    }

    public String getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
