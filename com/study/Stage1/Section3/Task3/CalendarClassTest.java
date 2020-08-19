package com.study.Stage1.Section3.Task3;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalendarClassTest {

    public static void main(String[] args) {

//        使用过时的方法，指定年月日 时分秒

        Date d1 = new Date(2008 - 1900,8 -1,8,20,8,8);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s1 = sdf.format(d1);
        System.out.println("获取到的时间是 = " + s1);
//      使用取代的方式，指定年月日时分秒


        Calendar instance = Calendar.getInstance();
        instance.set(1993,Calendar.MARCH,12,14,0,0);
        System.out.println("我的生日是：" + sdf.format(instance.getTime()));

        Calendar calendar = new GregorianCalendar();
        calendar.set(1993, Calendar.APRIL,1,15,0,0);
        System.out.println("11的生日是：" + sdf.format(calendar.getTime()));


    }



}
