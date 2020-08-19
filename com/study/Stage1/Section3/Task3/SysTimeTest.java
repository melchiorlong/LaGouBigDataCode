package com.study.Stage1.Section3.Task3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SysTimeTest {

    public static void main(String[] args) throws Exception {

//        获取当前时间距离1970年1月1日0分0秒的毫秒数
        long cur_time = System.currentTimeMillis();
        System.out.println(cur_time);

        Date d2 = new Date(cur_time);
        System.out.println(d2);

//        long mesc = d2.getTime();
//        System.out.println(mesc);

//        d2.setTime(2000);
//        System.out.println(d2);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String str_date = sdf.format(cur_time);
        System.out.println(str_date);

        Date parse = sdf.parse(str_date);
        System.out.println(parse);



















    }
}
