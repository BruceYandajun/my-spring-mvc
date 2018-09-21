package com.github.bruce.java8.date.zone;

import java.time.*;
import java.util.TimeZone;

import static com.github.bruce.utils.BaseUtil.line;

public class ZoneTest {
    public static void main(String[] args) {
        ZoneId romeZone = ZoneId.of("Europe/Rome");
        line(romeZone);
        ZoneId zoneId = TimeZone.getDefault().toZoneId();
        line(zoneId);

        LocalDate date = LocalDate.of(2014, Month.MARCH, 18);
        line(date.atStartOfDay(romeZone));
        LocalDateTime dateTime = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45);
        line(dateTime.atZone(romeZone));
        Instant instant = Instant.now();
        line(instant.atZone(romeZone));
    }
}
