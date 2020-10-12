package com.study.Stage2.Section1.Task5.JDBCDMLTest;

import com.study.Stage2.Section1.Task5.utils.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author tianlong
 */
public class DMLTest {



    @Test
    public void test() throws Exception {
        // 1、通过JDBCUtils工具类获取连接
        Connection connection = JDBCUtils.getConnection();

        // 2、获取Statement对象
        Statement statement = connection.createStatement();

        // 3、编写SQL
        String sql = "select * from t_lg_coursecategory";
        ResultSet rs = statement.executeQuery(sql);

        while (rs.next()) {
            String id = rs.getString("id");
            String name = rs.getString("name");
            String description = rs.getString("description");
            String createTime = rs.getString("createtime");
            String lastUpdateTime = rs.getString("lastupdatetime");
            System.out.println("id = " + id + ", name = " + name + ", description = " + description +
                    ", createTime = " + createTime + ", lastUpdateTime = " + lastUpdateTime);
        }


        JDBCUtils.close(connection, statement,rs);


    }

}
