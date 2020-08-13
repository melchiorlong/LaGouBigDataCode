package com.study.Stage1.Section2.Abstract;

public abstract class Accout {

    private int money;

    public Accout() {
    }

    public Accout(int money) {
        setMoney(money);
    }

    public void setMoney(int money) {
        if (money >0){
            this.money = money;
        }else{
            System.out.println("金额不合理");
        }
    }

    public int getMoney() {
        return money;
    }

//    自定义抽象方法 实现计算利息并返回

    public abstract double getLixi();
}
