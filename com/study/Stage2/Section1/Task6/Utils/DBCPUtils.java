package com.study.Stage2.Section1.Task6.Utils;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author tianlong
 */
public class DBCPUtils {

    // 1、定义常量
    public static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://127.0.0.1:3306/db5?characterEncoding=UTF-8";
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "123456";

    // 2、创建连接池对象

    public static BasicDataSource dataSource = new BasicDataSource();

    // 3、使用静态代码块进行配置
    static {
    dataSource.setDriverClassName(DRIVER_NAME);
    dataSource.setUrl(URL);
    dataSource.setUsername(USER_NAME);
    dataSource.setPassword(PASSWORD);
    }

    // 4、编写获取连接的方法
    public static Connection getConnection() {

        // 从连接池中获取
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // 5、编写关闭连接的方法
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
        if (connection != null && statement != null && resultSet != null) {
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
