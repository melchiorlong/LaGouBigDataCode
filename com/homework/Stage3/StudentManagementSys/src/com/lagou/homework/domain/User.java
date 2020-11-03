package com.lagou.homework.domain;

public class User {

    private int FID;
    private String FUserName;
    private String FPassword;


    public User() {
    }

    public User(int FID, String FUserName, String FPassword) {
        this.FID = FID;
        this.FUserName = FUserName;
        this.FPassword = FPassword;
    }

    public int getFID() {
        return FID;
    }


    public String getFUserName() {
        return FUserName;
    }

    public void setFUserName(String FUserName) {
        this.FUserName = FUserName;
    }

    public String getFPassword() {
        return FPassword;
    }

    public void setFPassword(String FPassword) {
        this.FPassword = FPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "FID=" + FID +
                ", FUserName='" + FUserName + '\'' +
                ", FPassword='" + FPassword + '\'' +
                '}';
    }
}
