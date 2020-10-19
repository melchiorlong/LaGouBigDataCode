package com.study.Stage2.Section1.Task7.JDBCUtils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.sql.*;

/**
 * @author Administrator
 */

public class JDBCUtils {

    // 1.定义字符串变量 保存连接信息

    public static String DRIVER_NAME;
    public static String URL;
    public static String USER;
    public static String PASSWORD;

    // 2、编写静态代码块

    static {

        // 使用XPath对xml中数据进行读取
        try {
            SAXReader reader = new SAXReader();
            Document document = reader.read("I:\\LaGou_BigData_Study\\src\\com\\study\\Stage2\\Section1\\Task7\\JDBCUtils\\jdbc-config.xml");

            // 1.获取驱动名
            Node driverClassNode = document.selectSingleNode("/jdbc/property[@name = 'driverClass']");
            DRIVER_NAME = driverClassNode.getText();

            // 2.获取url
            Node jdbcUrlNode = document.selectSingleNode("/jdbc/property[@name = 'jdbcUrl']");
            URL = jdbcUrlNode.getText();

            // 3.获取用户名
            Node userNode = document.selectSingleNode("/jdbc/property[@name = 'user']");
            USER = userNode.getText();

            // 4.获取密码
            Node passwordNode = document.selectSingleNode("/jdbc/property[@name = 'password']");
            PASSWORD = passwordNode.getText();

            // 注册驱动
            Class.forName(DRIVER_NAME);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
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
