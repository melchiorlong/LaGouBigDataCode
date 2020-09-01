package com.study.Stage1.Section4.Task3.ProducerConsumerModule;

/**
 * @author tianlong
 * 实现一个消费者类，不断消费产品
 */
public class ConsumerThread extends Thread {

    private final WareHouse wareHouse;

    public ConsumerThread(WareHouse wareHouse) {
        this.wareHouse = wareHouse;
    }

    @Override
    public void run() {
        while (true) {
            try {
                wareHouse.consume();
                Thread.sleep(120);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
