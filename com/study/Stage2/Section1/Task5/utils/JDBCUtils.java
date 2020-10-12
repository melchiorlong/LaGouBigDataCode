package com.study.Stage2.Section1.Task5.utils;

import java.sql.*;

/**
 * @author tianlong
 */
public class JDBCUtils {

    // 1、将连接信息定义为字符串常量
    public static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://127.0.0.1:3306/lianxi01?characterEncoding=UTF-8";
    public static final String USER = "root";
    public static final String PASSWORD = "123456";

    // 2、静态代码快
    static {
        try {
            Class.forName(DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 3、获取连接的静态方法
    public static Connection getConnection() {
        // 获取连接并返回对象
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // 4、关闭连接
    public static void close(Connection connection, Statement statement) {
        if (connection != null && statement != null) {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Connection connection, Statement statement, ResultSet resultSet) {
        if (connection != null && statement != null) {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
