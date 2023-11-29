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
}
