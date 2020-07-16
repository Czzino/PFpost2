package com.paxi2020.postpost;

public class RegisterItem {

    public RegisterItem() {
    }

    String userId;
    String userPassword;
    String userName;
    String userEmail;

    public RegisterItem(String userId, String userPassword, String userName, String userEmail) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userEmail = userEmail;
    }
}

