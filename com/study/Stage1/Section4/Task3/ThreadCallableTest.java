package com.study.Stage1.Section4.Task3;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Administrator
 */
public class ThreadCallableTest implements Callable<Integer> {

    /**
     * @return 计算 1~10000的累加和
     */

    private static final int MAX_NUM = 10000;

    @Override
    public Integer call() throws Exception {
        int result = 0;
        for (int i = 1; i <= MAX_NUM; i++) {
            result += i;
        }
        System.out.println("计算的累加和result = " + result);
        return result;
    }


    public static void main(String[] args) {

        ThreadCallableTest tct = new ThreadCallableTest();
        FutureTask<Integer> ft = new FutureTask<>(tct);
        Thread t1 = new Thread(ft);
        t1.start();
        Integer sum = 0;
        try {
            sum = ft.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("线程处理后的返回值sum = " + sum);
    }
}
