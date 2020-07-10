package com.paxi2020.postpost;

public class RegisterItem {

    String userId;
    String userPass;
    String userName;
    String userEamil;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEamil() {
        return userEamil;
    }

    public void setUserEamil(String userEamil) {
        this.userEamil = userEamil;
    }

    public RegisterItem(String userId, String userPass, String userName, String userEamil) {
        this.userId = userId;
        this.userPass = userPass;
        this.userName = userName;
        this.userEamil = userEamil;
    }
}
