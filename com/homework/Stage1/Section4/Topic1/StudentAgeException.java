package com.homework.Stage1.Section4.Topic1;

/**
 * @author tianlong
 * 基于学生信息管理系统增加以下两个功能：
 * a.自定义学号异常类和年龄异常类，并在该成员变量不合理时产生异常对象并抛出。
 * b.当系统退出时将 List 集合中所有学生信息写入到文件中，当系统启动时读取文件中所 有学生信息到 List 集合中。
 */
public class StudentAgeException extends Exception {
    private static final long serialVersionUID = -4844821718245480576L;

    public StudentAgeException() {
    }

    public StudentAgeException(String message) {
        super(message);
    }
}
