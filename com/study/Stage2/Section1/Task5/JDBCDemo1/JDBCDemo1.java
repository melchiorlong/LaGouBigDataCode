package com.study.Stage2.Section1.Task5.JDBCDemo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @author tianlong
 */
public class JDBCDemo1 {

    public static void main(String[] args) throws Exception {

        // 1、注册驱动
//        Class.forName("com.mysql.jdbc.Driver");

        // 2、获取连接，connection 连接对象
        String dbUrl = "jdbc:mysql://127.0.0.1:3306/lianxi01?characterEncoding=UTF-8";
        String dbUser = "root";
        String dbPassword = "123456";
        Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);

        // 3、获取语句执行平台 Statement
        StringBuffer sql = new StringBuffer();
        sql.append("create table test01(id int, name varchar(20), age int)");
        Statement statement = connection.createStatement();
        int i = statement.executeUpdate(sql.toString());
        System.out.println("i = " + i);






        // 关闭对象
        statement.close();
        connection.close();
    }

}
