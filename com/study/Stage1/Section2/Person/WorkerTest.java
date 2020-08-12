package com.study.Stage1.Section2.Person;

public class WorkerTest {

    public static void main(String[] args) {
        Worker w1 = new Worker();
        w1.show();

        System.out.println("--------------------------------------------------");
        Worker worker1 = new Worker("张三", 18,3000);
        worker1.show();
        worker1.eat("豆芽");
        worker1.play("LOL");



    }
}
