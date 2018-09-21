package com.github.bruce.java8.date.format;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.github.bruce.utils.BaseUtil.line;

public class DateFormatTest {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2014, 3, 18);
        line(date.format(DateTimeFormatter.BASIC_ISO_DATE));
        line(date.format(DateTimeFormatter.ISO_LOCAL_DATE));

        line(LocalDate.parse("20140318", DateTimeFormatter.BASIC_ISO_DATE));
        line(LocalDate.parse("2014-03-18", DateTimeFormatter.ISO_LOCAL_DATE));
    }
}
