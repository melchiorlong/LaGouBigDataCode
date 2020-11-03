package com.lagou.homework.DAO;

import com.lagou.homework.domain.User;
import com.lagou.homework.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserVerifying {

    public User userVerifying (String username, String password) throws SQLException {

        String sql = "select * from user where fusername = ? and fpassword = ?";
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        Object[] params = {username, password};
        User user = queryRunner.query(sql, new BeanHandler<>(User.class), params);
        return user;
    }
}
