package com.github.bruce.java8.date;

import java.time.Duration;
import java.time.Period;
import java.time.temporal.ChronoUnit;

import static com.github.bruce.utils.BaseUtil.line;

public class DurationAndPeriod {
    public static void main(String[] args) {
//        Duration threeMinutes = Duration.ofMinutes(3);
        Duration threeMinutes = Duration.of(3, ChronoUnit.MINUTES);

        line(threeMinutes);
        Period tenDays = Period.ofDays(10);
        Period threeWeeks = Period.ofWeeks(3);
        Period twoYearsSixMonthsOneDay = Period.of(2, 6, 1);

        line(tenDays);
    }
}
