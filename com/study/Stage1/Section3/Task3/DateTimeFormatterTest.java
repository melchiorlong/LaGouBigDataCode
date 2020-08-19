package com.study.Stage1.Section3.Task3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class DateTimeFormatterTest {

    public static void main(String[] args) {

//        获取当前系统日期时间并打印
        LocalDateTime now = LocalDateTime.now();
        System.out.println("系统当前时间是：" + now);

//        按照指定格式准备一下个DateTimeFormatter

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

//        实现日时间向字符串类型的转换并打印
        String str = dateTimeFormatter.format(now);
        System.out.println("转换为字符串类型是 ： " + str);

//        实现字符串类型到日期时间类型的转换并打印
        TemporalAccessor parse = dateTimeFormatter.parse(str);
        System.out.println("转回格式后： " + parse);

    }

}
