package com.lagou.mapper;

import com.lagou.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Administrator
 */
public interface UserMapper {

    // 查询所有用户

    @Select("select * from user")
    public List<User> findAll();

    // 添加用户

    @Insert("insert into user (username, birthday, sex, address) values (#{username}, #{birthday}, #{sex}, #{address})")
    public void savaUser(User user);

    // 更新用户

    @Update("update user set username = #{username}, birthday = #{birthday} where id = #{id}")
    public void updateUsernameById(User user);

    // 删除用户

    @Delete("delete from user where id = #{id}")
    public void deleteUserById(Integer id);

    // 根据id查用户

    @Select("select * from user where id = #{id}")
    public User findUserById(Integer id);

    // 查询一个用户，与此同时查询出该用户具有的订单

    @Select("select * from user")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "username", column = "username"),
            @Result(property = "birthday", column = "birthday"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "address", column = "address"),
            @Result(property = "ordersList",
                    javaType = List.class,
                    column = "id",
                    many = @Many(select = "com.lagou.mapper.OrdersMapper.findOrdersByUserId"))
    })
    public List<User> findUserWithOrdersByUserId(Integer id);


    // 查询所有用户，同时查询出该用户的所有角色

    @Select("select * from user")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "username", column = "username"),
            @Result(property = "birthday", column = "birthday"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "address", column = "address"),
            @Result(property = "roleList",
                    javaType = List.class,
                    column = "id",
                    many = @Many(select = "com.lagou.mapper.RoleMapper.findRoleByUserId")
            )
    })
    public List<User> findAllUserWithRole();

}
