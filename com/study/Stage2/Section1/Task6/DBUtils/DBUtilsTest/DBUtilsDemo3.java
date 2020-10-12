package com.study.Stage2.Section1.Task6.DBUtils.DBUtilsTest;

import com.study.Stage2.Section1.Task6.DBUtils.Entity.Employee;
import com.study.Stage2.Section1.Task6.Utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 *
 * 需求：
 * 查询id为5的记录,封装到数组中
 * 查询所有数据,封装到List集合中
 */
public class DBUtilsDemo3 {


    // 查询id为5的记录,封装到数组中

    @Test
    public void testFindById() throws SQLException {
        // 1、创建QueryRunner
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        // 2、编写sql
        String sql = "select * from employee where eid = ?";
        // 3、执行查询
        Object[] result = queryRunner.query(sql, new ArrayHandler(), 5);
        // 4、获取数据
        System.out.println("result = " + Arrays.toString(result));
    }

    // 查询所有数据,封装到List集合中

    @Test
    public void testFindAll2List () throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        String sql = "select * from employee";
        List<Object[]> result = queryRunner.query(sql, new ArrayListHandler());
        for (Object[] obj : result) {
            System.out.println("obj = " + Arrays.toString(obj));
        }
    }

    // 查询id为5的记录,封装到JavaBean中

    @Test
    public void testFindById2Bean () throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        String sql = "select * from employee where eid = ?";
        Employee employee = queryRunner.query(sql, new BeanHandler<Employee>(Employee.class), 5);
        System.out.println("employee = " + employee);
    }

    // 查询薪资大于 3000 的所员工信息,封装到JavaBean中再封装到List集合中

    @Test
    public void testFind2BeanList () throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        String sql = "select * from employee where salary > ?";
        List<Employee> employeeList = queryRunner.query(sql, new BeanListHandler<Employee>(Employee.class), 3000);
        for (Employee employee : employeeList) {
            System.out.println("employee = " + employee);
        }
    }

    // 查询姓名是 张百万的员工信息,将结果封装到Map集合中

    @Test
    public void testFind2Map () throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        String sql = "select * from employee where ename = ?";
        Map<String, Object> objectMap = queryRunner.query(sql, new MapHandler(), "张百万");
        System.out.println("objectMap = " + objectMap);
    }


    // 查询所有员工的薪资总额

    @Test
    public void testFindTotalSalary () throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        String sql = "select sum(salary) from employee";
        Double sum = queryRunner.query(sql, new ScalarHandler<Double>());
        System.out.println("sum = " + sum);
    }

}
