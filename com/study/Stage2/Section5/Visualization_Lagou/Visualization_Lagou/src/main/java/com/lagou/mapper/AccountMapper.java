package com.lagou.mapper;

import org.apache.ibatis.annotations.Param;

public interface AccountMapper {

    public void transferIn(@Param("name") String name, @Param("money") Double money);

    public void transferOut(@Param("name") String name, @Param("money") Double money);

}
