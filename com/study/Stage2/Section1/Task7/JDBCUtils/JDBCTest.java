package com.study.Stage2.Section1.Task7.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Administrator\
 *
 * 需求
 * 从db5中查询employee表中所有员工的姓名
 *
 */
public class JDBCTest {

    public static void main(String[] args) throws SQLException {

        // 1.获取连接
        Connection connection = JDBCUtils.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from employee");
        while (resultSet.next()) {
            String ename = resultSet.getString("ename");
            System.out.println("员工姓名是 " + ename);
        }

        JDBCUtils.close(connection, statement, resultSet);
    }
}
