package com.lagou.test;

import com.lagou.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 */
public class MyBatisTest {

    @Test
    public void mybatisTest() throws IOException {

        // 1 加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        // 2 获取sqlSessionFactory工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        // 3 获取SQLSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 4 执行sql
        List<User> users = sqlSession.selectList("user.selectAll");

        // 5 遍历打印结果
        for (User user : users) {
            System.out.println("user = " + user);
        }

        // 6 关闭资源
        sqlSession.close();
    }

    @Test
    public void insertTest() throws IOException {

        // 1 加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        // 2 获取sqlSessionFactory工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        // 3 获取SQLSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 4 执行sql
        User user = new User();
        user.setUsername("jack");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("东城");
        sqlSession.insert("user.saveUser", user);

        // commit
        sqlSession.commit();


        // 6 关闭资源
        sqlSession.close();

    }

    @Test
    public void updateTest() throws IOException {

        // 1 加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        // 2 获取sqlSessionFactory工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        // 3 获取SQLSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 4 执行sql
        User user = new User();
        user.setId(5);
        user.setUsername("Rose");
        user.setBirthday(new Date());
        user.setSex("女");
        user.setAddress("西城");
        sqlSession.insert("user.updateUser", user);

        // commit
        sqlSession.commit();

        // 6 关闭资源
        sqlSession.close();
    }

    @Test
    public void deleteTest() throws IOException {

        // 1 加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        // 2 获取sqlSessionFactory工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        // 3 获取SQLSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 4 执行sql
        sqlSession.delete("user.deleteUser", 5);

        // commit
        sqlSession.commit();

        // 6 关闭资源
        sqlSession.close();
    }
}