package com.lagou.test;

import com.lagou.Dao.IUserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Administrator
 */
public class SpringTest {

    @Test
    public void test1 (){

        // 获取到Spring上下文对象 借助上下文对象可以获取到ioc容器中的bean对象
        ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        IUserDao userDao = (IUserDao) classPathXmlApplicationContext.getBean("userDao");
        userDao.save();

    }


}
