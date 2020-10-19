package com.lagou.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

/**
 * @author Administrator
 * <p>
 * 需求
 * 将User对象 转为json字符串
 *
 * Jackson常用对象和方法
 * ObjectMapper对象 可以将java对象转成json
 * writeValueAsString(Java对象) --> 返回值是个json
 * jackson中常用注解
 * 1、@JsonIgnore  生成的json忽略某个属性
 * 2、@JsonFormat(pattern = "YYYY-MM-dd")  生成的json转换格式
 *
 */
public class JacksonDemo {

    public static void main(String[] args) throws JsonProcessingException {

//        methodObject();
//        methodList();
        Map<String, User> userMap = new HashMap<>();
        userMap.put("no1", new User("赵信",30,new Date(),"德玛西亚"));
        userMap.put("no2", new User("诺手",25,new Date(),"诺克萨斯"));
        userMap.put("no3", new User("艾希",30,new Date(),"弗雷尔卓德"));

        ObjectMapper om = new ObjectMapper();
        String userMapJson = om.writeValueAsString(userMap);
        System.out.println("userMapJson = " + userMapJson);


    }

    private static void methodList() throws JsonProcessingException {
//        List转Json
        List<User> userList = new ArrayList<>();
        userList.add(new User("赵信",30,new Date(),"德玛西亚"));
        userList.add(new User("诺手",25,new Date(),"诺克萨斯"));
        userList.add(new User("艾希",30,new Date(),"弗雷尔卓德"));

        ObjectMapper om = new ObjectMapper();
        String userListJson = om.writeValueAsString(userList);
        System.out.println("userListJson = " + userListJson);
    }

    private static void methodObject() throws JsonProcessingException {
        User user = new User("老王", 30, new Date(), "北京");

//        创建jackson核心对象
        ObjectMapper om = new ObjectMapper();
//        调用writeValueAsString()方法 将user转为json
        String jsonobj = om.writeValueAsString(user);
        System.out.println("jsonobj = " + jsonobj);
//        jsonobj = {"username":"老王","age":30,"birthday":1603134541620,"address":"北京"}
    }
}
