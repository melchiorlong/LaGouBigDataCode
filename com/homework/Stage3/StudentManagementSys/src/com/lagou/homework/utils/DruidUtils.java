package com.lagou.homework.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author Administrator
 */
public class DruidUtils {

    // 1、定义成员变量
    public static DataSource dataSource;

    // 2、定义静态代码块
    static {
        try {
            // 3、创建属性集对象
            Properties p = new Properties();

            // 4、加载配置文件
            // Druid 不能主动加载配置文件，需要手工指定文件位置
            InputStream resourceAsStream = DruidUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            // Properties对象的load方法，从字节流中读取配置信息
            p.load(resourceAsStream);

            // 5、通过工厂类获取连接池对象
            dataSource = DruidDataSourceFactory.createDataSource(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 获取连接的方法
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

    // 获取Druid连接池对象的方法

    public static DataSource getDataSource () {
        return dataSource;
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
