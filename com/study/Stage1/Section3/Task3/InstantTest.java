package com.study.Stage1.Section3.Task3;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class InstantTest {

    //    使用instant类获取当前系统时间
    public static void main(String[] args) {
        Instant now = Instant.now();
        System.out.println("直接获取的时间= " + now);
        System.out.println("-------------------------------------------------------------");

        OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.ofHours(8));
        System.out.println("偏移后的时间是 " + offsetDateTime);
        System.out.println("-------------------------------------------------------------");

        Instant now1 = Instant.now();
        long g1 = now1.getEpochSecond();
        System.out.println(g1);
        Instant instant = Instant.ofEpochSecond(g1);
        System.out.println(instant);
    }
}
