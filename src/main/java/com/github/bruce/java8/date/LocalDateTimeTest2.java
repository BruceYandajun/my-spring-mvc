package com.github.bruce.java8.date;

import java.time.LocalDateTime;

import static com.github.bruce.utils.BaseUtil.line;

public class LocalDateTimeTest2 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now().withMinute(31);
        line(now);
        LocalDateTime win1 = now.plusHours(1).withMinute(now.getMinute() < 30 ? 0 : 30).withSecond(0).withNano(0);
        line(win1);
    }
}
