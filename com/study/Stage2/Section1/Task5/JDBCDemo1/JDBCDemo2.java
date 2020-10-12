package com.study.Stage2.Section1.Task5.JDBCDemo1;

import java.sql.*;

/**
 * @author tianlong
 */
public class JDBCDemo2 {

    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String dbUrl = "jdbc:mysql://127.0.0.1:3306/lianxi01?characterEncoding=UTF-8";
            String dbUser = "root";
            String dbPassword = "123456";

            connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            statement = connection.createStatement();

            String sql = "select * from t_lg_coursecategory";
            rs = statement.executeQuery(sql);

            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String createTime = rs.getString("createtime");
                String lastUpdateTime = rs.getString("lastupdatetime");
                System.out.println("id = " + id + ", name = " + name + ", description = " + description +
                        ", createTime = " + createTime + ", lastUpdateTime = " + lastUpdateTime);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
