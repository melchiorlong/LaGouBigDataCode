package com.study.Stage2.Section1.Task6.PoolTest;

import com.study.Stage2.Section1.Task6.Utils.DruidUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Administrator
 *
 * 需求
 * 查询薪资在3000~5000之间的员工姓名
 */
public class DruidTest {

    public static void main(String[] args) {

        PreparedStatement preparedStatement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        try {
            connection = DruidUtils.getConnection();
            String sql = "select ename from employee where salary between ? and ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,3000);
            preparedStatement.setInt(2,5000);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String ename = resultSet.getString("ename");
                System.out.println("ename = " + ename);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DruidUtils.close(connection, preparedStatement, resultSet);

    }

}
