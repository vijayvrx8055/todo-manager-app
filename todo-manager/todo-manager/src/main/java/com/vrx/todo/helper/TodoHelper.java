package com.vrx.todo.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;

public class TodoHelper {

    public static Date parseDate(LocalDateTime dateStr) throws ParseException {
//        Instant instant = dateStr.toInstant(ZoneOffset.UTC);
        Instant instant = dateStr.atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }

    public static String dateToString(Date date){
        System.out.println(date);
        return date.toString();
    }

    public static java.sql.Date getCurrentDate() {
       return new java.sql.Date(System.currentTimeMillis());
        }
}
