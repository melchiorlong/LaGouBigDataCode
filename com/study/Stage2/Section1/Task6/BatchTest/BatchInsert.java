package com.study.Stage2.Section1.Task6.BatchTest;

import com.study.Stage2.Section1.Task6.Utils.DruidUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Administrator
 *
 * 使用批处理 向表中添加10000条数据
 */
public class BatchInsert {

    public static void main(String[] args) throws SQLException {

        // 1、获取连接
        Connection connection = DruidUtils.getConnection();
        // 2、获取预处理平台
        PreparedStatement ps = connection.prepareStatement("insert into testbatch(uname) values (?)");

        // 3、循环插入
        for (int i = 0; i < 10000; i++) {
            ps.setString(1,"小强" + i);
            // 将SQL添加到批处理列表
            ps.addBatch();
        }

        long start = System.currentTimeMillis();

        // 4、统一执行 批量插入操作
        ps.executeBatch();

        long end = System.currentTimeMillis();

        // 5、关闭资源
        DruidUtils.close(connection, ps);

        System.out.println("start = " + start);
        System.out.println("end = " + end);
        System.out.println("Duration = " + (start - end));
    }

}
