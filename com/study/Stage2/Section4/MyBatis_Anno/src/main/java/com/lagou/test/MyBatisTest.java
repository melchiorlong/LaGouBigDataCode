package com.lagou.test;

import com.lagou.domain.Orders;
import com.lagou.domain.User;
import com.lagou.mapper.OrdersMapper;
import com.lagou.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MyBatisTest {

    private SqlSession sqlSession;

    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        sqlSession = sqlSessionFactory.openSession(true);
    }

    @After
    public void after() {
        sqlSession.close();
    }

    @Test
    public void testSelect() throws IOException {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.findAll();
        for (User user : users) {
            System.out.println("user = " + user);
        }
    }

    @Test
    public void testInsert() throws IOException {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setUsername("泥巴儿");
        user.setBirthday(new Date());
        user.setSex("女");
        user.setAddress("北京");
        mapper.savaUser(user);

    }

    @Test
    public void testUpdate() throws IOException {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setId(12);
        user.setUsername("小泥巴儿");
        user.setBirthday(new Date());
        user.setSex("女");
        user.setAddress("北京");
        mapper.updateUsernameById(user);

    }

    @Test
    public void testDelete() throws IOException {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUserById(7);
    }

    // 1对1查询 通过注解方式

    @Test
    public void testOne2OneSelectByAnno() throws IOException {
        OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
        List<Orders> allOrdersWithUser = mapper.findAllOrdersWithUser();
        for (Orders orders : allOrdersWithUser) {
            System.out.println("orders = " + orders);
        }
    }


    // 一对多查询 通过注解方式

    @Test
    public void testOne2ManySelectByAnno() throws IOException {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userWithOrdersByUserId = mapper.findUserWithOrdersByUserId(1);
        for (User user : userWithOrdersByUserId) {
            System.out.println();
            System.out.println("user = " + user);
            System.out.println(user.getOrdersList());
        }
    }

    // 多对多查询 通过注解方式

    @Test
    public void testMany2ManySelectByAnno() throws IOException {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userWithOrdersByUserId = mapper.findAllUserWithRole();
        for (User user : userWithOrdersByUserId) {
            System.out.println();
            System.out.println("user = " + user);
            System.out.println(user.getRoleList());
        }
    }

}
