package com.lagou.mapper;

import com.lagou.domain.Role;

import java.util.List;

public interface RoleMapper {
    // 根据用户id主键，查询角色列表

    public List<Role> findRoleByUserId(Integer userid);

}
