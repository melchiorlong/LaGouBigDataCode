package com.lagou.homework.domain;

import java.util.Date;

public class Student {

    private int FID;
    private String FName;
    private String FNumber;
    private int Gender;
    private Date BirthDate;

    public Student() {
    }

    public Student(int FID, String FName, String FNumber, int gender, Date birthDate) {
        this.FID = FID;
        this.FName = FName;
        this.FNumber = FNumber;
        Gender = gender;
        BirthDate = birthDate;
    }

    public int getFID() {
        return FID;
    }

    public void setFID(int FID) {
        this.FID = FID;
    }

    public String getFName() {
        return FName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public String getFNumber() {
        return FNumber;
    }

    public void setFNumber(String FNumber) {
        this.FNumber = FNumber;
    }

    public int getGender() {
        return Gender;
    }

    public void setGender(int gender) {
        Gender = gender;
    }

    public Date getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(Date birthDate) {
        BirthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "FID=" + FID +
                ", FName='" + FName + '\'' +
                ", FNumber='" + FNumber + '\'' +
                ", Gender=" + Gender +
                ", BirthDate=" + BirthDate +
                '}';
    }
}
