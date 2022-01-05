package com.example.evokeshedul.Util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTime {

    public static String GetTodayDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date now = new Date();

        return sdf.format(now);
    }

    public static String GetTodayTime(){
        Calendar now1 = Calendar.getInstance();
        now1.add(Calendar.MINUTE, 5);
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:00");
        return df.format(now1.getTime());
    }
}
