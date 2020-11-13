package com.lagou.domain;

import java.util.Date;

public class Orders {

    private Integer id;
    private Date ordertime;
    private double total;
    private Integer uid ;

    private User user;

    public Orders() {
    }

    public Orders(Integer id, Date ordertime, double total, Integer uid) {
        this.id = id;
        this.ordertime = ordertime;
        this.total = total;
        this.uid = uid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }


    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", ordertime=" + ordertime +
                ", total=" + total +
                ", uid=" + uid +
                ", user=" + user +
                '}';
    }
}
