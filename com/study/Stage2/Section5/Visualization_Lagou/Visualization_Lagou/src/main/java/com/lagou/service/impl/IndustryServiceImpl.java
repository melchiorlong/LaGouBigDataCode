package com.lagou.service.impl;

import com.lagou.common.ServerResponse;
import com.lagou.mapper.IndustryMapper;
import com.lagou.service.IIndustryService;
import com.lagou.vo.ConverterVo;
import com.lagou.vo.IndustryVo;
import com.lagou.vo.SalaryTopVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */

@Service
public class IndustryServiceImpl implements IIndustryService {

    @Autowired
    private IndustryMapper industryMapper;

    /**
     * 统计各个城市招聘人数情况
     *
     * @return
     */
    @Override
    public ServerResponse<Map<String, Object>> countCityData() {
        // 统计各个城市招聘人数情况， 创建一个对象封装查询到的数据 list
        List<ConverterVo> cityPositionList = industryMapper.countCityPosition();

        // 创建Map<String, Object> 用于存放总数据
        Map<String, Object> map = new HashMap<>();

        // 创建3个List集合，分别是:
        // cityNameList: 存放城市名称
        // thirdList: 存放前三名城市数据
        // dataList: 存放十个城市数据
        List<String> cityNameList = new ArrayList<>();
        List<ConverterVo> thirdList = new ArrayList<>();
        List<ConverterVo> dataList = new ArrayList<>();

        // 循环list 给三个list添加数据
        for (ConverterVo converterVo : cityPositionList) {
            // 设置城市名称
            cityNameList.add(converterVo.getName());
            // 设置thirdList
            if (thirdList.size() < 3) {
                thirdList.add(converterVo);
            }
            // 设置dataList
            dataList.add(converterVo);

        }

        // 把3个list中的数据存到Map中
        map.put("cityNameList", cityNameList);
        map.put("thirdList", thirdList);
        map.put("dataList", dataList);

        // 把Map中的数据存放到ServerResponse中
        return ServerResponse.createBySuccessData(map);
    }

    /**
     * 统计热门行业招聘信息Top10
     */
    @Override
    public ServerResponse<Map<String, Object>> getIndustryTop10() {
        // 查询最热门的10个行业 List<IndustryVo>
        List<IndustryVo> list = industryMapper.countIndustryTop();

        // 创建Map封装所有数据
        Map<String, Object> map = new HashMap<>();

        // 创建2个list， namesList：行业名称  countList：行业数量
        List<String> positionNameList = new ArrayList<>();
        List<Long> numList = new ArrayList<>();

        // 将数据循环插入到list中
        for (IndustryVo industryVo : list) {
            positionNameList.add(industryVo.getPositionName());
            numList.add(industryVo.getNum());
        }

        // 将list存入map
        map.put("positionNameList", positionNameList);
        map.put("numList", numList);

        // 将map放入ServerResponse
        return ServerResponse.createBySuccessData(map);
    }


    /**
     * 平均工资最高的前10的城市
     */
    @Override
    public ServerResponse<Map<String, Object>> salaryTop() {
// 查询最热门的10个行业 List<IndustryVo>
        List<SalaryTopVo> list = industryMapper.salaryTop();

        // 创建Map封装所有数据
        Map<String, Object> map = new HashMap<>();

        // 创建2个list， namesList：行业名称  countList：行业数量
        List<String> cityNameList = new ArrayList<>();
        List<Double> salaryList = new ArrayList<>();

        // 将数据循环插入到list中
        for (SalaryTopVo salaryTopVo : list) {
            cityNameList.add(salaryTopVo.getPositionCity());
            salaryList.add(salaryTopVo.getAvgSalary());
        }

        // 将list存入map
        map.put("cityNameList", cityNameList);
        map.put("salaryList", salaryList);

        // 将map放入ServerResponse
        return ServerResponse.createBySuccessData(map);
    }
}
