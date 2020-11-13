package com.lagou.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Administrator
 * 连接工具类，从数据源中获取一个连接，并将实现和线程的绑定
 * ThreadLocal：线程内部的存储类，可以再指定的线程内存储数据
 * key: threadLocal(当前线程)
 * value: 任意类型的值
 */

@Component
public class ConnectionUtils {

    @Autowired
    private DataSource dataSource;

    private ThreadLocal<Connection> threadLocal = new ThreadLocal<>();


    /*
     * 获取当前线程上绑定的连接
     * 如果获取到的连接为空
     * 那么就要从数据源中获取连接
     * 并放到ThreadLocal中 (绑定到当前线程)
     */

    public Connection getThreadConnection() {

        // 从ThreadLocal上获取连接
        Connection connection = threadLocal.get();
        if (connection == null) {
            // 从数据源中获取连接 并存入ThreadLocal中
            try {
                connection = dataSource.getConnection();
                // 存入ThreadLocal中
                threadLocal.set(connection);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return connection;
    }

    public void removeThreadConnection(){
        threadLocal.remove();
    }


}
