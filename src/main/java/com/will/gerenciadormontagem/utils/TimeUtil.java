package com.will.gerenciadormontagem.utils;

import org.apache.commons.lang3.time.DateUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {

    public static Date getDate() {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date date = new Date();
            dateFormat.parse(String.valueOf(date.getTime()));
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
