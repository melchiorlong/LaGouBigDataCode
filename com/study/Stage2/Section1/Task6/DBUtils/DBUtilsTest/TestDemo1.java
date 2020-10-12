package com.study.Stage2.Section1.Task6.DBUtils.DBUtilsTest;

import com.study.Stage2.Section1.Task6.Utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;

/**
 * @author Administrator
 */
public class TestDemo1 {

    // QueryRunner 核心类的创建方式

    public static void main(String[] args) {

        // 方式1 手动模式
        QueryRunner qr1 = new QueryRunner();

        // 方式2 自动模式 提供数据库连接池对象 DBUtils会自动连接

        QueryRunner qr2 = new QueryRunner(DruidUtils.getDataSource());


    }

}
