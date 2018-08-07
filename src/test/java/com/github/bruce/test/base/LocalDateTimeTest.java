package com.github.bruce.test.base;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class LocalDateTimeTest {

    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.now().minusDays(1).withHour(0).withMinute(0).withSecond(0);

        System.out.println(Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant()));
    }
}
