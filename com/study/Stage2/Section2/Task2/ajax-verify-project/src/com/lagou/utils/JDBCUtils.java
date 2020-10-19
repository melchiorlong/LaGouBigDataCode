package com.lagou.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Administrator
 * 作用：
 * 通过该工具类获取数据库连接对象和连接池对象等
 *
 */
public class JDBCUtils {

    // 创建C3P0连接池

    private static DataSource dataSource = new ComboPooledDataSource();

        private static Connection connection;

    public static DataSource getDataSource (){
        return dataSource;
    }


    public static Connection getConnection () throws SQLException {
        return dataSource.getConnection();
    }

}
