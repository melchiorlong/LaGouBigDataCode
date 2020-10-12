package com.study.Stage2.Section1.Task6.PoolTest;

import com.study.Stage2.Section1.Task6.Utils.DBCPUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author tianlong
 */
public class DBCPTest {

    public static void main(String[] args) throws SQLException {
        // 1、获取连接 从DBCP连接池中拿到连接
        Connection connection = DBCPUtils.getConnection();

        // 2、获取Statement对象
        Statement statement = connection.createStatement();

        // 3、查询所有员工的姓名
        String sql = "select ename from employee";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            String name = resultSet.getString(1);
            System.out.println("name = " + name);
        }
    }
}
