package com.lagou.homework.DAO;

import com.lagou.homework.domain.Student;
import com.lagou.homework.domain.User;
import com.lagou.homework.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

/**
 * @author Administrator
 */
public class AddFacade {

    public static void add(User user) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        String sql = "insert into user values(?,?,?)";
        Object[] params = {null, user.getFUserName(), user.getFPassword()};
        queryRunner.update(sql, params);

    }

    public static void add(Student student) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        String sql = "insert into student values(?,?,?,?,?)";
        Object[] params = {null, student.getFName(), student.getFNumber(), student.getGender(), student.getBirthDate()};
        queryRunner.update(sql, params);
    }

}
