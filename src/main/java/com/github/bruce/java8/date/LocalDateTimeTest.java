package com.github.bruce.java8.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

import static com.github.bruce.utils.BaseUtil.line;

public class LocalDateTimeTest {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
//        LocalDateTime localDateTime = LocalDateTime.of(date, time);
        LocalDateTime localDateTime = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45, 20);
//        LocalDateTime localDateTime = date.atTime(time);
//        LocalDateTime localDateTime = date.atTime(13, 45, 20);
//        LocalDateTime localDateTime = time.atDate(date);
        line("DateTime: " + localDateTime.toString().replace("T", " "));
    }
}
