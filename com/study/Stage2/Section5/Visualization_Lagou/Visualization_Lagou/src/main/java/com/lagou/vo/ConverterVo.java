package com.lagou.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Administrator
 *
 * 转换对象
 * 把数据库中封装好的数据
 * 转为name:xxx,value:xxx
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConverterVo {

    private String name;
    private String value;

}
