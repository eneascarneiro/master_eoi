package com.example.demo.utils;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    private static final DateTimeFormatter DATE_FORMATER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static String dateToString(ZonedDateTime date) {
        return date != null ? date.format(DATE_FORMATER) : null;
    }

    public static ZonedDateTime stringToDate(String stringDate) {
        return ZonedDateTime.parse(stringDate, DATE_FORMATER.withZone(ZoneId.of("UTC")));
    }
}
