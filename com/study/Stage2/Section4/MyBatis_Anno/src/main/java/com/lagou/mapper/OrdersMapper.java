package com.lagou.mapper;

import com.lagou.domain.Orders;
import com.lagou.domain.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author Administrator
 */
public interface OrdersMapper {

    // 查询所有订单,同时查询订单所属的用户信息

    @Select("select * from orders")
    @Results({ // 代替resultMap 标签
            @Result(property = "id", column = "id", id = true),
            @Result(property = "ordertime", column = "ordertime"),
            @Result(property = "total", column = "total"),
            @Result(property = "uid", column = "uid"),
            @Result(property = "user",
                    javaType = User.class,
                    column = "uid",
                    one = @One(select = "com.lagou.mapper.UserMapper.findUserById", fetchType = FetchType.EAGER))
    })
    public List<Orders> findAllOrdersWithUser();

    // 根据用户id查询订单

    @Select("select * from orders where uid = #{id}")
    public List<Orders> findOrdersByUserId(Integer id);


}
