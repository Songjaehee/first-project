package com.ohgiraffers.library.dto;

public class UserLoginDTO {

    private String userName;
    private String userPhone;


    public UserLoginDTO() {

    };

    public UserLoginDTO(String userName, String userPhone) {
        this.userName = userName;
        this.userPhone = userPhone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

}
