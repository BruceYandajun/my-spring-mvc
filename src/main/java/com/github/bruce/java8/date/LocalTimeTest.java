package com.github.bruce.java8.date;

import java.time.LocalTime;

import static com.github.bruce.utils.BaseUtil.line;

public class LocalTimeTest {
    public static void main(String[] args) {
//        LocalTime localTime = LocalTime.of(12, 12, 12);
        LocalTime localTime = LocalTime.parse("12:12:11");
//        LocalTime localTime = LocalTime.now();
        line("Time: " + localTime);
        line("Hour: " + localTime.getHour());
        line("Minute: " + localTime.getMinute());
        line("Second: " + localTime.getSecond());
    }
}
