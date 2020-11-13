package com.lagou.test;

import com.lagou.domain.Orders;
import com.lagou.domain.User;
import com.lagou.mapper.OrderMapper;
import com.lagou.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Administrator
 */
public class MyBatisTest {

    // 一对一关联查询

    @Test
    public void test1() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession(true);
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);

        List<Orders> allWithUsers = mapper.findAllWithUsers();
        for (Orders allWithUser : allWithUsers) {
            System.out.println("allWithUser = " + allWithUser);
        }

        sqlSession.close();
    }


    // 一对一关联查询

    @Test
    public void test2() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> allWithOrders = mapper.findAllWithOrders();
        for (User allWithOrder : allWithOrders) {
            System.out.println("allWithOrder = " + allWithOrder);
        }

        mapper.findAllWithOrders();

        sqlSession.close();
    }




    // 多对多关联查询

    @Test
    public void test3() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> allUserWithRole = mapper.findAllUserWithRole();
        for (User user : allUserWithRole) {
            System.out.println("user = " + user);
        }

        mapper.findAllWithOrders();

        sqlSession.close();
    }



    // 一对一嵌套查询

    @Test
    public void test4() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession(true);
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);

        List<Orders> allWithUsers2 = mapper.findAllWithUsers2();
        for (Orders orders : allWithUsers2) {
            System.out.println("orders = " + orders);
        }

        sqlSession.close();
    }


    // 一对多嵌套查询

    @Test
    public void test5() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> allWithOrders2 = mapper.findAllWithOrders2();
        for (User user : allWithOrders2) {
            System.out.println("user = " + user);
        }

        sqlSession.close();
    }


    // 多对多嵌套查询

    @Test
    public void test6() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> allUserWithRole2 = mapper.findAllUserWithRole2();
        for (User user : allUserWithRole2) {
            System.out.println("user = " + user);
        }


        sqlSession.close();
    }

}
