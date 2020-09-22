package com.homework.Stage1.Section4.Topic4;

/**
 * @author tianlong
 * User 类的特征有：用户名、密码(字符串类型)。
 */
public class User {
    private String userName;
    private String passWord;

    public User() {
    }

    public User(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + getUserName() + '\'' +
                ", passWord='" + getPassWord() + '\'' +
                '}';
    }
}
