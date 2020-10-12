package com.study.Stage2.Section1.Task6.DBMetaDataTest;

import com.study.Stage2.Section1.Task6.Utils.DruidUtils;

import java.sql.*;

public class DBMetaDataTest {

    public static void main(String[] args) throws SQLException {

        // 获取数据库元数据
        Connection connection = DruidUtils.getConnection();
        DatabaseMetaData metaData = connection.getMetaData();
        String url = metaData.getURL();
        String userName = metaData.getUserName();
        String databaseProductName = metaData.getDatabaseProductName();
        String databaseProductVersion = metaData.getDatabaseProductVersion();
        String driverName = metaData.getDriverName();
        String driverVersion = metaData.getDriverVersion();
        boolean readOnly = metaData.isReadOnly();

        System.out.println("url = " + url);
        System.out.println("userName = " + userName);
        System.out.println("databaseProductName = " + databaseProductName);
        System.out.println("databaseProductVersion = " + databaseProductVersion);
        System.out.println("driverName = " + driverName);
        System.out.println("driverVersion = " + driverVersion);
        System.out.println(readOnly ?"只读":"非只读");


        // 获取结果集元数据信息
        PreparedStatement preparedStatement = connection.prepareStatement("select * from employee");
        ResultSet resultSet = preparedStatement.executeQuery();

        ResultSetMetaData rsMetaData = preparedStatement.getMetaData();

        int columnCount = rsMetaData.getColumnCount();
        System.out.println("当前结果集中共有: " + columnCount + " 列。");

        for (int i = 1; i <= columnCount; i++) {
            String columnName = rsMetaData.getColumnName(i);
            System.out.print("第" + i + "列的列名是：" + columnName);

            String columnTypeName = rsMetaData.getColumnTypeName(i);
            System.out.println(" ，类型是：" + columnTypeName);
        }


        DruidUtils.close(connection, preparedStatement, resultSet);

    }
}
