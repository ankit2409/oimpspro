package com.example.demo.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.TimeZone;

public class TimeConversion {
    public static String DATE_FORMAT_DD_MM_YYYY_HH_MM_SS = "dd/MM/yyyy HH:mm:ss";
    public static String convertEpochTimeToIST(long time) {
//    public static void main(String[] args) {
        Date date = new Date(1708756235352L);
        DateFormat format = new SimpleDateFormat(DATE_FORMAT_DD_MM_YYYY_HH_MM_SS);
        format.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
        String formatted = format.format(date);
        System.out.println(formatted);
        format.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
        formatted = format.format(date);
        System.out.println(formatted);
        return formatted;
    }

    public static ZonedDateTime StringToEpochTime(Long publishedTimeMillis) {
        Instant publishedTimeInstant = Instant.ofEpochMilli(publishedTimeMillis);

        // Convert Instant to ZonedDateTime in desired time zone (optional)
// Replace "Asia/Kolkata" with your desired time zone if needed
        ZonedDateTime publishedTimeZonedDateTime = publishedTimeInstant.atZone(ZoneId.of("Asia/Kolkata"));
        return publishedTimeZonedDateTime;
    }
}
