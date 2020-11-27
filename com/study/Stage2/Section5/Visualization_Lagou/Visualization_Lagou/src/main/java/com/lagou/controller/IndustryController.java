package com.lagou.controller;

import com.lagou.common.ServerResponse;
import com.lagou.service.IIndustryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author Administrator
 */
@Controller
@RequestMapping("/industry")
public class IndustryController {

    @Autowired
    private IIndustryService iIndustryService;

    /**
     * 统计各个城市招聘人数情况
     * @return
     */
    @RequestMapping("/countCityPosition.do")
    @ResponseBody
    public ServerResponse<Map<String, Object>> countCityNums(){
        ServerResponse<Map<String, Object>> response = iIndustryService.countCityData();
        return response;
    }

    /**
     * 统计热门行业招聘信息Top10
     */
    @RequestMapping(value = "/countIndustryTop.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<Map<String, Object>> getIndustryTop(){
        ServerResponse<Map<String, Object>> response = iIndustryService.getIndustryTop10();
        return response;
    }

    /**
     * 平均工资最高的前10的城市
     */
    @RequestMapping(value = "/salaryTop.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<Map<String, Object>> salaryTop(){
        ServerResponse<Map<String, Object>> response = iIndustryService.salaryTop();
        return response;
    }

}
