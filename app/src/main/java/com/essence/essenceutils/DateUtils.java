package com.essence.essenceutils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateUtils {
    public static String TAG = DateUtils.class.getSimpleName();

    static final String DATE_FORMAT_yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";
    static final String DATE_FORMAT_MMMM_dd_yyyy_hh_mm_a = "MMMM dd, yyyy hh:mm a";
    static final String DATE_FORMAT_UTC = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    static final String UTC = "UTC";

    public static Date convertUTCStringToDate(String utcDateString) throws Exception {
        SimpleDateFormat dateFormatter;
        dateFormatter = new SimpleDateFormat(DATE_FORMAT_UTC);
        dateFormatter.setTimeZone(TimeZone.getTimeZone(UTC));
        Date utcDate = dateFormatter.parse(utcDateString);
        return utcDate;
    }

    public static String convertToDateUTCString(Date date) throws Exception {
        SimpleDateFormat dateFormatter;
        dateFormatter = new SimpleDateFormat(DATE_FORMAT_UTC);
        dateFormatter.setTimeZone(TimeZone.getTimeZone(UTC));
        String UTCString = dateFormatter.format(date);
        return UTCString;
    }

    public static String convertDateToString(Date date) {
        SimpleDateFormat dateFormatter;
        dateFormatter = new SimpleDateFormat(DATE_FORMAT_MMMM_dd_yyyy_hh_mm_a);
        dateFormatter.setTimeZone(TimeZone.getDefault());
        String formattedDate = dateFormatter.format(date);
        return formattedDate;
    }

    public static Date convertStringToDate(String dateString) throws Exception {
        SimpleDateFormat dateFormatter;
        dateFormatter = new SimpleDateFormat(DATE_FORMAT_MMMM_dd_yyyy_hh_mm_a);
        dateFormatter.setTimeZone(TimeZone.getDefault());
        Date date = dateFormatter.parse(dateString);
        return date;
    }
}
