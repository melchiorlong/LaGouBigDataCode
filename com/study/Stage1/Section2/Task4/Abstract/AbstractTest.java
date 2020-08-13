package com.study.Stage1.Section2.Task4.Abstract;

public abstract class AbstractTest {
    private  int cnt;

    public AbstractTest() {
    }

    public AbstractTest(int cnt) {
        setCnt(cnt);
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public abstract void show();

    public static void main(String[] args) {

    }




}
