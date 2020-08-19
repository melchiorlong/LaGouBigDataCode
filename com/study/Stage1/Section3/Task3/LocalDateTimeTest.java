package com.study.Stage1.Section3.Task3;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeTest {

    public static void main(String[] args) {

        LocalDate localDate = LocalDate.now();
        LocalTime localtime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localtime);
        System.out.println(localDateTime);

//        设置参数，指定年月日

        LocalDateTime localDateTime1 = LocalDateTime.of(1993, 4, 1, 15, 0, 0);
        System.out.println(localDateTime1);

        LocalDateTime localDateTime2 = localDateTime1.withYear(2008).withMonth(8).withDayOfMonth(8).withHour(20).withMinute(8).withSecond(8);
        System.out.println(localDateTime1);
        System.out.println(localDateTime2);

        LocalDateTime localDateTime3 = localDateTime2.plusYears(12);
        System.out.println(localDateTime3);

        String localdatetime_str = localDateTime3.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println(localdatetime_str);



    }

}
