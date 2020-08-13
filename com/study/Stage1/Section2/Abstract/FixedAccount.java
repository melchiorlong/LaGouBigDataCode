package com.study.Stage1.Section2.Abstract;

import java.security.PublicKey;

public class FixedAccount extends Accout {

    public FixedAccount() {
    }

    public FixedAccount(int i) {
        super(i);
    }

    @Override
    public double getLixi() {
//        利息 = 本金 * 利率 * 时间
        return getMoney() * 0.03 * 1;
    }

    //    声明一个Account类型的引用，指向子类类型的对象，形成多态
    public static void main(String[] args) {

        Accout acc = new FixedAccount(1000);
        Accout acc1 = new FixedAccount();
        acc1.setMoney(2000);
        double lixi = acc.getLixi();
        double lixi2 = acc1.getLixi();
        System.out.println("计算的利息是" + lixi);
        System.out.println("计算的利息是" + lixi2);
    }

}
