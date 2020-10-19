package com.lagou.dao;

import com.lagou.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.sql.DataSource;
import java.sql.SQLException;

public class checkDao {

    // 检查用户名是否存在

    public boolean daoCheck(String name) throws SQLException {

        // 获取连接处对象
        DataSource dataSource = JDBCUtils.getDataSource();

        // 使用DBUtils
        QueryRunner qr = new QueryRunner(dataSource);

        // 查询操作
        String sql = "select count(*) from user where username = ?";
        long count = (long) qr.query(sql, new ScalarHandler(), name);

        // 如果查到数据 返回true
        return count >= 1;
    }


}
