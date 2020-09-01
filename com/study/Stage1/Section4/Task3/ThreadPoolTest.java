package com.study.Stage1.Section4.Task3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Administrator
 * 创建线程池
 * 向线程池中分配任务
 * 关闭线程池
 */
public class ThreadPoolTest {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.submit(new ThreadCallableTest());

        executorService.shutdown();

    }
}
