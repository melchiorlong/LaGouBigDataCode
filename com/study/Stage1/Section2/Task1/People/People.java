package com.study.Stage1.Section2.Task1.People;

public class People {
    private String name;
    private int age;
    public static String nationality;

    public People(){}
    public People(String name, int age){
        setName(name);
        setAge(age);
        setNationality(nationality);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age > 0 && age <150){
            this.age = age;
        }else{
            System.out.println("年龄有误");
        }
    }

    public void setNationality(String nationality) {
        People.nationality = nationality;
    }

    public void show(){
        System.out.println("姓名：" + getName());
        System.out.println("年龄：" + getAge());
        System.out.println("国籍：" + getNationality());
    }

}
