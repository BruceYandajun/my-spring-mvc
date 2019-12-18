package com.github.bruce.java8.date;

import java.time.*;

import static com.github.bruce.utils.BaseUtil.line;

public class LocalDateTimeTest {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        line("date:" + date);
        LocalTime time = LocalTime.now();
//        LocalDateTime localDateTime = LocalDateTime.of(date, time);
        LocalDateTime localDateTime = LocalDateTime.of(2014, Month.MARCH, 8, 13, 45, 20);
//        LocalDateTime localDateTime = date.atTime(time);
//        LocalDateTime localDateTime = date.atTime(13, 45, 20);
//        LocalDateTime localDateTime = time.atDate(date);
        line("DateTime: " + localDateTime.toString().replace("T", " "));

        LocalDateTime now = LocalDateTime.now();
        ZoneOffset offset = ZonedDateTime.now().getOffset();
        line(now.toEpochSecond(offset));// seconds
        line(System.currentTimeMillis());// milliseconds
        LocalDateTime fourWeeksLater = now.plusWeeks(4);
        line(fourWeeksLater);
        line(Instant.now().toEpochMilli());
        line(offset);
        line(LocalDateTime.ofEpochSecond(now.toEpochSecond(offset), 0, offset).plusWeeks(4));

        yesterdayStartTime();
        todayStartTime();
    }

    private static void yesterdayStartTime() {
        long l = LocalDateTime.now().minusDays(1).withHour(0).withMinute(0).withSecond(0).withNano(0).toEpochSecond(ZonedDateTime.now().getOffset());
        line(l);
    }

    private static void todayStartTime() {
        LocalDateTime localDateTime = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0).withNano(0);
        line(localDateTime);
    }
}
