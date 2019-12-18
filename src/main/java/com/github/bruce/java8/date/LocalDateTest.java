package com.github.bruce.java8.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;

import static com.github.bruce.utils.BaseUtil.line;
import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;
import static java.time.temporal.TemporalAdjusters.nextOrSame;

public class LocalDateTest {
    public static void main(String[] args) {
//        LocalDate localDate = LocalDate.of(2000, 3, 18);
        LocalDate localDate = LocalDate.parse("2000-03-08");
//        LocalDate localDate = LocalDate.now();
        line("Date: " + localDate);
        line("Year: " + localDate.getYear() + " or " + localDate.get(ChronoField.YEAR));
        line("Month: " + localDate.getMonth() + " or " + localDate.get(ChronoField.MONTH_OF_YEAR));
        line("Day of week: " + localDate.getDayOfWeek());
        line("Day of month: " + localDate.getDayOfMonth());
        line("Day of year: " + localDate.getDayOfYear());
        line("Length of month: " + localDate.lengthOfMonth());
        line("Length of year: " + localDate.lengthOfYear());
        line("Is leap year: " + localDate.isLeapYear());

        line(localDate.withYear(2010));

        line(localDate.plusDays(2));

        LocalDate date1 = LocalDate.now();
        LocalDate date2 = date1.with(nextOrSame(DayOfWeek.SUNDAY));
        line(date2);
        LocalDate date3 = date2.with(lastDayOfMonth());
        line(date3);

    }
}
