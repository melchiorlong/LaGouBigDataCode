package com.study.Stage2.Section1.Task6.DBUtils.DBUtilsTest;

import com.study.Stage2.Section1.Task6.Utils.DruidUtils;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Administrator
 *
 * 使用QueryRunner对象 完成增删改
 * update(Connection con, String sql, Object... param)
 *
 *
 */
public class TestDemo2 {

    @Test
    public void testInsert() throws SQLException {

        // 1、创建QueryRunner 手动模式创建

        QueryRunner qr1 = new QueryRunner();

        // 2、编写 占位符方式 SQL

        String sql = "insert into employee values(?, ?, ?, ?, ?, ?)";

        // 3、这只占位符的参数
        Object[] param = {null, "张百万", 20, "女", 10000, "1990-12-12"};

        // 4、执行update方法
        Connection connection = DruidUtils.getConnection();
        int i = qr1.update(connection, sql, param);

        DbUtils.closeQuietly(connection);

    }

    // 修改姓名为张百万的工资为15000

    @Test
    public void testUpdate() throws SQLException {
        // 1、创建核心类
        QueryRunner qr2 = new QueryRunner(DruidUtils.getDataSource());
        // 2、编写sql
        String sql = "update employee set salary = ? where ename = ?";
        // 3、设置占位符参数
        Object[] param = {15000, "张百万"};
        // 4、执行修改操作
        // 自动模式不需要传入Connection对象！
        int i = qr2.update(sql, param);
        // 5、自动模式下 不需要手动关闭连接

    }

    // 删除操作 删除id为1的记录

    @Test
    public void testDelete () throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        String sql = "delete from employee where eid = ?";
//        Object param = 1;
        int i = queryRunner.update(sql, 1);
    }

}
