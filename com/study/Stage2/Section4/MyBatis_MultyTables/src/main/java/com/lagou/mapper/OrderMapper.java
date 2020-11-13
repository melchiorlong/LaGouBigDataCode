package com.lagou.mapper;

import com.lagou.domain.Orders;
import com.lagou.domain.Role;

import java.util.List;

/**
 * @author Administrator
 */
public interface OrderMapper {

    // 1对1关联查询
    // 查询所有订单 同事查出每个订单所属的用户信息

    public List<Orders> findAllWithUsers();

    // 查询一个订单，与此同时查询出该订单所属的用户

    public List<Orders> findAllWithUsers2();

    // 根据用户id查询Orders

    public List<Orders> findOrdersByUserId(Integer uid);



}
