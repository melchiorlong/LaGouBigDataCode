package com.lagou.mapper;

import com.lagou.vo.ConverterVo;
import com.lagou.vo.IndustryVo;
import com.lagou.vo.SalaryTopVo;

import java.util.List;

/**
 * @author Administrator
 */
public interface IndustryMapper {

    /**
     * 统计各个城市招聘情况
     * @return
     */
    List<ConverterVo> countCityPosition();

    List<IndustryVo> countIndustryTop();

    List<SalaryTopVo> salaryTop();
}
