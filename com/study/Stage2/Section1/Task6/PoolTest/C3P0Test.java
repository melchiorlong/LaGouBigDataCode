package com.study.Stage2.Section1.Task6.PoolTest;

import com.study.Stage2.Section1.Task6.Utils.C3P0Utils;

import java.sql.*;

/**
 * @author Administrator
 * 查询姓名为李白的记录
 */
public class C3P0Test {

    public static void main(String[] args) throws SQLException {

        Connection connection = C3P0Utils.getConnection();
        String sql = "select * from employee where ename = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "李白");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int eid = resultSet.getInt("eid");
            String ename = resultSet.getString("ename");
            int age = resultSet.getInt("age");
            String sex = resultSet.getString("sex");
            double salary = resultSet.getDouble("salary");
            String empdate = resultSet.getString("empdate");
            System.out.println("eid = " + eid);
            System.out.println("ename = " + ename);
            System.out.println("age = " + age);
            System.out.println("sex = " + sex);
            System.out.println("salary = " + salary);
            System.out.println("empdate = " + empdate);
        }

        C3P0Utils.close(connection, preparedStatement, resultSet);
    }
}
