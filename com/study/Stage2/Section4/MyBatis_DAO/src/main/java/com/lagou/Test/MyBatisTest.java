package com.lagou.Test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lagou.domain.User;
import com.lagou.mapper.UserMapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 */
public class MyBatisTest {

    @Test
    public void test1() throws IOException {


        // 通过mapper代理方式
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 当前返回的是
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findUserById(1);
        System.out.println("user = " + user);
        sqlSession.close();
    }

    @Test
    public void test2() throws IOException {


        // 通过mapper代理方式
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 当前返回的是
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.findAllResultMap();
        for (User user : users) {
            System.out.println("user = " + user);
        }
        sqlSession.close();
    }


    @Test
    public void test3() throws IOException {


        // 通过mapper代理方式
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 当前返回的是
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.findByUserName("%自动%");
        for (User user : users) {
            System.out.println("user = " + user);
        }
        sqlSession.close();
    }

    @Test
    public void test4() throws IOException {


        // 通过mapper代理方式
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setUsername("凯特琳");
        user.setAddress("皮尔特沃夫");
        user.setSex("女");
        user.setBirthday(new Date());
        System.out.println("user = " + user);

        mapper.savaUser(user);
        System.out.println("user = " + user);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test5() throws IOException {


        // 通过mapper代理方式
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setUsername("凯特琳");

        List<User> byIdAndUsernameIf = mapper.findByIdAndUsernameIf(user);
        for (User user1 : byIdAndUsernameIf) {
            System.out.println("user1 = " + user1);
        }

        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void test6() throws IOException {


        // 通过mapper代理方式
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setId(7);
        user.setUsername("快乐风男");
        user.setAddress("比尔吉沃特");
        user.setSex("男");
        user.setBirthday(new Date());

        System.out.println("user = " + user);

        mapper.updateIf(user);
        sqlSession.close();
    }

    @Test
    public void test7() throws IOException {


        // 通过mapper代理方式
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<Integer> idList = new ArrayList<>();
        idList.add(1);
        idList.add(2);
        idList.add(3);
        List<User> users = mapper.findByList(idList);

        for (User user : users) {
            System.out.println("user = " + user);
        }

        sqlSession.close();
    }


    //核心配置文件深入

    @Test
    public void test8() throws IOException {

        // 通过mapper代理方式
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        // 设置分页参数
        PageHelper.startPage(1, 2);

        List<User> users = mapper.findAllResultMap();
        for (User user : users) {
            System.out.println("user = " + user);
        }

        // 获取分页相关的其他参数
        PageInfo<User> userPageInfo = new PageInfo<User>(users);
        System.out.println("总条数 = " + userPageInfo.getTotal());
        System.out.println("总页数 = " + userPageInfo.getPages());


        sqlSession.close();
    }

}
