package com.study.Stage1.Section4.Task3.ProducerConsumerModule;

/**
 * @author tianlong
 * 编程实现一个仓库类
 */
public class WareHouse {


    private int productionNum = 0;
    private static final int MAX_PRODUCTION_NUM = 10;

    public synchronized void produceProducts() throws InterruptedException {

        notify();
        if (productionNum < MAX_PRODUCTION_NUM) {
            System.out.println("线程" + Thread.currentThread().getName() + "正在生产第" + (productionNum + 1) + "个产品");
            productionNum += 1;
        } else {
            wait();
        }
    }

    public synchronized void consume() throws InterruptedException {

        notify();
        if (productionNum > 0) {
            System.out.println("线程" + Thread.currentThread().getName() + "正在消费第" + productionNum + "个产品");
            productionNum -= 1;
        } else {
            wait();
        }

    }
}
