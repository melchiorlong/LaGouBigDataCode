package com.study.Stage1.Section4.Task1.ObjectIOStream;

import java.io.Serializable;

/**
 * @author tianlong
 */
public class User implements Serializable {

    private static final long serialVersionUID = 8899818247023230612L;
    private String name;
    private String password;
    private String phoneNum;

    public User() {
    }

    public User(String name, String password, String phoneNum) {
        this.name = name;
        this.password = password;
        this.phoneNum = phoneNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                '}';
    }
}
