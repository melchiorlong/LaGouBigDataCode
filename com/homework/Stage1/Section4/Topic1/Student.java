package com.homework.Stage1.Section4.Topic1;

/**
 * @author tianlong
 */
public class Student {

    /**
     * 学生的信息有：学号、姓名、年龄。
     */

    private String name;
    private int id;
    private int age;

    public Student() {
    }

    public Student(String name, int id, int age) throws StudentNumException, StudentAgeException {
        setName(name);
        setId(id);
        setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) throws StudentNumException {
        if (id > 0) {
            this.id = id;
        } else {
            throw new StudentNumException("学号不合理！");
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws StudentAgeException {
        if (age > 0 && age < 150) {
            this.age = age;
        } else {
            throw new StudentAgeException("年龄不合理！");
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "姓名：'" + getName() + '\'' +
                ", 学号：" + getId() +
                ", 年龄：" + getAge() +
                '}';
    }
}
