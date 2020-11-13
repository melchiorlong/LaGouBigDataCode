package com.lagou.homework.DAO;



import com.lagou.homework.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * @author Administrator
 */
public class CheckUserIsExist {

    public boolean isExist(String username) throws SQLException {
        int isExist = 0;
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        String sql = "select count(fusername) from user where fusername = ?";
        isExist = queryRunner.query(sql, new BeanHandler<>(Integer.class), username);
        return isExist > 0;
    }
}
