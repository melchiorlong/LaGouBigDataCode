package com.homework.Stage1.Section4.Topic3;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author tianlong
 *  使用线程池将一个目录中的所有内容拷贝到另外一个目录中，包含子目录中的内容。
 */
public class ThreadPoolCopyTest {

    public static void main(String[] args) {
        // 1、创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        // 2、向线程池中分发方法
        executorService.execute(new CopyTask());
        // 3、关闭线程池
        executorService.shutdown();


    }
}
