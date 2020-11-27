package com.lagou.service;

import com.lagou.common.ServerResponse;

import java.util.Map;

/**
 * @author Administrator
 */
public interface IIndustryService {

    /**
     * 统计各个城市招聘人数情况
     */
    ServerResponse<Map<String, Object>> countCityData();

    /**
     * 统计热门行业招聘信息Top10
     */
    ServerResponse<Map<String, Object>> getIndustryTop10();
    /**
     * 平均工资最高的前10的城市
     */
    ServerResponse<Map<String, Object>> salaryTop();
}
