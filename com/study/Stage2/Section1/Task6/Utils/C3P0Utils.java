package com.study.Stage2.Section1.Task6.Utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author tianlong
 */
public class C3P0Utils {

    // 1、创建连接池对象 C3P0对DataSource接口的实现类

    // 空参构造使用的是配置文件中的默认控制
    // public static ComboPooledDataSource dataSource = new ComboPooledDataSource();

    // 使用指定的配置 参数中传配置文件中的 name

    public static ComboPooledDataSource dataSource = new ComboPooledDataSource("mysql");


    // 2、提供获取连接的方法

    public static Connection getConnection () {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // 3、提供关闭方法

    public static void close (Connection connection, Statement statement) {
        if (connection != null && statement != null) {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close (Connection connection, Statement statement, ResultSet resultSet) {
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
