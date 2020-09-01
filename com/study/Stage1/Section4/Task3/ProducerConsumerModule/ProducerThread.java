package com.study.Stage1.Section4.Task3.ProducerConsumerModule;

/**
 * @author tianlong
 * 编程实现生产者线程，不断生产产品
 */
public class ProducerThread extends Thread{

    /**
     * 声明一个仓库类型的引用，作为成员变量，为了能够调用仓库类中的生产方法   -> 合成复用原则
     */
    private final WareHouse wareHouse;

    /**
     * @param wareHouse
     * 为确保两个线程公用同一个仓库
     */
    public ProducerThread(WareHouse wareHouse){
        this.wareHouse = wareHouse;
    }

    @Override
    public void run() {

        while (true){
            try {
                wareHouse.produceProducts();
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
