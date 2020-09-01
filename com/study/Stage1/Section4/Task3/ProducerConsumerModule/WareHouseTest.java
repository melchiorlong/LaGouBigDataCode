package com.study.Stage1.Section4.Task3.ProducerConsumerModule;

/**
 * @author tianlong
 * 仓库类实现代码
 */
public class WareHouseTest {

    public static void main(String[] args) {
//        创建仓库类对象
        WareHouse wareHouse = new WareHouse();
//        创建线程类对象并启动
        Thread produceThread = new ProducerThread(wareHouse);
        Thread consumeThread = new ConsumerThread(wareHouse);
        produceThread.start();
        consumeThread.start();

    }
}
