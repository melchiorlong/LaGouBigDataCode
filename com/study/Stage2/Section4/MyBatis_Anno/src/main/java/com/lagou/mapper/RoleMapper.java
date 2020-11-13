package com.lagou.mapper;

import com.lagou.domain.Role;
import org.apache.ibatis.annotations.Select;

/**
 * @author Administrator
 */
public interface RoleMapper {

    // 根据userid查询Role

    @Select("SELECT * FROM sys_role r INNER JOIN sys_user_role ur ON r.id = ur.roleid WHERE ur.userid = #{userid};")
    public Role findRoleByUserId(Integer userid);


}
